package com.emp.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.Emp;
import com.emp.dao.EmpDao;

/**
 * Servlet implementation class UpdateEmpServlet
 */
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     //����request�ı��뼯
		     request.setCharacterEncoding("UTF-8");
		     //��ȡ���� Object
		     String empno = request.getParameter("empno");
		     String ename = request.getParameter("ename");
		     String esex = request.getParameter("esex");
		     Integer eage = Integer.parseInt(request.getParameter("eage"));
		     Float esalary = Float.parseFloat(request.getParameter("esalary"));
		     String deptno = request.getParameter("deptno");
		     String mgrno = request.getParameter("mgrno");
		     //������������װ��Ա������
		     Emp e = new Emp(empno,ename,esex,eage,esalary,deptno,mgrno);
		     //���µ�������
		     //����EmpDao
		      EmpDao dao = new EmpDao();
		      try {
				dao.update(e);
				//���³ɹ�
				//�ض���Ա���б�
				request.getRequestDispatcher("list").forward(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
