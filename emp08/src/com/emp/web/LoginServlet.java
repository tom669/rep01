package com.emp.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.bean.User;
import com.emp.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //设置request的编码方式
		       request.setCharacterEncoding("UTF-8");
		       String username = request.getParameter("username");
		       String password = request.getParameter("password");
		       //创建UserDao
		       UserDao dao = new UserDao();
		       try {
				User user = dao.findUser(username, password);
				if(user!=null){
					//登录成功
					//将user对象放入session中标识当前是登录的状态
					request.getSession().setAttribute("user", user);
					//重定向到员工列表页面
					response.sendRedirect("list");
				}else{
					//用户名或密码错误
					//绑定错误消息
					request.setAttribute("info", "用户名或密码错误");
					//转发到登录页面
					request.getRequestDispatcher("login.jsp").forward(request, response);
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
