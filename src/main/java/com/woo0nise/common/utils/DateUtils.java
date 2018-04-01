package com.woo0nise.common.utils;

import java.text.*;
import java.util.*;
/**
 * 日期操作工具类
 * <p>Title: DateUtils</p>
 * <p>Description: </p>
 * <p>date: 2018年3月31日 </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class DateUtils {
	/**
	 * 私有构造防止被实例化
	 */
	private DateUtils() {
	};

	public final static String[] week = { "", "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
	public final static String[] week2 = { "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
	// yyyy-MM-dd 2016-08-17
	public static java.text.SimpleDateFormat SDF_YYMMDD = new java.text.SimpleDateFormat("yyyy-MM-dd");
	// yyyy-MM-dd HH:mm:ss 2016-08-17 13:28:36
	public static java.text.SimpleDateFormat SDF_YYYY_MM_DD_HH_MM_SS = new java.text.SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 字符串转换为日期类型
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @param format
	 *            转换格式
	 * @return 转换结果
	 */
	public static Date StringToDate(String dateString, String format) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期类型转换为字符串
	 * <p>
	 * 字符串转换为日期类型<br>
	 * 转换结果格式为:yyyy-MM-dd
	 * </p>
	 * 
	 * @param date
	 *            日期类型
	 * @return 转换结果
	 */
	public static String DateToString_YYYY_MM_DD(Date date) {
		String dates = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dates = sdf.format(date);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}
		return dates;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:MM-dd
	 * <p>
	 * 
	 * @param date
	 *            日期类型
	 * @return 转换结果
	 */
	public static String DateToString_MM_DD(Date date) {
		String dates = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			dates = sdf.format(date);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}
		return dates;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:yyyy-MM-dd HH:mm:ss
	 * </p>
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @return 转换结果
	 */
	public static Date StringToDate(String dateString) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:yyyy/MM/dd HH:mm
	 * </p>
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @return 转换结果
	 */
	public static Date StringtoDateHHMM(String dateString) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:yyyyMMdd HH:mm:ss
	 * </p>
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @return 转换结果
	 */
	public static Date StringToDatetpy(String dateString) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			date = sdf.parse(dateString);
			System.out.println(date);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:yyyy-MM-dd HH:mm
	 * </p>
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @return 转换结果
	 */
	public static Date StringToDate_YYYY_MM_DD_HH_MM(String dateString) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:yyyyMMddHHmmss
	 * </p>
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @return 转换结果
	 */
	public static Date StringToDate_YYYYMMDDHHMM(String dateString) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:yy-MM-dd HH:mm
	 * </p>
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @return 转换结果
	 */
	public static Date StringToDate_YY_MM_DD_HH_MM(String dateString) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符串转换为日期
	 * <p>
	 * 字符串转换为日期<br>
	 * 转换结果格式为:yyyy-MM-dd HH:mm:ss
	 * </p>
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @return 转换结果
	 */
	public static Date StringToDate_YYYY_MM_DD_HH_MM_SS(String dateString) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符串转换为日期
	 * 
	 * @param dateString
	 *            字符串类型日期
	 * @param format
	 *            格式化字符
	 * @return 转换结果
	 */
	public static Date stringToDate(String dateString, String format) {
		Date date;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateString);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            需要转换字符串格式
	 * @return 转换结果
	 */
	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
