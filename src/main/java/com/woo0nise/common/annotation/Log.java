package com.woo0nise.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志处理注解Log 
 * <p>Title: Log</p>
 * <p>Description: </p>
 * <p>date: 2017年5月8日  </p>
 * <p>Email woo0nise@gmail.com </p>
 * <p>Company:www.hack-gov.com </p>
 * @author: 0nise
 * @version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 日志保存
	 * 
	 * @return 执行操作
	 */
	String value() default "";
}
