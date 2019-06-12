package com.emp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.Dept;
import com.emp.bean.Emp;
import com.emp.dao.DeptDao;
import com.emp.dao.EmpDao;

/**
 * Servlet implementation class ToAddEmpServlet
 */
public class ToAddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAddEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   //创建EmpDao DeptDao
		   EmpDao eDao = new EmpDao();
		   DeptDao dDao = new DeptDao();	   
		   //获得所有的部门
		      try {
				List<Dept> depts = dDao.queryAll();				
				//获得所有的经理
				List<Emp> mgrs = eDao.queryMgr();
				//将查询出的数据放到request作用域中
				request.setAttribute("depts", depts);
				request.setAttribute("mgrs", mgrs);
				//转发到ToAddEmp.jsp
				request.getRequestDispatcher("ToAddEmp.jsp").forward(request, response);
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
