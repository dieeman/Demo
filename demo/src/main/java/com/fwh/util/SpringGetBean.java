package com.fwh.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 通过spring容器的到bean
 * @author Administrator
 *
 */
public class SpringGetBean implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringGetBean.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
         return applicationContext;
  	}
	public static Object getBean(String beanId) throws BeansException {
		return applicationContext.getBean(beanId);
	}
}
