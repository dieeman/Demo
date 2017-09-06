package com.fwh.log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.fwh.util.UserClient;


/**
 * aop
 * @author dieeman
 * 需要开启aop注解功能 采用注解才能成功
 */
@Aspect
@Component
public class Log {	
	@Pointcut("execution (* com.fwh.service.impl.BookServiceImpl.*(..))")
	public void allmethod(){}
	@Before("allmethod()")
	public void saveLog(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();//获取方法名
		//String opContent = optionContent(joinPoint.getArgs(), methodName);
		System.out.println("前置通知");
		System.out.println("方法名：  "+methodName);
		String userName = UserClient.getUserName();
		System.out.println("操作人："+userName);
	}
	
}
