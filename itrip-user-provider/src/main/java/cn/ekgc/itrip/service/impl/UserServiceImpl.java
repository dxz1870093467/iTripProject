package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.UserDao;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.service.UserService;
import cn.ekgc.itrip.util.ActivationCodeUtil;
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
			// 产生随机激活码
			String activationCode = ActivationCodeUtil.generate();
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
}
