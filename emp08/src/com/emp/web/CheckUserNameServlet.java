package com.emp.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.UserDao;

/**
 * Servlet implementation class CheckUserNameServlet
 */
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         //��ȡ����
		     String username = request.getParameter("username");
		     System.out.println(username);
		     response.setContentType("text/html; charset=UTF-8");
		     //���username�����ݿ����Ƿ����
		     //�����û�UserDao
		     UserDao dao = new UserDao();
		      try {
				int num = dao.queryUser(username);
				if(num==0){
					 //�û���������,���ݿ���û��username
					response.getWriter().print("OK");
				}else{
					//�û�������ռ��,���ݿ����Ѿ�����username
					response.getWriter().print("FAIL");					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
