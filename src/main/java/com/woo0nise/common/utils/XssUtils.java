package com.woo0nise.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * XSS工具类
 * <p>Title: XssUtils</p>
 * <p>Description: </p>
 * <p>date: 2017年5月10日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class XssUtils {
	/**
	 * 无参构造
	 * */
	private XssUtils(){}
	
	/**
	 * 危险字符转义
	 * @param c 需要转义的字符
	 * @return 转义结果
	 */
	private static String htmlEncode(char c) {
	    switch(c) {
	       case '&':
	           return"&amp;";
	       case '<':
	           return"&lt;";
	       case '>':
	           return"&gt;";
	       case '"':
	           return"&quot;";
	       case ' ':
	           return"&nbsp;";
	       default:
	           return c +"";
	    }
	}
	
	/**
	 * html内容转义
	 * @param str 需要转义的字符串
	 * @return 转义结果
	 */
	public static String htmlEncode(String str) {
		//检索是否为空
	    if(StringUtils.isBlank(str))
	    	return str;
	    StringBuilder encodeStrBuilder = new StringBuilder();
	    for (int i = 0, len = str.length(); i < len; i++) {

	       encodeStrBuilder.append(htmlEncode(str.charAt(i)));

	    }
	    return encodeStrBuilder.toString();
	}
}