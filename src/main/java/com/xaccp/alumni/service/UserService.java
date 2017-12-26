package com.xaccp.alumni.service;

import com.xaccp.alumni.entity.User;

/**
 * 功能：处理用户业务接口
 * 
 * @author GX
 * 
 * @version 1.0
 */
public interface UserService {
	/**
	 * 根据用户名密码查询某一用户
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return user对象 or null
	 */
	User findUserByUsernameAndUserpassword(String username, String password);

	/**
	 * 根据用户名查询某一用户
	 * 
	 * @param username
	 * @return user对象 or null
	 */
	User findUserByUsername(String username);

	/**
	 * 保存某一用户
	 * 
	 * @param user
	 * @return true or false
	 */
	boolean saveUserByUser(User user);

	/**
	 * 根据email查询用户
	 * 
	 * @param user_email
	 * @return user对象
	 */
	User findUserByEmail(String user_email);

	/**
	 * 根据用户验证码查询某一用户
	 * 
	 * @param user_ecode
	 * @return
	 */
	User findUserByUsercode(String user_ecode);

	/**
	 * 根据用户验证码查询某一用户
	 * 
	 * @param user_ecode
	 * @return user对象
	 */
	User findUserByUserecode(String user_ecode);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	boolean updateUserByUser(User user);
}
