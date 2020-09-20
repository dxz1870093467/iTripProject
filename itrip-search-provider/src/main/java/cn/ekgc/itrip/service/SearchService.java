package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;

import java.util.List;

/**
 * <b>搜索功能业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SearchService {

	/**
	 * <b>根据热门城市查询酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	List<HotelVO> getHotelListByHotCity(SearchHotCityVO searchHotCityVO) throws Exception;
}
