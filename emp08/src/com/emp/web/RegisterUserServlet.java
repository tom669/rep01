package com.emp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.User;
import com.emp.dao.UserDao;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //����request�ı��뼯
		    request.setCharacterEncoding("UTF-8");
		    //��ȡҳ�����
		    String user_name = request.getParameter("username");
		    String user_pass = request.getParameter("password");
		    //��UUID�����û�id
		    String user_id = UUID.randomUUID().toString();
		    //����һ���û�����
		    User user = new User(user_id,user_name,user_pass);
		    //��user���󱣴浽���ݿ���
		    //����UserDao
		    UserDao dao = new UserDao();
		     try {
				dao.saveUser(user);
				//����ɹ�
				//�ض��򵽵�¼����login.jsp
				response.sendRedirect("login.jsp");
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
