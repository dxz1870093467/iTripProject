package cn.ekgc.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>酒店搜索视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class SearchHotCityVO implements Serializable {
	private static final long serialVersionUID = 1947193149994846983L;
	private Integer cityId;
	private Integer count;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
