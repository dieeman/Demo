package com.fwh.annotation;
import java.lang.annotation.*;
/**
 * ���������
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	/**
	 * ����
	 * @return
	 */
	 String name() default "";
	 /**
	  * �г���
	  * @return
	  */
	 String lengths() default "255";
	 /**
	  * �ֶ�����
	  * @return
	  */
	 String types() default "varchar";//����
	 /**
	  * �Ƿ���Ϊ��
	  * @return
	  */
	 boolean isnull() default false; //�Ƿ��Ϊ��
	 /**
	  * �Ƿ�������
	  * @return
	  */
	 boolean primarykey() default false;//�Ƿ�������
}
