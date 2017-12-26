package com.xaccp.alumni.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 功能： 邮件认证器
 * 
 * @author GX
 * @version 1.0
 */
public class MyAuthenticator extends Authenticator {
	private String userName;
	private String password;

	public MyAuthenticator(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public MyAuthenticator() {
	}

	/**
	 * 密码认证
	 */
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
