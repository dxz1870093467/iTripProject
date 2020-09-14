package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.enums.ActivatedEnum;
import cn.ekgc.itrip.pojo.enums.UserTypeEnum;
import cn.ekgc.itrip.pojo.vo.UserVO;
import cn.ekgc.itrip.transport.user.UserTransport;
import cn.ekgc.itrip.util.MD5Util;
import cn.ekgc.itrip.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <b>爱旅行-用户认证功能控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("authController")
@RequestMapping("/auth/api")
public class AuthController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>验证用户名是否被占用</b>
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/ckusr")
	public ResultVO checkName(String name) throws Exception {
		// 用于校验用户是否存在
		boolean isCanUsed = userTransport.queryUserCodeIsCanUsed(name);
		if (isCanUsed) {
			// 如果的到的结果为 true，则说明该用户名未被占用，可以使用
			return ResultVO.success();
		}
		return ResultVO.failure("该邮箱地址已被占用");
	}

	/**
	 * <b>使用邮箱注册</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/doregister")
	public ResultVO registerUseByEmail(@RequestBody UserVO userVO) throws Exception {
		// 校验用户所提交的邮箱是否有效
		if (ValidateUtil.checkEmail(userVO.getUserCode())
				&& ValidateUtil.checkPassword(userVO.getUserPassword())) {
			// 校验邮箱的唯一性
			if (userTransport.queryUserCodeIsCanUsed(userVO.getUserCode())) {
				// 进行用户保存
				// 将 UserVO 切换成 User
				User user = new User();
				user.setUserCode(userVO.getUserCode());
				user.setUserName(userVO.getUserName());
				user.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
				user.setUserType(UserTypeEnum.USER_TYPE_SELF.getCode());
				user.setCreationDate(new Date());
				user.setModifyDate(new Date());
				user.setActivated(ActivatedEnum.ACTIVATED_FALSE.getCode());
				// 用户类型
				boolean saveFlag = userTransport.saveUser(user);
				if (saveFlag) {
					return ResultVO.success();
				} else {
					return ResultVO.failure("保存失败");
				}
			} else {
				return ResultVO.failure("该邮箱地址已被占用");
			}
		} else {
			return ResultVO.failure("请填写正确的邮箱地址和登录密码");
		}
	}

	/**
	 * <b>使用手机注册</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/registerbyphone")
	public ResultVO registerUseByCellphone(@RequestBody UserVO userVO) throws Exception {
		// 校验用户所提交的邮箱是否有效
		if (ValidateUtil.checkCellphone(userVO.getUserCode())
				&& ValidateUtil.checkPassword(userVO.getUserPassword())) {
			// 校验邮箱的唯一性
			if (userTransport.queryUserCodeIsCanUsed(userVO.getUserCode())) {
				// 进行用户保存
				// 将 UserVO 切换成 User
				User user = new User();
				user.setUserCode(userVO.getUserCode());
				user.setUserName(userVO.getUserName());
				user.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
				user.setUserType(UserTypeEnum.USER_TYPE_SELF.getCode());
				user.setCreationDate(new Date());
				user.setModifyDate(new Date());
				user.setActivated(ActivatedEnum.ACTIVATED_FALSE.getCode());
				// 用户类型
				boolean saveFlag = userTransport.saveUser(user);
				if (saveFlag) {
					return ResultVO.success();
				} else {
					return ResultVO.failure("保存失败");
				}
			} else {
				return ResultVO.failure("该邮箱地址已被占用");
			}
		} else {
			return ResultVO.failure("请填写正确的邮箱地址和登录密码");
		}
	}
}
