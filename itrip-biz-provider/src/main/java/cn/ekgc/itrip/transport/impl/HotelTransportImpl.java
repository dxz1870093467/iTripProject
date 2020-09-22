package cn.ekgc.itrip.transport.impl;

import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.service.HotelService;
import cn.ekgc.itrip.transport.biz.HotelTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>酒店模块传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelTransport")
@RequestMapping("/hotel/transport")
public class HotelTransportImpl implements HotelTransport {
	@Autowired
	private HotelService hotelService;

	/**
	 * <b>根据酒店主键查询酒店信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public Hotel getHotelById(@RequestParam Long hotelId) throws Exception {
		return hotelService.getHotelById(hotelId);
	}
}
