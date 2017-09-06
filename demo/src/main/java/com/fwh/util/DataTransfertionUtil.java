package com.fwh.util;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;

import com.fwh.controller.FileController;
import com.fwh.service.impl.DataTransfer;
public class DataTransfertionUtil{	
	private  static Logger logger = Logger.getLogger(DataTransfertionUtil.class);
	public static DataTransfer dataTransfer = (DataTransfer) SpringGetBean.getBean("dataTransfer");
	/**
	 * 
	 * @param dataIdentify 需要翻译的字段的名称对应的代码
	 * @param dataType   翻译的字段值
	 * @return
	 */
	public static String DataTransfer(String dataIdentify,String dataType){
		String value = dataTransfer.Transfer(dataIdentify, dataType);
		return value;
	}
	/**
	 * 利用反射的方式给对象的属性赋值
	 * @param a
	 * @param b
	 * @return
	 */
	public static List transfer(List a,List<Item> b) {
		for(int i=0;i<a.size();i++){
			Object object = a.get(i);
			Class<? extends Object> clazz = object.getClass();
			for(int j=0;j<b.size();j++){				
				Field f;
				try {
					f = clazz.getDeclaredField(b.get(j).getDataName());
					f.setAccessible(true);
					try {
						f.set(object, DataTransfer(b.get(j).getDataIdentify(),f.get(object).toString()));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("未找到："+b.get(j).getDataName()+"属性");
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return a;
	}
}
