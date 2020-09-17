package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.Area;

import java.util.List;

/**
 * <b>爱旅行-城市模块业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AreaService {

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Area> getAreaByQuery(Area query) throws Exception;
}
