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
import javax.servlet.http.HttpServletResponseWrapper;
import com.fwh.domain.User;
/**
 * 判断是否登录
 * @author Administrator
 *
 */
public class SessionFilter implements Filter {
	public FilterConfig config;
	public void destroy() {
		// TODO Auto-generated method stub
		this.config=null;
	}
	public  boolean isContains(String container, String[] regx) { 
		boolean result = false; 
		for (int i = 0; i < regx.length; i++) { 
			if (container.indexOf(regx[i]) != -1) {
				return true; 
				} 
			} 
		return result; 
		}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hrequest = (HttpServletRequest)request;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
        String logonStrings = config.getInitParameter("logonStrings");        // 登录登陆页面
        String includeStrings = config.getInitParameter("includeStrings");    // 过滤资源后缀参数
        String redirectPath = hrequest.getContextPath() + config.getInitParameter("redirectPath");// 没有登陆转向页面
        User user =  (User) hrequest.getSession().getAttribute("user");//判断用户是否登录               
        String disabletestfilter = config.getInitParameter("disabletestfilter");// 过滤器是否有效
        if (disabletestfilter.toUpperCase().equals("Y")) {    // 过滤无效
        	/* 
  		   	 * 使用doFilter方法调用链中的下一个过滤器或目标资源（servlet或JSP页面）。 
  		     * chain.doFilter处理过滤器的其余部分（如果有的话），最终处理请求的servlet或JSP页面。 
  		     */ 
            chain.doFilter(request, response);
            return;
        }
        String[] logonList = logonStrings.split(";");
        String[] includeList = includeStrings.split(";");

        if (!this.isContains(hrequest.getRequestURI(), includeList)) {// 只对指定过滤参数后缀进行过滤
            chain.doFilter(request, response);
            return;
        }
        
        if (this.isContains(hrequest.getRequestURI(), logonList)) {// 对登录页面不进行过滤
            chain.doFilter(request, response);
            return;
        }        
        if (user == null) {
            wrapper.sendRedirect(redirectPath);
            return;
        }else {
            chain.doFilter(request, response);
            return;
        }
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		config = filterConfig;
	}

}
