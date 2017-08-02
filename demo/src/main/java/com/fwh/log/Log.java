package com.fwh.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.fwh.util.GetSysClientUser;

/**
 * ��־���
 * @author dieeman
 *
 */
@Aspect
public class Log {	
	/**
	 * ǰ����ǿ
	 * @param joinPoint
	 */
	@Before("execution (com.fwh.service.impl.*.*(..))")
	public void saveLog(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();//��ȡ������
		//String opContent = optionContent(joinPoint.getArgs(), methodName);
		System.out.println(methodName);
		//String userName = GetSysClientUser.getSysClientUserName();
		//System.out.println("sfs"+userName);
	}
	
}
