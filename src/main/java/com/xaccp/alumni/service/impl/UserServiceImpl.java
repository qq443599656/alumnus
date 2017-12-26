package com.xaccp.alumni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xaccp.alumni.dao.UserDao;
import com.xaccp.alumni.entity.User;
import com.xaccp.alumni.service.UserService;
import com.xaccp.alumni.util.MD5Util;

/**
 * 功能：处理用户业务实现类
 * 
 * @author GX
 * 
 * @version 1.0
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	// 注入处理用户持久化层业务对象
	@Autowired
	private UserDao userDaoImpl;
	// 实例化保存所有用户的集合
	List<User> userList = null;

	// 根据用户名密码查询某一用户
	@Override
	public User findUserByUsernameAndUserpassword(String username, String password) {
		// 转换md5
		password = MD5Util.getMD5(password);
		userList = userDaoImpl.listGetAllUser();
		User returnUser = null;
		if (userList != null) {
			for (User user2 : userList) {
				if (user2.getUser_username().equals(username) && user2.getUser_password().equals(password)) {
					returnUser = user2;
				}
			}
		}
		return returnUser;
	}

	// 根据用户名查询某一用户
	@Override
	public User findUserByUsername(String username) {
		userList = userDaoImpl.listGetAllUser();
		User returnUser = null;
		if (userList != null) {
			for (User user : userList) {
				if (user.getUser_username().equals(username)) {
					returnUser = user;
					return returnUser;
				}
			}
		}
		return null;
	}

	// 保存某一用户
	@Override
	public boolean saveUserByUser(User user) {
		user.setUser_password(MD5Util.getMD5(user.getUser_password()));
		boolean flag;
		flag = userDaoImpl.insertUserByUser(user);
		return flag;
	}

	// 根据email查询用户
	@Override
	public User findUserByEmail(String user_email) {
		userList = userDaoImpl.listGetAllUser();
		User returnUser = null;
		if (userList != null) {
			for (User user : userList) {
				if (user.getUser_email().equals(user_email)) {
					returnUser = user;
					return returnUser;
				}
			}
		}
		return null;
	}

	// 根据用户验证码查询某一用户
	@Override
	public User findUserByUserecode(String user_ecode) {
		userList = userDaoImpl.listGetAllUser();
		if (userList != null) {
			for (User user : userList) {
				if (user_ecode.equals(user.getUser_ecode())) {
					return user;
				}
			}
		}
		return null;
	}

	// 根据用户验证码查询某一用户
	@Override
	public User findUserByUsercode(String user_ecode) {
		userList = userDaoImpl.listGetAllUser();
		if (userList != null) {
			for (User user : userList) {
				if (user.getUser_ecode().equals(user_ecode)) {
					return user;
				}
			}
		}
		return null;
	}

	// 修改用户
	@Override
	public boolean updateUserByUser(User user) {
		// 修改
		if (userDaoImpl.updateUserByUser(user)) {
			return true;
		} else {
			return false;
		}
	}
}
