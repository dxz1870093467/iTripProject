package cn.ekgc.itrip.transport.user;

import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>爱旅行-用户模块传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-user-provider")
@RequestMapping("/user/transport")
public interface UserTransport {
	/**
	 * <b>根据用户名校验该用户名被使用</b>
	 * @param userCode
	 * @return true-未被占用，1-已被占用
	 * @throws Exception
	 */
	@PostMapping("/ckusr")
	boolean queryUserCodeIsCanUsed(@RequestParam String userCode) throws Exception;

	/**
	 * <b>使用邮箱注册用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/doregister")
	boolean saveUser(@RequestBody User user) throws Exception;

	/**
	 * <b>使用激活码激活用户</b>
	 * @param user
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/activate")
	boolean activateUser(@RequestParam String userCode, @RequestParam String code) throws Exception;

	/**
	 * <b>使用 token 查找当前登录用户</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/token")
	User getUserByToken(@RequestParam String token) throws Exception;

	/**
	 * <b>使用 userCode 和 password 进行登录</b>
	 * @param userCode
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	ResultVO loginUser(@RequestParam String userCode, @RequestParam String password) throws Exception;
}
