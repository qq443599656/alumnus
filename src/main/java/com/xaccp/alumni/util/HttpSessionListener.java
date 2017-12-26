package com.xaccp.alumni.util;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xaccp.alumni.entity.User;
import com.xaccp.alumni.service.UserService;

public class HttpSessionListener implements javax.servlet.http.HttpSessionListener {

	// 注入处理用户业务对象，不能采用自动注入，否则会空指针
	@Autowired
	// private UserService userServiceImpl;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getSession().getServletContext());
		UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
		HttpSession session = event.getSession();
		if(session==null) {
			return;
		}
		User user = (User) session.getAttribute("User");
		if(user==null) {
			return;
		}
		System.out.println(user.getUser_username() + "+" + user.getUser_password());
		// 通过username查找
		User user2 = userServiceImpl.findUserByUsername(user.getUser_username());
		user2.setUser_loginStates(0);
		userServiceImpl.updateUserByUser(user2);
		System.out.println("销毁session,修改状态成功!");
	}
}
