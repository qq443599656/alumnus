package com.xaccp.alumni.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xaccp.alumni.entity.User;
import com.xaccp.alumni.service.UserService;
import com.xaccp.alumni.util.DateUtil;
import com.xaccp.alumni.util.MD5Util;
import com.xaccp.alumni.util.PrintHtmlInfoUtil;
import com.xaccp.alumni.util.SendEmail;
import com.xaccp.alumni.util.UUIDUtil;

/**
 * 功能：处理用户请求action
 * 
 * @author GX
 * 
 * @version 1.0
 * 
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 序列化的版本号
	 */
	private static final long serialVersionUID = 1L;
	// 获得session
	HttpSession session = ServletActionContext.getRequest().getSession();
	// 获得response对象
	HttpServletResponse response = ServletActionContext.getResponse();
	// 获得request对象
	HttpServletRequest request = ServletActionContext.getRequest();
	// 实例化user
	User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 重写getModel方法
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// 用户Ajax返回数据
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	// 注入处理用户业务对象
	@Autowired
	private UserService userServiceImpl;

	/**
	 * 登录
	 * 
	 * @return
	 * @throws IOException
	 */
	public String login() throws IOException {
		User user2 = userServiceImpl.findUserByUsernameAndUserpassword(user.getUser_username(),
				user.getUser_password());
		if (user2 != null) {
			System.out.println("用户名密码正确!");
			if (user2.getUser_states() != 1) {
				if (user2.getUser_loginStates() == 0) {
					System.out.println("可以登录");
					// 改变用户状态1:登录状态2:未登录状态
					user2.setUser_loginStates(1);
					if (userServiceImpl.updateUserByUser(user2)) {
						session.setAttribute("User", user);
						session.setMaxInactiveInterval(60);
						this.result = "ok";
					}else {
						this.result = "no";
					}
				} else {
					this.result = "noState";
				}
			} else {
				this.result = "noActivation";
			}
		} else {
			this.result = "userNo";
		}
		return SUCCESS;
	}

	/**
	 * 注册验证用户名
	 * 
	 * @return
	 */
	public String isUsernameOk() {
		System.out.println("进入用户名验证" + user.getUser_username());
		User user2 = null;
		user2 = userServiceImpl.findUserByUsername(user.getUser_username());
		if (user2 == null) {
			this.result = "ok";
		} else {
			this.result = "no";
		}
		return SUCCESS;
	}

	/**
	 * 注册验证Email
	 * 
	 * @return
	 */
	public String isEmailOk() {
		System.out.println("进入Email验证" + user.getUser_email());
		User user2 = null;
		user2 = userServiceImpl.findUserByEmail(user.getUser_email());
		if (user2 == null) {
			this.result = "ok";
		} else {
			this.result = "no";
		}
		return SUCCESS;
	}

	/**
	 * 用户邮箱激活
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public String userActivation() throws IOException {
		// 设置输出字符编码
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获得printWrite对象
		PrintWriter out = response.getWriter();
		boolean flag;
		User user2 = userServiceImpl.findUserByUserecode(user.getUser_ecode());
		if (user2 == null) {
			// 打印注册邮箱失败
			PrintHtmlInfoUtil.printInfo(out, "激活失败，您的验证码有误!");
			return NONE;
		}
		// 如果未被激活，改变状态码
		user2.setUser_states(1);
		flag = userServiceImpl.updateUserByUser(user2);
		if (flag) {
			// 激活成功，删除用户验证码
			user2.setUser_ecode(null);
			// 保存用户
			flag = userServiceImpl.updateUserByUser(user2);
			if (flag) {
				// 打印注册邮箱激活成功
				PrintHtmlInfoUtil.printInfo(out,
						"恭喜您，激活成功!<a href=\"" + request.getContextPath() + "/login.jsp\">点击登录</a>");
				return NONE;
			} else {
				// 打印注册邮箱失败
				PrintHtmlInfoUtil.printInfo(out, "对不起，系统发生错误!");
				return NONE;
			}
		} else {
			// 打印注册邮箱失败
			PrintHtmlInfoUtil.printInfo(out, "对不起，系统发生错误!");
			return NONE;
		}
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	public String register() {
		boolean flag = false;
		user.setUser_ecode(UUIDUtil.getUUID());
		user.setUser_states(0);
		if (SendEmail.sendVerifyEmail(user)) {
			flag = userServiceImpl.saveUserByUser(user);
			if (flag) {
				this.result = "ok";
			} else {
				this.result = "no";
			}
		} else {
			this.result = "no";
		}

		return SUCCESS;
	}

	/**
	 * 忘记密码,给用户发验证信息
	 * 
	 * @return
	 */
	public String forgetPassword() {
		User user2 = userServiceImpl.findUserByEmail(user.getUser_email());
		if (user2 == null) {
			this.result = "no";
		}
		// 获取验证过期时间
		Timestamp outTime = DateUtil.getOutTime();
		// 更新验证过期时间
		user2.setUser_outDate(outTime);
		// 添加用户修改密码的验证码
		user2.setUser_ecode(
				MD5Util.getMD5(user2.getUser_username() + UUIDUtil.getUUID() + DateUtil.getOutTime().toString()));
		// 修改保存用户
		userServiceImpl.updateUserByUser(user2);
		if (SendEmail.sendUpdatePasswordEmail(user2.getUser_ecode(), user2.getUser_email())) {
			this.result = "ok";
		} else {
			this.result = "no";
		}
		return SUCCESS;
	}

	/**
	 * 用户点击修改密码邮箱后
	 * 
	 * @return
	 * @throws IOException
	 */
	public String setRequestEmail() throws IOException {
		boolean flag = false;
		// 设置输出字符编码
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获得printWrite对象
		PrintWriter out = response.getWriter();
		User user2 = userServiceImpl.findUserByUserecode(user.getUser_ecode());
		if (user2 != null) {
			if (user2.getUser_outDate().getTime() <= System.currentTimeMillis()) { // 表示已经过期
				// 打印已经过期
				PrintHtmlInfoUtil.printInfo(out, "修改密码失败，您的验证码已经过期!");
				return NONE;
			} else {
				// 修改密码成功，删除验证码
				// 激活成功，删除用户验证码和过期时间
				user2.setUser_ecode(null);
				user2.setUser_outDate(null);
				// 保存用户
				flag = userServiceImpl.updateUserByUser(user2);
				if (flag) {
					session.setAttribute("User", user2);
					session.setMaxInactiveInterval(60 * 5);
					return "setOk";
				} else {
					// 打印连接错误
					PrintHtmlInfoUtil.printInfo(out, "修改密码失败，服务器发生错误!");
					return NONE;
				}
			}
		} else {
			// 打印连接错误
			PrintHtmlInfoUtil.printInfo(out, "修改密码失败，您的链接有误!");
			return NONE;
		}
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	public String updatePassword() {
		boolean flag;
		// 修改
		User user2 = userServiceImpl.findUserByUsername(user.getUser_username());
		if (user2 == null) {
			this.result = "no";
		}
		// 转换md5
		user2.setUser_password(MD5Util.getMD5(user.getUser_password()));
		flag = userServiceImpl.updateUserByUser(user2);
		if (flag) {
			this.result = "ok";
		} else {
			this.result = "no";
		}
		// 销毁session
		session.invalidate();
		return SUCCESS;
	}

	/**
	 * 转发到index
	 * 
	 * @return
	 * @throws IOException
	 */
	public String index() throws IOException {
		System.out.println("进入index");
		User userIndex = (User) session.getAttribute("User");
		if (userIndex != null) {
			return SUCCESS;
		}
		return INPUT;
	}

	/**
	 * 退出登录，销毁session
	 * 
	 * @return
	 */
	public String invalidateSession() {
		session.invalidate();
		return "invalidateOk";
	}

}
