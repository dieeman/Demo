package com.fwh.util;
import com.fwh.service.impl.DataTransfer;
public class DataTransfertionUtil{	
	public static DataTransfer dataTransfer = (DataTransfer) SpringGetBean.getBean("dataTransfer");
	public static String DataTransfer(String dataIdentify,String dataType){
		String value = dataTransfer.Transfer(dataIdentify, dataType);
		return value;
	}
}
