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
 * Servlet implementation class ToUpdateEmpServlet
 */
public class ToUpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     //获得员工编号
		      String empno = request.getParameter("empno");
		      //将empno对应的员工从数据库中查出来
		      //创建EmpDao
		        EmpDao dao = new EmpDao();
		       //创建DeptDao
		        DeptDao deptDao = new DeptDao();
		        try {
					Emp emp = dao.queryByEmpno(empno);
					//将emp放到request作用域中
					request.setAttribute("emp", emp);
					//查询所有的部门
					List<Dept> depts = deptDao.queryAll();
					//查询所有的经理
					List<Emp> mgrs = dao.queryMgr();
					//将depts,mgrs放到作用域中
					request.setAttribute("depts", depts);
					request.setAttribute("mgrs", mgrs);
					//转发到修改页面
					request.getRequestDispatcher("UpdateEmp.jsp").forward(request, response);
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
