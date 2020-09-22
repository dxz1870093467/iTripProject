package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.HotelDao;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>酒店模块业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDao;

	/**
	 * <b>根据酒店主键查询酒店信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Hotel getHotelById(Long hotelId) throws Exception {
		// 封装查询对象
		Hotel query = new Hotel();
		query.setId(hotelId);
		// 查询列表
		List<Hotel> list = hotelDao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
