package cn.ekgc.itrip.pojo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <b>酒店描述视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class HotelDescVO implements Serializable {
	private static final long serialVersionUID = 3017191776303823843L;
	private String hotelName;   //酒店名称
	private List<String> tradingAreaNameList; //酒店所属商圈
	private List<String> hotelFeatureList; //酒店特色

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<String> getTradingAreaNameList() {
		return tradingAreaNameList;
	}

	public void setTradingAreaNameList(List<String> tradingAreaNameList) {
		this.tradingAreaNameList = tradingAreaNameList;
	}

	public List<String> getHotelFeatureList() {
		return hotelFeatureList;
	}

	public void setHotelFeatureList(List<String> hotelFeatureList) {
		this.hotelFeatureList = hotelFeatureList;
	}
}
