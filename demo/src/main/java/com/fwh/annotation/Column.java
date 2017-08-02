package com.fwh.annotation;
import java.lang.annotation.*;
/**
 * 表的列属性
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	/**
	 * 列名
	 * @return
	 */
	 String name() default "";
	 /**
	  * 列长度
	  * @return
	  */
	 String lengths() default "255";
	 /**
	  * 字段类型
	  * @return
	  */
	 String types() default "varchar";//类型
	 /**
	  * 是否能为空
	  * @return
	  */
	 boolean isnull() default false; //是否可为空
	 /**
	  * 是否是主键
	  * @return
	  */
	 boolean primarykey() default false;//是否是主键
}
