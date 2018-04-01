package com.woo0nise.common.utils;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 * <p>Title: JsonUtils</p>
 * <p>Description: Jackson工具类</p>
 * <p>date: 2017年5月8日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
public class JsonUtils {
	
	/**
	 * 私有化构造,防止被实例化
	 */
	private JsonUtils() {}

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * @param data 对象
     * @return 转换结果
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return 转换结果
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return 转换结果
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
}
