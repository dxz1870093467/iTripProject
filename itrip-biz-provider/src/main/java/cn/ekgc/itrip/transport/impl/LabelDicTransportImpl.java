package cn.ekgc.itrip.transport.impl;

import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.service.LabelDicService;
import cn.ekgc.itrip.transport.biz.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-字典功能传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("labelDicTransport")
@RequestMapping("/label/transport")
public class LabelDicTransportImpl implements LabelDicTransport {
	@Autowired
	private LabelDicService labelDicService;

	/**
	 * <b>根据查询对象获得列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query")
	public List<LabelDic> getLabelDicListByQuery(@RequestBody LabelDic query) throws Exception {
		return labelDicService.getLabelDicListByQuery(query);
	}
}
