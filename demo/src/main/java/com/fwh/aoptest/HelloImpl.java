package com.fwh.aoptest;
/** 
* @author dieeman
* @date 2017年7月18日 上午11:11:41 
* 
*/
public class HelloImpl implements Hello {

	@Override
	public void say(String name) {
		// TODO Auto-generated method stub
		System.out.println("say:"+name);
	}

}
