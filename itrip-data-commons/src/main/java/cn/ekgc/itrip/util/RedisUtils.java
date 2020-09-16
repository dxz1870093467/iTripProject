package cn.ekgc.itrip.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>Redis 工具类</b>
 */
@Component("redisUtils")
public class RedisUtils {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>将对象存储到 Redis 中</b>
	 * @param key
	 * @param value
	 * @param expireTime
	 * @throws Exception
	 */
	public void saveToRedis(String key, Object value, Long expireTime) throws Exception {
		// 需要将 Object 变为 JSON
		JsonMapper jsonMapper = new JsonMapper();
		// 使用 JsonMapper 将对象变为 json 格式
		String valueJSON = jsonMapper.writeValueAsString(value);
		// 存储该对象到 Redis 中
		redisTemplate.opsForValue().set(key, valueJSON);
		// 设置过期时间
		redisTemplate.expire(key, expireTime, TimeUnit.MINUTES);
	}

	/**
	 * <b>根据 key 从 Redis 中获取对象</b>
	 * @param key
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Object getFromRedis(String key, Class type) throws Exception {
		// 从 Redis 中查询信息
		String valueJSON = redisTemplate.opsForValue().get(key);
		// 判断该信息是否存在
		if (valueJSON != null) {
			// 使用 JsonMapper 将 json 变为 对象
			JsonMapper jsonMapper = new JsonMapper();
			Object value = jsonMapper.readValue(valueJSON, type);
			return value;
		}
		return null;
	}
}
