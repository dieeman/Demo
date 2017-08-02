package com.fwh.annotation;

import java.lang.annotation.*;
/**
 * 自定义注解 实现自动建表
 * @author dieeman
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	/**
	 * 表名
	 * @return
	 */
	String name() default "";
}
