package com.woo0nise.common.utils;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang3.StringUtils;
/**
 * 邮件工具类
 * <p>Title: EmailUtils</p>
 * <p>Description: </p>
 * <p>date: 2017年5月8日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class EmailUtils {
	/**
	 * 私有构造防止被实例化
	 */
	private EmailUtils() {
	}

	// 邮件发送服务器
	public static String HOST = "";
	// 邮件发送端口号
	public static String PORT = "";
	// 邮件发送协议
	public static String PROTOCOL = "";
	// 发送人
	public static String FROM = "";
	// 发送人密码
	public static String PASSWORD = "";

	/**
	 * 获取发送会话
	 * @return session
	 * @throws Exception session获取异常
	 */
	private static Session getSession() throws Exception {
		Properties props = new Properties();
		// 邮件发送服务器
		props.setProperty("mail.smtp.host", HOST);
		// 是否验证身份
		props.put("mail.smtp.auth", "true");
		if (StringUtils.isBlank(PROTOCOL)) {
			PROTOCOL = "smtp";
		}
		// 邮件发送协议
		props.put("mail.store.protocol", PROTOCOL);// 设置协议
		if (StringUtils.isBlank(PORT)) {
			PORT = "25";
		}
		props.put("mail.smtp.port", PORT);// 设置端口
		return Session.getDefaultInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PASSWORD);
			}
		});
	}
	
	/**
	 * 发送邮件
	 * @param to 收件人邮箱
	 * @param title 发送标题
	 * @param data 发送内容
	 * @throws Exception session获取异常
	 */
	public static void send(String to, String title, String data) throws Exception {
		if (StringUtils.isBlank(HOST)) {
			throw new Exception("HOST不能为空!");
		}
		if (StringUtils.isBlank(to)) {
			throw new Exception("收件人不能为空!");
		}
		if (StringUtils.isBlank(FROM)) {
			throw new Exception("发件人不能为空!");
		}
		if (StringUtils.isBlank(PASSWORD)) {
			throw new Exception("发件人密码不能为空!");
		}
		// 邮件内容对象
		MimeMessage message = new MimeMessage(getSession());
		// 设置发件人的地址
		message.setFrom(new InternetAddress(FROM));
		// 设置收件人,并设置其接收类型为TO
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		// 设置标题
		message.setSubject(title, "utf-8");
		// 设置信件内容
		message.setContent(data, "text/html;charset=utf-8"); // 发送HTML邮件，内容样式比较丰富
		message.setSentDate(new Date());// 设置发信时间
		message.saveChanges();// 存储邮件信息
		// 发送邮件
		Transport.send(message);
	}
}