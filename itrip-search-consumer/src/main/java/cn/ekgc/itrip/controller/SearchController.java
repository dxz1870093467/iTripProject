package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.transport.search.SearchTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>搜索功能控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("searchController")
@RequestMapping("/search/api")
public class SearchController extends BaseController {
	@Autowired
	private SearchTransport searchTransport;

	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/hotellist/searchItripHotelListByHotCity")
	public ResultVO searchHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO) throws Exception {
		List<HotelVO> list = searchTransport.getHotelListByHotCity(searchHotCityVO);
		return ResultVO.success(list);
	}
}
