package com.fwh.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fwh.domain.BorrowBook;
import com.fwh.domain.User;
import com.fwh.service.BorrowService;
import com.fwh.service.UserService;
@Controller
@RequestMapping("/user")
public class LoginController {	
	@Autowired
	public UserService userService;
	@Autowired
	public BorrowService borrowService;
	@RequestMapping("/login.do")
	public String userLogin(ModelMap model,HttpServletRequest req,HttpServletResponse rep) throws IOException, ServletException{	
		HttpSession session = req.getSession();
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		HashMap hashMap = new HashMap();
		hashMap.put("userName", userName);
		hashMap.put("passWord", passWord);		
		User user = (User) session.getAttribute("user");
		if(user!=null){
			return "main";
		}else{					
		List<User> userlist = userService.getUserByMap(hashMap);			
		if(userlist.size()>0){//登陆成功
			user = userlist.get(0);
			session.setAttribute("user", user);
			//查询未还书籍
			List<BorrowBook> borrowlist = borrowService.getBorrowBooks(userlist.get(0).getUserId());
			int total = borrowlist.size();
			model.addAttribute("user", user);
			model.addAttribute("borrowlist", borrowlist);
			model.addAttribute("total", total);
			addCookie(user.getUserName(),rep,req);
			return "main";
		}else{//登录失败
			model.addAttribute("msg", "用户名或密码错误");
			return "../index";			
		}
	  }
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req,HttpServletResponse rep){
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		return "redirect:/";
	}
	/**
	 * 将账号密码保存到cookie中
	 */
	private void addCookie(String name,HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {  	      
	        //创建Cookie  
	        Cookie nameCookie=new Cookie("username",URLEncoder.encode(name,"utf-8"));  	        	          
	        //设置Cookie的父路径  
	        nameCookie.setPath(request.getContextPath()+"/");    	          
	        //获取是否保存Cookie  
	        String rememberMe=request.getParameter("rememberMe");  
	        if(rememberMe==null){//不保存Cookie  
	            nameCookie.setMaxAge(0);   
	        }else{//保存Cookie的时间长度，单位为秒  
	            nameCookie.setMaxAge(7*24*60*60);  
	        }  
	        //加入Cookie到响应头  
	        response.addCookie(nameCookie);  
	    }  
	
}
