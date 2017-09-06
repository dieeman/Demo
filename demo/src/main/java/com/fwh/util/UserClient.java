package com.fwh.util;


/** 
* @author dieeman
* @date 2017年9月4日 下午3:43:03 
* 获取当前登录用户信息的公共方法  spring 无法通过@autowire的方式注入bean
* 所以直接从容器中获取
*/
public class UserClient {
	public static GetSysClientUser getSysClientUser = (GetSysClientUser) SpringGetBean.getBean("getSysClientUser");
	public static String getUserName(){
		return getSysClientUser.getSysClientUserName();
	}
	public static String getUserId(){
		return getSysClientUser.getSysClientUserId();
	}
}
