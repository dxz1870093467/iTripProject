package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.LabelDic;

import java.util.List;

/**
 * <b>爱旅行-字典功能业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LabelDicService {

	/**
	 * <b>根据查询对象获得列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> getLabelDicListByQuery(LabelDic query) throws Exception;
}
