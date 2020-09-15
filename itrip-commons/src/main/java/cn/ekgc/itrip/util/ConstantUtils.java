package cn.ekgc.itrip.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
public class ConstantUtils {
	private static Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtils.class.getClassLoader().getResourceAsStream("props/itrip.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>邮件信息：发送人</b>
	 */
	public static final String MAIL_FROM = props.getProperty("mail.from");

	/**
	 * <b>邮件信息：过期时间</b>
	 */
	public static final String MAIL_EXPIRE = props.getProperty("mail.expire");

	/**
	 * <b>容联云配置信息</b>
	 */
	public static final String CLOOPEN_SERVER_IP = props.getProperty("cloopen.server.ip");

	/**
	 * <b>容联云配置信息</b>
	 */
	public static final String CLOOPEN_SERVER_PORT = props.getProperty("cloopen.server.port");

	/**
	 * <b>容联云配置信息</b>
	 */
	public static final String CLOOPEN_ACCOUNT_SID = props.getProperty("cloopen.account.sid");

	/**
	 * <b>容联云配置信息</b>
	 */
	public static final String CLOOPEN_ACCOUNT_TOKEN = props.getProperty("cloopen.account.token");

	/**
	 * <b>容联云配置信息</b>
	 */
	public static final String CLOOPEN_APP_ID = props.getProperty("cloopen.app.id");

	/**
	 * <b>容联云配置信息</b>
	 */
	public static final String CLOOPEN_TEMPLATE_ID = props.getProperty("cloopen.template.id");
}
