package com.fwh.annotation;

import java.lang.annotation.*;
/**
 * �Զ���ע�� ʵ���Զ�����
 * @author dieeman
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	/**
	 * ����
	 * @return
	 */
	String name() default "";
}
