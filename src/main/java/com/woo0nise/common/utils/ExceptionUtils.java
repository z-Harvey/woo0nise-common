package com.woo0nise.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 * <p>Title: ExceptionUtils</p>
 * <p>Description: </p>
 * <p>date: 2017年5月8日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class ExceptionUtils {

	/**
	 * 获取异常的堆栈信息
	 * @param t 异常
	 * @return 结果
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
