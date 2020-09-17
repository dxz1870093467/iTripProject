package cn.ekgc.itrip.pojo.entity;

import cn.ekgc.itrip.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>爱旅行-用户模块实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -2388047272567548206L;
	private Long id;                        // 主键
	private String userCode;                // 若是第三方登录，系统将自动生成唯一账号；自注册用户则为邮箱或者手机号
	private String userPassword;            // 若是第三方登录，系统将自动生成唯一密码；自注册用户则为自定义密码
	private Integer userType;               // 用户类型（标识：0 自注册用户 1 微信登录 2 QQ登录 3 微博登录）
	private Long flatID;                    // 平台ID（根据不同登录用户，进行相应存入：自注册用户主键ID、微信ID、QQID、微博ID）
	private String userName;                // 用户昵称
	private String weChat;                  // 微信号
	private String QQ;                      // qq账号
	private String weibo;                   // 微博账号
	private String baidu;                   // 百度账号
	private Integer activated;              // 是否激活,(0 false，1 true,默认是0)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Long getFlatID() {
		return flatID;
	}

	public void setFlatID(Long flatID) {
		this.flatID = flatID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getBaidu() {
		return baidu;
	}

	public void setBaidu(String baidu) {
		this.baidu = baidu;
	}

	public Integer getActivated() {
		return activated;
	}

	public void setActivated(Integer activated) {
		this.activated = activated;
	}
}
