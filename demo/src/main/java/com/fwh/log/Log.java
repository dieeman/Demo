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
 * ��Ҫ����aopע�⹦�� ����ע����ܳɹ�
 */
@Aspect
@Component
public class Log {	
	@Pointcut("execution (* com.fwh.service.impl.BookServiceImpl.*(..))")
	public void allmethod(){}
	@Before("allmethod()")
	public void saveLog(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();//��ȡ������
		//String opContent = optionContent(joinPoint.getArgs(), methodName);
		System.out.println("ǰ��֪ͨ");
		System.out.println("��������  "+methodName);
		String userName = UserClient.getUserName();
		System.out.println("�����ˣ�"+userName);
	}
	
}
