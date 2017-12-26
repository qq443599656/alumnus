package com.xaccp.alumni.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户类
 * 
 * @author GX
 *
 */
@Entity
@Table(name = "t_user")
public class User {
	@Id
	@GeneratedValue(generator = "user_id")
	@GenericGenerator(name = "user_id", strategy = "native")
	// 用户id
	private int user_id;
	// 用户名
	@Column(name = "user_username")
	private String user_username;
	// 密码
	@Column(name = "user_password")
	private String user_password;
	// 电子邮箱
	@Column(name = "user_email")
	private String user_email;
	// 验证码
	@Column(name = "user_ecode")
	private String user_ecode;
	// 用户状态
	@Column(name = "user_states")
	private int user_states;
	// 验证码过期时间
	@Column(name = "user_outDate")
	private Timestamp user_outDate;
	//用户登录状态
	@Column(name="user_loginStates")
	private int user_loginStates;
	
	public int getUser_loginStates() {
		return user_loginStates;
	}

	public void setUser_loginStates(int user_loginStates) {
		this.user_loginStates = user_loginStates;
	}

	public Timestamp getUser_outDate() {
		return user_outDate;
	}

	public void setUser_outDate(Timestamp user_outDate) {
		this.user_outDate = user_outDate;
	}

	public String getUser_ecode() {
		return user_ecode;
	}

	public void setUser_ecode(String user_ecode) {
		this.user_ecode = user_ecode;
	}

	public int getUser_states() {
		return user_states;
	}

	public void setUser_states(int user_states) {
		this.user_states = user_states;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
}
