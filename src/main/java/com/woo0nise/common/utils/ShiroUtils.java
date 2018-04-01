package com.woo0nise.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 * <p>Title: ShiroUtils</p>
 * <p>Description: </p>
 * <p>date: 2017年5月11日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class ShiroUtils {
	private ShiroUtils(){}
	
	/**
	 * 获取session
	 * @return session
	 */
	public static Session getSession(){
		return getSubject().getSession();
	}
	
	/**
	 * 获取subject
	 * @return subject
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 退出
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
}
