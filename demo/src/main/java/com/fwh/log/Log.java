package com.fwh.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.fwh.util.GetSysClientUser;

/**
 * 日志入库
 * @author dieeman
 *
 */
@Aspect
public class Log {	
	/**
	 * 前置增强
	 * @param joinPoint
	 */
	@Before("execution (com.fwh.service.impl.*.*(..))")
	public void saveLog(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();//获取方法名
		//String opContent = optionContent(joinPoint.getArgs(), methodName);
		System.out.println(methodName);
		//String userName = GetSysClientUser.getSysClientUserName();
		//System.out.println("sfs"+userName);
	}
	
}
