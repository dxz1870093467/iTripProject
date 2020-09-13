package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-用户模块数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface UserDao {

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findListByQuery(User query) throws Exception;
}
