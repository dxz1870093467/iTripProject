package cn.ekgc.itrip.service;

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
}
