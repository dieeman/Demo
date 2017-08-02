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
		if(userlist.size()>0){//��½�ɹ�
			user = userlist.get(0);
			session.setAttribute("user", user);
			//��ѯδ���鼮
			List<BorrowBook> borrowlist = borrowService.getBorrowBooks(userlist.get(0).getUserId());
			int total = borrowlist.size();
			model.addAttribute("user", user);
			model.addAttribute("borrowlist", borrowlist);
			model.addAttribute("total", total);
			addCookie(user.getUserName(),rep,req);
			return "main";
		}else{//��¼ʧ��
			model.addAttribute("msg", "�û������������");
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
	 * ���˺����뱣�浽cookie��
	 */
	private void addCookie(String name,HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {  	      
	        //����Cookie  
	        Cookie nameCookie=new Cookie("username",URLEncoder.encode(name,"utf-8"));  	        	          
	        //����Cookie�ĸ�·��  
	        nameCookie.setPath(request.getContextPath()+"/");    	          
	        //��ȡ�Ƿ񱣴�Cookie  
	        String rememberMe=request.getParameter("rememberMe");  
	        if(rememberMe==null){//������Cookie  
	            nameCookie.setMaxAge(0);   
	        }else{//����Cookie��ʱ�䳤�ȣ���λΪ��  
	            nameCookie.setMaxAge(7*24*60*60);  
	        }  
	        //����Cookie����Ӧͷ  
	        response.addCookie(nameCookie);  
	    }  
	
}
