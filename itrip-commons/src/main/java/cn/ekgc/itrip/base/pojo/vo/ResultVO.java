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
	private String success;                        // 判断系统是否出错做出相应的true或者false的返回，与业务无关，出现的各种异常
	private String errorCode;                      // 该错误码为自定义，一般0表示无错
	private String msg;                             // 对应的提示信息
	private E data;                                 // 具体返回数据内容(pojo、自定义VO、其他)

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
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

	/**
	 * <b>获得系统响应成功视图</b>
	 * @return
	 */
	public static ResultVO success() {
		ResultVO resultVO = new ResultVO();
		resultVO.setSuccess("true");
		return resultVO;
	}

	/**
	 * <b>获得系统响应成功视图</b>
	 * @param data
	 * @return
	 */
	public static ResultVO success(Object data) {
		ResultVO resultVO = new ResultVO();
		resultVO.setSuccess("true");
		resultVO.setData(data);
		return resultVO;
	}

	/**
	 * <b>获得系统响应成功视图</b>
	 * @param msg
	 * @param data
	 * @return
	 */
	public static ResultVO success(String msg, Object data) {
		ResultVO resultVO = new ResultVO();
		resultVO.setSuccess("true");
		resultVO.setMsg(msg);
		resultVO.setData(data);
		return resultVO;
	}

	/**
	 * <b>获得系统响应失败视图</b>
	 * @param msg
	 * @return
	 */
	public static  ResultVO failure(String msg) {
		ResultVO resultVO = new ResultVO();
		resultVO.setSuccess("false");
		resultVO.setMsg(msg);
		return resultVO;
	}
}
