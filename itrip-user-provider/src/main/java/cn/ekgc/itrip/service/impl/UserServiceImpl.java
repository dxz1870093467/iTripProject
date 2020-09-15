package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.UserDao;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.enums.ActivatedEnum;
import cn.ekgc.itrip.pojo.enums.UserTypeEnum;
import cn.ekgc.itrip.service.UserService;
import cn.ekgc.itrip.util.ActivationCodeUtil;
import cn.ekgc.itrip.util.ConstantUtils;
import cn.ekgc.itrip.util.EmailUtils;
import cn.ekgc.itrip.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <b>爱旅行-用户模块业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private SmsUtils smsUtils;

	/**
	 * <b>根据用户名校验该用户名被使用</b>
	 * @param userCode
	 * @return true-未被占用，1-已被占用
	 * @throws Exception
	 */
	@Override
	public boolean queryUserCodeIsCanUsed(String userCode) throws Exception {
		// 封装查询对象
		User query = new User();
		query.setUserCode(userCode);
		// 进行查询
		List<User> list = userDao.findListByQuery(query);
		if (list != null && list.size() > 0) {
			return false;
		}
		return true;
	}

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean saveUser(User user) throws Exception {
		// 保存用户信息
		Integer count = userDao.save(user);
		if (count > 0) {
			if (user.getUserType().equals(UserTypeEnum.USER_TYPE_SELF.getCode())) {
				// 再次将用户信息进行查询
				user = userDao.findListByQuery(user).get(0);
				// 获得用户 id，将用户 id 作为 flatID 进行设定
				user.setFlatID(user.getId());
				// 修改用户信息
				userDao.update(user);
			}
			// 产生随机激活码
			String activationCode = ActivationCodeUtil.generate();
			// 判断用户此时使用的是邮箱还是手机号
			if (user.getUserCode().indexOf("@") > -1) {
				// 此时使用的是邮箱
				// 发送邮件
				String context = "<div style='width: 600px; margin: 0 auto;'>" +
						"<h3>亲爱的：<strong>" + user.getUserCode() + "</strong></h3>" +
						"<p>您已经成功的注册成为<strong>爱旅行</strong>会员！</p>" +
						"<p>只剩下最后一步，激活您的账号，您的激活码是：<strong style='color: red;'>" + activationCode + "</strong></p>" +
						"<p>请在<strong>" + ConstantUtils.MAIL_EXPIRE + "</strong>分钟之内进行账号激活！</p></div>";
				emailUtils.sendMail(user.getUserCode(), "爱旅行用户激活", context);
			} else {
				// 使用的是手机号码
				smsUtils.sendActivationCodeByCloopen(user.getUserCode(), activationCode);
			}
			// 将激活码存储于 Redis 中，使用 userCode 作为 key
			redisTemplate.opsForValue().set(user.getUserCode(), activationCode);
			// 设定过期时间
			redisTemplate.expire(user.getUserCode(), 5, TimeUnit.MINUTES);
			System.out.println(activationCode);
			// 将激活码发送到邮箱
			return true;
		}
		return false;
	}

	/**
	 * <b>使用激活码激活用户</b>
	 * @param userCode
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean activateUser(String userCode, String code) throws Exception {
		// 通过使用 userCode 作为 key 从 Redis 中查询用户信息
		String activationCode = redisTemplate.opsForValue().get(userCode);
		if (activationCode != null) {
			// 找到对应的激活码，和用户所提交信息进行比较
			if (activationCode.equals(code)) {
				// 用户激活成功，将状态修改为已激活
				// 查询此时的用户对象
				User query = new User();
				query.setUserCode(userCode);
				User user = userDao.findListByQuery(query).get(0);
				// 设定为激活状态
				user.setActivated(ActivatedEnum.ACTIVATED_TRUE.getCode());
				userDao.update(user);
				return true;
			}
		}
		return false;
	}
}
