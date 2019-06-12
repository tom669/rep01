package com.emp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.Emp;
import com.emp.dao.EmpDao;
import com.emp.util.Mgrnos;

/**
 * Servlet implementation class ListEmpServlet
 */
public class ListEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����Ա��Dao
	      EmpDao dao = new EmpDao();
	      //��ѯ���е�Ա��
	      try {
		    List<Emp> emps = dao.queryAll();
		    //emps�����д�������е�Ա��
		    //��emps���Ϸ��뵽������request��		    
		    request.setAttribute("emps", emps);
		    //��ѯ�����еľ�����
		    List<String> mgrnos = dao.queryMgrno();
		    //����Mgrnos����
		    Mgrnos ms = new Mgrnos();
		    ms.setMgrnos(mgrnos);
		    //��ms�ŵ�request��������
		    request.setAttribute("ms", ms);
		    //ת�� ����emps Ҳ����ListEmp.jspҳ��ȥ��
		    request.getRequestDispatcher("ListEmp.jsp").forward(request, response);
			
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
