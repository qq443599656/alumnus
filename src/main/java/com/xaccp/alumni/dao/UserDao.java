package com.xaccp.alumni.dao;

import java.util.List;

import com.xaccp.alumni.entity.User;

/**
 * 功能：处理用户持久化层业务接口
 * 
 * @author GX
 * 
 * @version 1.0
 */
public interface UserDao {
	/**
	 * 查询所有用户
	 * 
	 * @return user对象
	 */
	List<User> listGetAllUser();

	/**
	 * 增加用户
	 * 
	 * @param user对象
	 * @return true or false
	 */
	boolean insertUserByUser(User user);

	/**
	 * 修改用户
	 * 
	 * @param user对象
	 * @return true or false
	 */
	boolean updateUserByUser(User user);
}
