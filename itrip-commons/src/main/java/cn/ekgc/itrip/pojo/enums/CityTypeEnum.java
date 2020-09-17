package cn.ekgc.itrip.pojo.enums;

/**
 * <b>城市类别枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum CityTypeEnum {
	CITY_TYPE_YES(1, "国内"),
	CITY_TYPE_NO(2, "国外");

	private Integer code;
	private String remark;

	private CityTypeEnum(Integer code, String remark) {
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
