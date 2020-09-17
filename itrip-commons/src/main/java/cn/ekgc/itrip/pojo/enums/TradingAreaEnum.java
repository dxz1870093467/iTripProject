package cn.ekgc.itrip.pojo.enums;

/**
 * <b>商圈枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum  TradingAreaEnum {
	TRADING_AREA_YES(1, "商圈"),
	TRADING_AREA_NO(0, "非商圈");

	private Integer code;
	private String remark;

	private TradingAreaEnum(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
