package cn.ekgc.itrip.pojo.entity;

import cn.ekgc.itrip.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>爱旅行-酒店模块通用字典实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class LabelDic extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 7264156168865627615L;
	private Long id;
	private String name;
	private String value;
	private String description;
	private LabelDic parent;
	private String pic;
	private Long hotelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LabelDic getParent() {
		return parent;
	}

	public void setParent(LabelDic parent) {
		this.parent = parent;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
}
