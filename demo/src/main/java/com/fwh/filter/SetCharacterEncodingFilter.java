package com.fwh.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SetCharacterEncodingFilter implements Filter {
	private String encoding=null;
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)  
		   throws IOException,ServletException{  
	    //ת��  
		HttpServletRequest request = (HttpServletRequest)req;  
		HttpServletResponse response = (HttpServletResponse)resp;  			    
		/* 
		 * �ж���web.xml�ļ����Ƿ������˱����ʽ����Ϣ 
		 * ���Ϊ�գ������ñ����ʽΪ�����ļ��еı����ʽ 
		 * ��������ʽ����ΪGBK 
		 */  
	    if(this.encoding != null && !this.encoding.equals("")){  
		   request.setCharacterEncoding(this.encoding);  
		   response.setCharacterEncoding(this.encoding);  
		  }else{  
		   request.setCharacterEncoding("utf-8");  
		   response.setCharacterEncoding("utf-8");  
		  }  		    
		  /* 
		   * ʹ��doFilter�����������е���һ����������Ŀ����Դ��servlet��JSPҳ�棩�� 
		   * chain.doFilter��������������ಿ�֣�����еĻ��������մ��������servlet��JSPҳ�档 
		   */  
		  chain.doFilter(request, response);  
		 }  
		   
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encode");	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}			 
	
	}
