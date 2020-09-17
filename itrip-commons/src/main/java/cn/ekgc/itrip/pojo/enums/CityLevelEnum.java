package cn.ekgc.itrip.pojo.enums;

/**
 * <b>城市级别枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum CityLevelEnum {
	CITY_LEVEL_COUNTRY(0, "国家级"),
	CITY_LEVEL_PROVINCE(1, "省级"),
	CITY_LEVEL_CITY(2, "市级"),
	CITY_LEVEL_DISTRICT(3, "区县级");

	private Integer code;
	private String remark;

	private CityLevelEnum(Integer code, String remark) {
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
