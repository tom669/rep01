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
		   //����EmpDao DeptDao
		   EmpDao eDao = new EmpDao();
		   DeptDao dDao = new DeptDao();	   
		   //������еĲ���
		      try {
				List<Dept> depts = dDao.queryAll();				
				//������еľ���
				List<Emp> mgrs = eDao.queryMgr();
				//����ѯ�������ݷŵ�request��������
				request.setAttribute("depts", depts);
				request.setAttribute("mgrs", mgrs);
				//ת����ToAddEmp.jsp
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
