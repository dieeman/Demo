package com.fwh.aoptest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��̬����
 * @author dieeman
 *
 */
public class DynamicProxybefore implements InvocationHandler {
	private Object target;//�������
	/**
	 * ���췽����ֵ
	 * @param target
	 */
	public DynamicProxybefore(Object target){
		this.target=target;
	}
	@Override
	public Object invoke(Object o, Method method, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	public void before(){
		System.out.println("before");
		
	}
	public void after(){
		System.out.println("after");
	}

}
