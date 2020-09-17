package cn.ekgc.itrip.transport.impl;

import cn.ekgc.itrip.pojo.entity.Area;
import cn.ekgc.itrip.service.AreaService;
import cn.ekgc.itrip.transport.biz.AreaTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-城市模块传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("areaTransport")
@RequestMapping("/area/transport")
public class AreaTransportImpl implements AreaTransport {
	@Autowired
	private AreaService areaService;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query")
	@Override
	public List<Area> getAreaByQuery(@RequestBody Area query) throws Exception {
		return areaService.getAreaByQuery(query);
	}
}
