package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.AreaDao;
import cn.ekgc.itrip.pojo.entity.Area;
import cn.ekgc.itrip.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>爱旅行-城市模块业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Area> getAreaByQuery(Area query) throws Exception {
		return areaDao.findListByQuery(query);
	}
}
