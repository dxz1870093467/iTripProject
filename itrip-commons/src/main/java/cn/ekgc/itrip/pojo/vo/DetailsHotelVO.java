package cn.ekgc.itrip.pojo.vo;

import java.io.Serializable;

/**
 * <b>酒店详情视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class DetailsHotelVO implements Serializable {
	private static final long serialVersionUID = -4247650700343186246L;
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
