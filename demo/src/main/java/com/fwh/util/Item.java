package com.fwh.util;
/** 
* @author dieeman
* @date 2017年8月23日 上午10:33:03 
* 
*/
public class Item {
	/**
	 * 数据库代码
	 */
	private String dataIdentify;
	/**
	 * 对象属性名
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
