package cn.ekgc.itrip.transport.impl;

import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.service.UserService;
import cn.ekgc.itrip.transport.user.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>爱旅行-用户模块传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("userTransport")
@RequestMapping("/user/transport")
public class UserTransportImpl implements UserTransport {
	@Autowired
	private UserService userService;

	/**
	 * <b>根据用户名校验该用户名被使用</b>
	 * @param userCode
	 * @return true-未被占用，1-已被占用
	 * @throws Exception
	 */
	@PostMapping("/ckusr")
	@Override
	public boolean queryUserCodeIsCanUsed(@RequestParam String userCode) throws Exception {
		return userService.queryUserCodeIsCanUsed(userCode);
	}

	/**
	 * <b>使用邮箱注册用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/doregister")
	@Override
	public boolean saveUser(User user) throws Exception {
		return userService.saveUser(user);
	}

	/**
	 * <b>使用激活码激活用户</b>
	 * @param userCode
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/activate")
	@Override
	public boolean activateUser(@RequestParam String userCode, @RequestParam String code) throws Exception {
		return userService.activateUser(userCode, code);
	}

	/**
	 * <b>使用 token 查找当前登录用户</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/token")
	@Override
	public User getUserByToken(@RequestParam String token) throws Exception {
		return userService.getUserByToken(token);
	}

	/**
	 * <b>使用 userCode 和 password 进行登录</b>
	 * @param userCode
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	@Override
	public ResultVO loginUser(@RequestParam String userCode, @RequestParam String password) throws Exception {
		return userService.loginUser(userCode, password);
	}
}
