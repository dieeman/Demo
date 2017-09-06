package com.fwh.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.*;

import com.fwh.domain.User;

/** 
* @author dieeman
* @date 2017年7月18日 上午11:25:45 
* 获取当前操作对象的类
* request请求时产生一个线程 这里的request不能采用静态 静态的话会是request共享
* 当不同的人发送请求时会造成request混乱无法识别当前的request
* 
*/
public class GetSysClientUser {
	//private  HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	//private  HttpSession session = req.getSession();
	//private  HttpSession session = (HttpSession) ThreadLocalFactory.getThreadLocal().get();
	@Autowired
	public HttpServletRequest req;
	@Autowired
	public HttpSession session;
	public String getSysClientUserId(){
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		return userId;
	}
	public  String getSysClientUserName(){
		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();
		return userName;
	}
	public User getSysClientUser(){
		return (User) session.getAttribute("user");
	}
}
