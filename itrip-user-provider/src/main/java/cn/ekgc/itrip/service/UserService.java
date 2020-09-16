package cn.ekgc.itrip.service;

import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.pojo.entity.User;

/**
 * <b>爱旅行-用户模块业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserService {

	/**
	 * <b>根据用户名校验该用户名被使用</b>
	 * @param userCode
	 * @return true-未被占用，1-已被占用
	 * @throws Exception
	 */
	boolean queryUserCodeIsCanUsed(String userCode) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean saveUser(User user) throws Exception;

	/**
	 * <b>使用激活码激活用户</b>
	 * @param userCode
	 * @param code
	 * @return
	 * @throws Exception
	 */
	boolean activateUser(String userCode, String code) throws Exception;

	/**
	 * <b>使用 token 查找当前登录用户</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	User getUserByToken(String token) throws Exception;

	/**
	 * <b>使用 userCode 和 password 进行登录</b>
	 * @param userCode
	 * @param password
	 * @return
	 * @throws Exception
	 */
	ResultVO loginUser(String userCode, String password) throws Exception;
}
