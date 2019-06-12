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

//Filter ������
public class LoginFilter implements Filter{

	@Override
	//��Servlet��destroy������һ������
	//��tomcatֹͣʱ�򣬻����ٹ�����ʵ��
	//����֮ǰ�������������������Դ
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//ʵ�ֹ��ˣ�����������ض������������ɵ�
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
	         HttpServletRequest request = (HttpServletRequest)arg0;
	         HttpServletResponse response = (HttpServletResponse)arg1;
	         //��¼��ע��������ǲ������ص�
	         String uri = request.getRequestURI();
	         
	         //���session�Ƿ���user����
	         User user = (User)request.getSession().getAttribute("user");
	        
	         if(user!=null || uri.toUpperCase().contains("LOGIN") || 
	        		 uri.toUpperCase().contains("REG") ||
	        		 uri.toUpperCase().contains("JS") ||
	        		 uri.toUpperCase().contains("CSS") ||
	        		 uri.toUpperCase().contains("JPG") ||
	        		 uri.toUpperCase().contains("PNG")
	        		 ){
	        	 //��,�ѵ�¼״̬
	        	//���������������
	        	 chain.doFilter(request, response);	        	 
	         }else{
	        	 //û�У�û�е�¼
	        	 //ת������¼���� login.jsp
	        	 request.getRequestDispatcher("login.jsp").forward(request, response);
	         }
	              
	      
	             
		
	}

	@Override
	//��ʼ������
	//��Servlet�еĳ�ʼ������һ��
	//�ڹ�����ʵ��������,��ʼ����Դ
	//���� FilterConfig ���Զ�ȡServlet�ĳ�ʼ������
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
