package com.xaccp.alumni.util;

import com.xaccp.alumni.entity.User;

/**
 * 功能：邮件发送器
 * 
 * @author GX
 *
 * @version 1.0
 */
public class SendEmail {
	/**
	 * 功能：发送验证邮件
	 * 
	 * @return true or false
	 */
	public static boolean sendVerifyEmail(User user) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.aliyun.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setFromAddress("gao199623@aliyun.com");
		mailInfo.setToAddress(user.getUser_email());
		mailInfo.setUserName("gao199623@aliyun.com");
		mailInfo.setPassword("Gao199623");
		mailInfo.setSubject("来自西北工业大学校友网的激活邮件");
		mailInfo.setContent(
				"<h1>来自西北工业大学校友网的激活邮件，激活请点击以下链接：<a href='http://127.0.0.1:8080/ssh/user_userActivation?User_ecode="
						+ user.getUser_ecode() + "'>http://127.0.0.1:8080/ssh/user_userActivation?User_ecode="
						+ user.getUser_ecode() + "</a></h1>");
		boolean isSend = SimpleMailSender.sendHtmlMail(mailInfo);
		if (isSend) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 功能：发送修改密码验证邮件
	 * 
	 * @param ecode
	 * @param email
	 * @return true or false
	 */
	public static boolean sendUpdatePasswordEmail(String ecode, String email) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.aliyun.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setFromAddress("gao199623@aliyun.com");
		mailInfo.setToAddress(email);
		mailInfo.setUserName("gao199623@aliyun.com");
		mailInfo.setPassword("Gao199623");
		mailInfo.setSubject("来自西北工业大学校友网的修改密码邮件");
		mailInfo.setContent(
				"<h1>来自西北工业大学校友网的修改密码邮件，修改密码请点击以下链接(30分钟后过期)：<a href='http://127.0.0.1:8080/ssh/user_setRequestEmail.action?user_ecode="
						+ ecode + "'>http://127.0.0.1:8080/ssh/user_setRequestEmail.action?user_ecode=" + ecode
						+ "</a></h1>");
		boolean isSend = SimpleMailSender.sendHtmlMail(mailInfo);
		if (isSend) {
			return true;
		} else {
			return false;
		}
	}

}
