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
	 * @param dataIdentify ��Ҫ������ֶε����ƶ�Ӧ�Ĵ���
	 * @param dataType   ������ֶ�ֵ
	 * @return
	 */
	public static String DataTransfer(String dataIdentify,String dataType){
		String value = dataTransfer.Transfer(dataIdentify, dataType);
		return value;
	}
	/**
	 * ���÷���ķ�ʽ����������Ը�ֵ
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
					logger.error("δ�ҵ���"+b.get(j).getDataName()+"����");
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return a;
	}
}
