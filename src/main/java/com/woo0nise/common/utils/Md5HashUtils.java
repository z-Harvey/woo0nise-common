package com.woo0nise.common.utils;

import java.security.MessageDigest;

/**
 * MD5工具工具类
 * <p>Title: Md5HashUtils</p>
 * <p>Description: </p>
 * <p>date: 2017年6月17日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class Md5HashUtils {
	
	/**
	 * 私有化构造
	 */
	private Md5HashUtils(){}

	/**
	 * 生成md5值(32)位
	 * @param encryptStr 需要加密的字符串
	 * @return 生成结果
	 */
    public static String encrypt32(String encryptStr) {  
        MessageDigest md5;  
        try {  
            md5 = MessageDigest.getInstance("MD5");  
            byte[] md5Bytes = md5.digest(encryptStr.getBytes());  
            StringBuffer hexValue = new StringBuffer();  
            for (int i = 0; i < md5Bytes.length; i++) {  
                int val = ((int) md5Bytes[i]) & 0xff;  
                if (val < 16)  
                    hexValue.append("0");  
                hexValue.append(Integer.toHexString(val));  
            }  
            encryptStr = hexValue.toString();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return encryptStr;  
    }
    
	/**
	 * 生成md5值(16)位
	 * @param encryptStr 需要加密的字符串
	 * @return 生成结果
	 */
    public static String encrypt16(String encryptStr) {  
        return encrypt32(encryptStr).substring(8, 24);  
    }  
	
}
