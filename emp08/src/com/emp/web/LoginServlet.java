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
		        //����request�ı��뷽ʽ
		       request.setCharacterEncoding("UTF-8");
		       String username = request.getParameter("username");
		       String password = request.getParameter("password");
		       //����UserDao
		       UserDao dao = new UserDao();
		       try {
				User user = dao.findUser(username, password);
				if(user!=null){
					//��¼�ɹ�
					//��user�������session�б�ʶ��ǰ�ǵ�¼��״̬
					request.getSession().setAttribute("user", user);
					//�ض���Ա���б�ҳ��
					response.sendRedirect("list");
				}else{
					//�û������������
					//�󶨴�����Ϣ
					request.setAttribute("info", "�û������������");
					//ת������¼ҳ��
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
