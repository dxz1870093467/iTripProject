package cn.ekgc.itrip.transport.search;

import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>搜索功能传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-search-provider")
@RequestMapping("/search/trans")
public interface SearchTransport {

	/**
	 * <b>根据热门城市查询酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/hotellist/searchItripHotelListByHotCity")
	List<HotelVO> getHotelListByHotCity(@RequestBody SearchHotCityVO searchHotCityVO) throws Exception;
}
