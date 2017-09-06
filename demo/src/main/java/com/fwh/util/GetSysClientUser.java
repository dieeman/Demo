package com.fwh.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.*;

import com.fwh.domain.User;

/** 
* @author dieeman
* @date 2017��7��18�� ����11:25:45 
* ��ȡ��ǰ�����������
* request����ʱ����һ���߳� �����request���ܲ��þ�̬ ��̬�Ļ�����request����
* ����ͬ���˷�������ʱ�����request�����޷�ʶ��ǰ��request
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
