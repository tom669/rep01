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
		    //设置request的编码集
		    request.setCharacterEncoding("UTF-8");
		    //获取页面参数
		    String user_name = request.getParameter("username");
		    String user_pass = request.getParameter("password");
		    //用UUID生成用户id
		    String user_id = UUID.randomUUID().toString();
		    //创建一个用户对象
		    User user = new User(user_id,user_name,user_pass);
		    //将user对象保存到数据库中
		    //创建UserDao
		    UserDao dao = new UserDao();
		     try {
				dao.saveUser(user);
				//保存成功
				//重定向到登录界面login.jsp
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
