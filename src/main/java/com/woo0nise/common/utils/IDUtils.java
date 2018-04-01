package com.woo0nise.common.utils;

import java.util.Random;

/**
 * 各种id生成工具类
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * <p>date: 2017年5月8日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class IDUtils {
	
	/**
	 * 私有化构造
	 */
	private IDUtils() {}
	
	/**
	 * 图片名称生成
	 * <p>
	 * 根据当前时间戳生成+3位随机数
	 * </p>
	 * @return 图片名称
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 商品id生成
	 * <p>
	 * 根据当前时间戳生成+2位随机数
	 * </p>
	 * @return
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
}
