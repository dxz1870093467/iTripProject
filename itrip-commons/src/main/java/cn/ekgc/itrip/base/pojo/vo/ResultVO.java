package cn.ekgc.itrip.base.pojo.vo;

import java.io.Serializable;

/**
 * <b>响应结果视图信息</b>
 * @param <E>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class ResultVO<E> implements Serializable {
	private static final long serialVersionUID = 2774022453097458935L;
	private boolean success;                        // 判断系统是否出错做出相应的true或者false的返回，与业务无关，出现的各种异常
	private Integer errorCode;                      // 该错误码为自定义，一般0表示无错
	private String msg;                             // 对应的提示信息
	private E data;                                 // 具体返回数据内容(pojo、自定义VO、其他)

	public ResultVO() {}
	public ResultVO(boolean success) {
		this.success = success;
	}
	public ResultVO(boolean success, Integer errorCode, String msg) {
		this.success = success;
		this.errorCode = errorCode;
		this.msg = msg;
	}
	public ResultVO(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	public ResultVO(boolean success, E data) {
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
}
