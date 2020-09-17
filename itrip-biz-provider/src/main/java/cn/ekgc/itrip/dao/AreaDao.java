package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-城市模块数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface AreaDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Area> findListByQuery(Area query) throws Exception;
}
