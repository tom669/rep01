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
		//创建员工Dao
	      EmpDao dao = new EmpDao();
	      //查询所有的员工
	      try {
		    List<Emp> emps = dao.queryAll();
		    //emps集合中存放了所有的员工
		    //将emps集合放入到作用域request中		    
		    request.setAttribute("emps", emps);
		    //查询出所有的经理编号
		    List<String> mgrnos = dao.queryMgrno();
		    //创建Mgrnos对象
		    Mgrnos ms = new Mgrnos();
		    ms.setMgrnos(mgrnos);
		    //将ms放到request作用域中
		    request.setAttribute("ms", ms);
		    //转发 集合emps 也带到ListEmp.jsp页面去了
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
