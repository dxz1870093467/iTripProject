package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResultVO;
import cn.ekgc.itrip.pojo.entity.Area;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.enums.HotEnum;
import cn.ekgc.itrip.transport.biz.AreaTransport;
import cn.ekgc.itrip.transport.biz.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-用户认证功能控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("bizController")
@RequestMapping("/biz/api/hotel")
public class HotelController extends BaseController {
	@Autowired
	private AreaTransport areaTransport;
	@Autowired
	private LabelDicTransport labelDicTransport;

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
}
