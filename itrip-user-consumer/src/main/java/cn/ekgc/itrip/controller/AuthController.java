package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.transport.user.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			return new ResultVO(true, "该用户名未被占用");
		}
		return new ResultVO(false, "该用户名已被占用");
	}
}
