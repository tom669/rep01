package com.emp.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.emp.bean.Dept;
import com.emp.bean.Emp;
import com.emp.dao.DeptDao;
import com.emp.dao.EmpDao;

public class TestDemo {

	 @Test
	  public void test() throws SQLException{
		   //����EmpDao
		   EmpDao dao = new EmpDao();
		    List<Emp> emps = dao.queryAll();
		    for(Emp e:emps){
		    	 System.out.println(e.getEname()+","+e.getDept().getDname()+","+e.getMgr().getEname());
		    }
	  }
	 
	 @Test
	  public void test2() throws SQLException{
		   //����EmpDao
		   EmpDao dao = new EmpDao();
		   Emp e = dao.queryByEmpno("e001");
		  System.out.println(e.getEname()+","+e.getDept().getDname()
				  +","+e.getMgr().getEname());
	  }
	 
	 @Test
	  public void test3() throws SQLException{
		   //����EmpDao
		  //���µ�ǰ���ǲ�ѯ
		   EmpDao dao = new EmpDao();
		   //���Ȳ�ѯ���ܴ�
		   Emp e = dao.queryByEmpno("e001");
		   e.setEsalary(30000F);
		   dao.update(e);
		   System.out.println("OK");
		
	  }
	 
	 @Test
	 public void test4(){
		 String uri = "/emp03/login.jsp";
		  //uri���Ƿ����login
		  //Login.jsp  login.jsp   toLogin.jsp  ToLogin.jsp  to_login.jsp
		 //System.out.println(uri.contains("xxx"));
		 //����޲����жϣ����Դ�Сд
		 uri  = uri.toUpperCase();
		 System.out.println(uri.contains("LOGIN"));
	 }
	 
	 @Test //������������ҳ
	 public void test5() throws SQLException{
		   //����EmpDao
		 EmpDao dao = new EmpDao();
		  List<Emp> emps = dao.queryPage(2, 4);
		  for(Emp e:emps){
			   System.out.println(e.getEname());
		  }
	 }
	 
	 @Test //���Ի�ȡ�ܼ�¼��
	 public void test6() throws SQLException{
		   //����EmpDao
		 EmpDao dao = new EmpDao();
		   int num = dao.getCount();
		   System.out.println(num);
	 }

}
