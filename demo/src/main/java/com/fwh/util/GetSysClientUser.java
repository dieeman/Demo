package com.fwh.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.*;

import com.fwh.domain.User;

/** 
* @author dieeman
* @date 2017年7月18日 上午11:25:45 
* 
*/
public class GetSysClientUser {
	private static HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	private static HttpSession session = req.getSession();
	public static String getSysClientUserId(){
		//HttpServletRequest req = ((Object) RequestContextHolder.getRequestAttributes()).getRequest();
		//HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		return userId;
	}
	public static String getSysClientUserName(){
		//HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String userName = user.getUserName();
		return userName;
	}
}
