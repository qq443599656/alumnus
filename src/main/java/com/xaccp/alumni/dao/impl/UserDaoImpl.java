package com.xaccp.alumni.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xaccp.alumni.dao.UserDao;
import com.xaccp.alumni.entity.User;

/**
 * 功能：处理用户持久化层业务实现类
 * 
 * @author GX
 *
 * @version 1.0
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
	// 注入Session工厂
	@Autowired
	private SessionFactory sessionFactory;
	// 实例化session对象
	Session session = null;

	// 查询所有用户
	@Override
	public List<User> listGetAllUser() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.list();
		return userList;
	}

	// 保存用户
	@Override
	public boolean insertUserByUser(User user) {
		try {
			session = sessionFactory.openSession();
			session.save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 修改用户
	@Override
	public boolean updateUserByUser(User user) {
		try {
			session = sessionFactory.openSession();
			session.update(user);
			session.flush();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
