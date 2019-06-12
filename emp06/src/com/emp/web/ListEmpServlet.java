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
    private  int pageNo=1;//Ĭ���ǵ�һҳ
    private int pageSize = 4;//Ĭ��һҳ��ʾ3����¼
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
		 //��ȡ��ҳ����pageNo
		   String p = request.getParameter("pageNo");
		   if(p!=null){
			    //���ҳ���ҳ��(������)
			    //pageNo���ǵ�ǰҳ
			    pageNo = Integer.parseInt(p);
		   }
		   //p==null ��һ�η��� ��¼�ɹ����ض��������
		   
		
		//����Ա��Dao
	      EmpDao dao = new EmpDao();
	      //��ѯ���е�Ա��
	      try {
		    //List<Emp> emps = dao.queryAll();
	    	  List<Emp> emps = dao.queryPage(pageNo, pageSize);
	    	  //������ҳ��
	    	  int count = dao.getCount();
	    	  int totalPage = count%pageSize==0?count/pageSize:count/pageSize+1;	    	  
		    //emps�����д�������е�Ա��
		    //��emps���Ϸ��뵽������request��		    
		    request.setAttribute("emps", emps);
		    request.setAttribute("totalPage",totalPage);
		    //����ǰҳ�����request��������
		    request.setAttribute("pageNo", pageNo);
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
