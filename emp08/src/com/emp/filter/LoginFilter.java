package com.emp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.User;

//Filter 过滤器
public class LoginFilter implements Filter{

	@Override
	//跟Servlet中destroy方法是一样功能
	//在tomcat停止时候，会销毁过滤器实例
	//销毁之前，调用这个方法清理资源
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//实现过滤，对请求的拦截都是这个方法完成的
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
	         HttpServletRequest request = (HttpServletRequest)arg0;
	         HttpServletResponse response = (HttpServletResponse)arg1;
	         //登录和注册的请求是不能拦截的
	         String uri = request.getRequestURI();
	         
	         //检查session是否有user对象
	         User user = (User)request.getSession().getAttribute("user");
	        
	         if(user!=null || uri.toUpperCase().contains("LOGIN") || 
	        		 uri.toUpperCase().contains("REG") ||
	        		 uri.toUpperCase().contains("JS") ||
	        		 uri.toUpperCase().contains("CSS") ||
	        		 uri.toUpperCase().contains("JPG") ||
	        		 uri.toUpperCase().contains("PNG")
	        		 ){
	        	 //有,已登录状态
	        	//让请求继续向后访问
	        	 chain.doFilter(request, response);	        	 
	         }else{
	        	 //没有，没有登录
	        	 //转发到登录界面 login.jsp
	        	 request.getRequestDispatcher("login.jsp").forward(request, response);
	         }
	              
	      
	             
		
	}

	@Override
	//初始化方法
	//跟Servlet中的初始化方法一样
	//在过滤器实例创建后,初始化资源
	//参数 FilterConfig 可以读取Servlet的初始化参数
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
