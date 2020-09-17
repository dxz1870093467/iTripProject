package cn.ekgc.itrip.pojo.enums;

/**
 * <b>热门城市枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum HotEnum {
	HOT_YES(1, "热门城市"),
	HOT_NO(0, "非热门城市");

	private Integer code;
	private String remark;

	private HotEnum(Integer code, String remark) {
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
