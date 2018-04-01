package com.woo0nise.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机工具类
 * <p>Title: RandomUtils</p>
 * <p>Description: </p>
 * <p>date: 2018年3月31日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class RandomUtils {

	/** 用于随机选的数字 */
	private static final String BASE_NUMBER = "0123456789";
	/** 用于随机选的字符 */
	private static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
	/** 用于随机选的字符和数字 */
	private static final String BASE_CHAR_NUMBER = BASE_CHAR + BASE_NUMBER;

	/**
	 * 获取随机数生成器对象<br>
	 * ThreadLocalRandom是JDK 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。
	 * 
	 * @return {@link ThreadLocalRandom}
	 * @since 3.1.2
	 */
	public static ThreadLocalRandom getRandom() {
		return ThreadLocalRandom.current();
	}

	/**
	 * 获得指定范围内的随机数
	 * 
	 * @param min 最小数（包含）
	 * @param max 最大数（不包含）
	 * @return 随机数
	 */
	public static int randomInt(int min, int max) {
		return getRandom().nextInt(min, max);
	}

	/**
	 * 获得随机数[0, 1)
	 * 
	 * @return 随机数
	 */
	public static int randomInt() {
		return getRandom().nextInt();
	}

	/**
	 * 获得指定范围内的随机数 [0,limit)
	 * 
	 * @param limit 限制随机数的范围，不包括这个数
	 * @return 随机数
	 */
	public static int randomInt(int limit) {
		return getRandom().nextInt(limit);
	}

	/**
	 * 获得指定范围内的随机数
	 * 
	 * @param min 最小数（包含）
	 * @param max 最大数（不包含）
	 * @return 随机数
	 * @since 3.3.0
	 */
	public static long randomLong(long min, long max) {
		return getRandom().nextLong(min, max);
	}

	/**
	 * 获得随机数
	 * 
	 * @return 随机数
	 * @since 3.3.0
	 */
	public static long randomLong() {
		return getRandom().nextLong();
	}

	/**
	 * 获得指定范围内的随机数 [0,limit)
	 * 
	 * @param limit 限制随机数的范围，不包括这个数
	 * @return 随机数
	 */
	public static long randomLong(long limit) {
		return getRandom().nextLong(limit);
	}

	/**
	 * 获得指定范围内的随机数
	 * 
	 * @param min 最小数（包含）
	 * @param max 最大数（不包含）
	 * @return 随机数
	 * @since 3.3.0
	 */
	public static double randomDouble(double min, double max) {
		return getRandom().nextDouble(min, max);
	}

	/**
	 * 获得随机数[0, 1)
	 * 
	 * @return 随机数
	 * @since 3.3.0
	 */
	public static double randomDouble() {
		return getRandom().nextDouble();
	}


	/**
	 * 获得指定范围内的随机数 [0,limit)
	 * 
	 * @param limit 限制随机数的范围，不包括这个数
	 * @return 随机数
	 * @since 3.3.0
	 */
	public static double randomDouble(double limit) {
		return getRandom().nextDouble(limit);
	}


	/**
	 * 随机bytes
	 * 
	 * @param length 长度
	 * @return bytes
	 */
	public static byte[] randomBytes(int length) {
		byte[] bytes = new byte[length];
		getRandom().nextBytes(bytes);
		return bytes;
	}

	/**
	 * 随机获得列表中的元素
	 * 
	 * @param <T> 元素类型
	 * @param list 列表
	 * @return 随机元素
	 */
	public static <T> T randomEle(List<T> list) {
		return randomEle(list, list.size());
	}

	/**
	 * 随机获得列表中的元素
	 * 
	 * @param <T> 元素类型
	 * @param list 列表
	 * @param limit 限制列表的前N项
	 * @return 随机元素
	 */
	public static <T> T randomEle(List<T> list, int limit) {
		return list.get(randomInt(limit));
	}

	/**
	 * 随机获得数组中的元素
	 * 
	 * @param <T> 元素类型
	 * @param array 列表
	 * @return 随机元素
	 * @since 3.3.0
	 */
	public static <T> T randomEle(T[] array) {
		return randomEle(array, array.length);
	}

	/**
	 * 随机获得数组中的元素
	 * 
	 * @param <T> 元素类型
	 * @param array 列表
	 * @param limit 限制列表的前N项
	 * @return 随机元素
	 * @since 3.3.0
	 */
	public static <T> T randomEle(T[] array, int limit) {
		return array[randomInt(limit)];
	}

	/**
	 * 随机获得列表中的一定量元素
	 * 
	 * @param <T> 元素类型
	 * @param list 列表
	 * @param count 随机取出的个数
	 * @return 随机元素
	 */
	public static <T> List<T> randomEles(List<T> list, int count) {
		final List<T> result = new ArrayList<T>(count);
		int limit = list.size();
		while (--count > 0) {
			result.add(randomEle(list, limit));
		}

		return result;
	}

	/**
	 * 随机获得列表中的一定量的不重复元素，返回Set
	 * 
	 * @param <T> 元素类型
	 * @param collection 列表
	 * @param count 随机取出的个数
	 * @return 随机元素
	 * @throws IllegalArgumentException 需要的长度大于给定集合非重复总数
	 */
	public static <T> Set<T> randomEleSet(Collection<T> collection, int count) {
		ArrayList<T> source = new ArrayList<>(new HashSet<>(collection));
		if (count > source.size()) {
			throw new IllegalArgumentException("Count is larger than collection distinct size !");
		}

		final HashSet<T> result = new HashSet<T>(count);
		int limit = collection.size();
		while (result.size() < count) {
			result.add(randomEle(source, limit));
		}

		return result;
	}

	/**
	 * 获得一个随机的字符串（只包含数字和字符）
	 * 
	 * @param length 字符串的长度
	 * @return 随机字符串
	 */
	public static String randomString(int length) {
		return randomString(BASE_CHAR_NUMBER, length);
	}

	/**
	 * 获得一个只包含数字的字符串
	 * 
	 * @param length 字符串的长度
	 * @return 随机字符串
	 */
	public static String randomNumbers(int length) {
		return randomString(BASE_NUMBER, length);
	}

	/**
	 * 获得一个随机的字符串
	 * 
	 * @param baseString 随机字符选取的样本
	 * @param length 字符串的长度
	 * @return 随机字符串
	 */
	public static String randomString(String baseString, int length) {
		final StringBuilder sb = new StringBuilder();

		if (length < 1) {
			length = 1;
		}
		int baseLength = baseString.length();
		for (int i = 0; i < length; i++) {
			int number = getRandom().nextInt(baseLength);
			sb.append(baseString.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 随机数字
	 * 
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static int randomNumber() {
		return randomChar(BASE_NUMBER);
	}

	/**
	 * 随机字母或数字，小写
	 * 
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static char randomChar() {
		return randomChar(BASE_CHAR_NUMBER);
	}

	/**
	 * 随机生成a~z之间的字符
	 * 
	 * @return
	 */
	public static char randomCharLow() {
		return (char) ('a' + Math.random() * ('z' - 'a' + 1));
	}
	
	/**
	 * 随机字符
	 * 
	 * @param baseString 随机字符选取的样本
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static char randomChar(String baseString) {
		return baseString.charAt(getRandom().nextInt(baseString.length()));
	}

	
	/**
	 * 随机生成A~Z之间的字符
	 * @return 字符
	 */
	public static char randomCharupper() {
		return (char) ('A' + Math.random() * ('Z' - 'A' + 1));
	}
	
	
	/**
	 * 随机生成手机号
	 * @return 手机号
	 */
	public static String randomPhoneNumber() {
		String[] head = { "138", "176", "179", "133", "155", "136", "139", "159", "177", "189", "186", "130", "150",
				"156", "187", "180", "188" };
		String phone = head[randomInt(head.length)];
		for (int i = 0; i < 8; i++) {
			phone = phone + (randomInt(0,10)+"");
		}
		return phone;
	}
	
	/**
	 * 随机生成手机硬件ID
	 * @return 硬件ID
	 */
	public static String randomDeviceID() {
		String eviceID = "";
		// 生成随机的手机硬件ID
		eviceID = randomInt(10000, 100000)+"";
		for (int i = 0; i < 2; i++) {
			eviceID += (randomInt(10000, 100000)+"");
		}
		eviceID = eviceID + String.valueOf(randomInt(0,10)) + String.valueOf(randomChar());
		for (int j = 0; j < 5; j++) {
			eviceID += ":" + String.valueOf(randomInt(0,10)) + String.valueOf(randomChar());
		}
		return eviceID;
	}
	
	/**
	 * 随机生产RegistrationID
	 * @return
	 */
	public static String randomRegistrationID() {
		String registrationID = "";
		// 随机生成19位的融云ID
		registrationID = randomInt(10000, 99999) + "";
		for (int x = 0; x < 4; x++) {
			registrationID += randomCharLow() + "";
		}
		for (int y = 0; y < 2; y++) {
			registrationID += randomInt(1000, 9999) + "";
			registrationID += randomCharLow() + "";
		}
		return registrationID;
	}
	
	/**
	 * 随机返回一位运营商
	 * @return 运营商
	 */
	public static String randomcarrier() {
		String [] s = {"中国电信","中国联通","中国移动"};
		return s[randomInt(s.length)];
	}

	/**
	 * 随机生产设备版本
	 * @return 设备版本
	 */
	public static String randomOsVersion() {
		String[] osv = {"4.2","4.3","4.4","5.0","5.1","6.0","6.1","7.0","8.0"};
		return osv[randomInt(osv.length)];
	}
	
	// ------------------------------------------------------------------- UUID
	/**
	 * @return 随机UUID
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 简化的UUID，去掉了横线
	 * 
	 * @return 简化的UUID，去掉了横线
	 * @since 3.2.2
	 */
	public static String simpleUUID() {
		return randomUUID().replace("-", "");
	}


}
