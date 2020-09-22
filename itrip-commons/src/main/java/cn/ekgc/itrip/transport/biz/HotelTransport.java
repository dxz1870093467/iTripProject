package cn.ekgc.itrip.transport.biz;

import cn.ekgc.itrip.pojo.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>酒店模块传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/hotel/transport")
public interface HotelTransport {
	/**
	 * <b>根据酒店主键查询酒店信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	Hotel getHotelById(@RequestParam Long hotelId) throws Exception;
}
