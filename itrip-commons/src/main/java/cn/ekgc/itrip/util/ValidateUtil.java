package cn.ekgc.itrip.util;

/**
 * <b>用户信息校验工具类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class ValidateUtil {
	private static String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	private static String cellphoneRegex = "^1[0-9]{10}$";

	/**
	 * <b>校验 Email 是否正确</b>
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		if (email != null && email.matches(emailRegex)) {
			return true;
		}
		return false;
	}

	/**
	 * <b>校验 Cellphone 是否正确</b>
	 * @param cellphone
	 * @return
	 */
	public static boolean checkCellphone(String cellphone) {
		if (cellphone != null && cellphone.matches(cellphoneRegex)) {
			return true;
		}
		return false;
	}

	/**
	 * <b>校验登录密码</b>
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {
		if (password != null && !"".equals(password)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkEmail("liubo@163.com"));
	}
}
