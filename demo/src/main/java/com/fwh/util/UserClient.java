package com.fwh.util;


/** 
* @author dieeman
* @date 2017��9��4�� ����3:43:03 
* ��ȡ��ǰ��¼�û���Ϣ�Ĺ�������  spring �޷�ͨ��@autowire�ķ�ʽע��bean
* ����ֱ�Ӵ������л�ȡ
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
