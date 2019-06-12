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
import com.emp.util.PageBean;

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
		 //����request�ı��뷽ʽ
		  request.setCharacterEncoding("UTf-8");
		//��ȡ��ҳ����pageNo
		   String p = request.getParameter("pageNo");
		  //��ȡ��������
		  String condition = request.getParameter("condition");
		   
		   if(p!=null){
			    //���ҳ���ҳ��(������)
			    //pageNo���ǵ�ǰҳ
			    pageNo = Integer.parseInt(p);
		   }
		   //p==null ��һ�η��� ��¼�ɹ����ض��������
		   //����PageBean����
		   PageBean<Emp> pb = new PageBean<Emp>();
		   //pb������������
		   	  if(condition==null){
	    		   condition = "";
	    	  }
		    pb.setCondition(condition);
		    
		//����Ա��Dao
	      EmpDao dao = new EmpDao();
	      //��ѯ���е�Ա��
	      try {
		    //List<Emp> emps = dao.queryAll();
	    	  List<Emp> emps = dao.queryPage(pageNo, pageSize,condition);
	    	  pb.setList(emps);	    	  
	    	  //����ܼ�¼��
	 
	    	  int count = dao.getCount(condition);
	         pb.setCount(count);
             pb.setPageNo(pageNo);
             pb.setPageSize(pageSize);
             //ԭ���ŵ�request�еĶ��������ŵ�pageBean����
             //ֻ��Ҫ��pageBean�ŵ�request�й�����
             request.setAttribute("pb", pb);
 
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
