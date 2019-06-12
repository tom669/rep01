package com.emp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.Emp;
import com.emp.dao.EmpDao;

/**
 * Servlet implementation class SaveEmpServlet
 */
public class SaveEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              //设置request的编码集
		      request.setCharacterEncoding("UTF-8");
		      //获取参数
		      String ename = request.getParameter("ename");
		      String esex = request.getParameter("esex");
		      Integer eage = Integer.parseInt(request.getParameter("eage"));
		      Float esalary = Float.parseFloat(request.getParameter("esalary"));
		      String deptno = request.getParameter("deptno");
		      String mgrno = request.getParameter("mgrno");
		      //通过UUID生成员工编号
		      String empno = UUID.randomUUID().toString();
		      //创建员工对象
		      Emp emp = new Emp(empno,ename,esex,eage,esalary,deptno,mgrno);
		      //创建EmpDao
		      EmpDao dao = new EmpDao();
		      try {
		    	//将员工保存到数据库中
				dao.save(emp);
			    //保存成功,跳转至员工列表(url-pattern:/list)
				//重定向
				request.getRequestDispatcher("list").forward(request, response);
			} catch (SQLException e) {
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
