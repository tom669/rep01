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
		     //���Ա�����
		      String empno = request.getParameter("empno");
		      //��empno��Ӧ��Ա�������ݿ��в����
		      //����EmpDao
		        EmpDao dao = new EmpDao();
		       //����DeptDao
		        DeptDao deptDao = new DeptDao();
		        try {
					Emp emp = dao.queryByEmpno(empno);
					//��emp�ŵ�request��������
					request.setAttribute("emp", emp);
					//��ѯ���еĲ���
					List<Dept> depts = deptDao.queryAll();
					//��ѯ���еľ���
					List<Emp> mgrs = dao.queryMgr();
					//��depts,mgrs�ŵ���������
					request.setAttribute("depts", depts);
					request.setAttribute("mgrs", mgrs);
					//ת�����޸�ҳ��
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
