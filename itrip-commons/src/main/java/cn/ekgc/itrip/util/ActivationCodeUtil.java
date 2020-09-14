package cn.ekgc.itrip.util;

import java.util.Random;

/**
 * <b>激活码生成工具类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class ActivationCodeUtil {

	/**
	 * <b>生成六位激活码</b>
	 * @return
	 */
	public static String generate() {
		Random random = new Random();
		// 使用 StringBuffer 存储激活码信息
		StringBuffer sb = new StringBuffer();
		while (sb.length() != 6) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
}
