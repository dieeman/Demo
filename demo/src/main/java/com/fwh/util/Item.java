package com.fwh.util;
/** 
* @author dieeman
* @date 2017��8��23�� ����10:33:03 
* 
*/
public class Item {
	/**
	 * ���ݿ����
	 */
	private String dataIdentify;
	/**
	 * ����������
	 */
	private String dataName;
	public Item(String dataIdentify,String dataName){
		this.dataIdentify=dataIdentify;
		this.dataName = dataName;
	}
	public String getDataIdentify() {
		return dataIdentify;
	}
	public void setDataIdentify(String dataIdentify) {
		this.dataIdentify = dataIdentify;
	}	
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
}
