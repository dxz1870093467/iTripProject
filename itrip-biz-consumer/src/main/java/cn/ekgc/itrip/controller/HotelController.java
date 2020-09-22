package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.pojo.entity.Area;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.enums.HotEnum;
import cn.ekgc.itrip.pojo.vo.DetailsHotelVO;
import cn.ekgc.itrip.pojo.vo.HotelDescVO;
import cn.ekgc.itrip.transport.biz.AreaTransport;
import cn.ekgc.itrip.transport.biz.HotelTransport;
import cn.ekgc.itrip.transport.biz.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-酒店功能控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelController")
@RequestMapping("/biz/api/hotel")
public class HotelController extends BaseController {
	@Autowired
	private AreaTransport areaTransport;
	@Autowired
	private LabelDicTransport labelDicTransport;
	@Autowired
	private HotelTransport hotelTransport;

	/**
	 * <b>根据是否是国内信息，查询热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/queryhotcity/{isChina}")
	public ResultVO queryHotCity(@PathVariable("isChina") Integer isChina) throws Exception {
		// 创建查询对象
		Area query = new Area();
		// 设置城市为热门城市
		query.setIsHot(HotEnum.HOT_YES.getCode());
		// 设置是否为国内城市
		query.setIsChina(isChina);
		// 进行查询，获得列表
		List<Area> list = areaTransport.getAreaByQuery(query);

		return ResultVO.success(list);
	}

	/**
	 * <b>查询酒店特色列表</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/queryhotelfeature")
	public ResultVO queryHotelFeature() throws Exception {
		// 创建查询对象
		LabelDic query = new LabelDic();
		// 酒店特色信息的 parentId 为 16
		LabelDic parent = new LabelDic();
		parent.setId(16L);
		query.setParent(parent);
		// 进行列表查询
		List<LabelDic> list = labelDicTransport.getLabelDicListByQuery(query);

		return ResultVO.success(list);
	}

	/**
	 * <b>根据酒店id查询酒店特色、商圈、酒店名称</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/getvideodesc/{hotelId}")
	public ResultVO getHotelDetailDesc(@PathVariable("hotelId") Long hotelId) throws Exception {
		// 创建 HotelDescVO 对象
		HotelDescVO hotelDescVO = new HotelDescVO();
		// 查询酒店信息
		Hotel hotel = hotelTransport.getHotelById(hotelId);
		hotelDescVO.setHotelName(hotel.getHotelName());
		// 查询该酒店对应的商圈列表
		Area areaQuery = new Area();
		areaQuery.setHotelId(hotelId);
		List<Area> areaList = areaTransport.getAreaByQuery(areaQuery);
		List<String> tradingAreaNameList = new ArrayList<>();
		for (Area area : areaList) {
			tradingAreaNameList.add(area.getName());
		}
		hotelDescVO.setTradingAreaNameList(tradingAreaNameList);
		// 查询该酒店的特色信息
		LabelDic labelDicquery = new LabelDic();
		labelDicquery.setHotelId(hotelId);
		List<LabelDic> labelDicList = labelDicTransport.getLabelDicListByQuery(labelDicquery);
		List<String> hotelFeatureList = new ArrayList<String>();
		for (LabelDic labelDic : labelDicList) {
			hotelFeatureList.add(labelDic.getName());
		}
		hotelDescVO.setHotelFeatureList(hotelFeatureList);

		return ResultVO.success(hotelDescVO);
	}

	/**
	 * <b>根据酒店id查询酒店特色和介绍</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/queryhoteldetails/{id}")
	public ResultVO queryHotelDetails(@PathVariable("id") Long id) throws Exception {
		List<DetailsHotelVO> list = new  ArrayList<DetailsHotelVO>();
		// 封装查询对象
		Hotel hotel = hotelTransport.getHotelById(id);
		// 设定酒店详情信息
		DetailsHotelVO detailsHotelVO = new DetailsHotelVO();
		detailsHotelVO.setName("酒店介绍");
		detailsHotelVO.setDescription(hotel.getDetails());
		list.add(detailsHotelVO);
		// 酒店特色信息
		// 查询该酒店的特色信息
		LabelDic labelDicquery = new LabelDic();
		labelDicquery.setHotelId(id);
		List<LabelDic> labelDicList = labelDicTransport.getLabelDicListByQuery(labelDicquery);
		for (LabelDic labelDic : labelDicList) {
			DetailsHotelVO vo = new DetailsHotelVO();
			vo.setName(labelDic.getName());
			vo.setDescription(labelDic.getDescription());
			list.add(vo);
		}

		return ResultVO.success(list);
	}

	/**
	 * <b>根据酒店id查询酒店设施</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/queryhotelfacilities/{id}")
	public ResultVO queryHotelFacilities(@PathVariable("id") Long id) throws Exception {
		// 封装查询对象
		Hotel hotel = hotelTransport.getHotelById(id);
		return ResultVO.success(hotel.getFacilities());
	}

	/**
	 * <b>根据酒店id查询酒店政策</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/queryhotelpolicy/{id}")
	public ResultVO queryHotelPolicy(@PathVariable("id") Long id) throws Exception {
		// 封装查询对象
		Hotel hotel = hotelTransport.getHotelById(id);
		return ResultVO.success(hotel.getHotelPolicy());
	}
}
