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
		   //创建EmpDao
		   EmpDao dao = new EmpDao();
		    List<Emp> emps = dao.queryAll();
		    for(Emp e:emps){
		    	 System.out.println(e.getEname()+","+e.getDept().getDname()+","+e.getMgr().getEname());
		    }
	  }
	 
	 @Test
	  public void test2() throws SQLException{
		   //创建EmpDao
		   EmpDao dao = new EmpDao();
		   Emp e = dao.queryByEmpno("e001");
		  System.out.println(e.getEname()+","+e.getDept().getDname()
				  +","+e.getMgr().getEname());
	  }
	 
	 @Test
	  public void test3() throws SQLException{
		   //创建EmpDao
		  //更新的前提是查询
		   EmpDao dao = new EmpDao();
		   //首先查询出熊大
		   Emp e = dao.queryByEmpno("e001");
		   e.setEsalary(30000F);
		   dao.update(e);
		   System.out.println("OK");
		
	  }
	 
	 @Test
	 public void test4(){
		 String uri = "/emp03/login.jsp";
		  //uri中是否包含login
		  //Login.jsp  login.jsp   toLogin.jsp  ToLogin.jsp  to_login.jsp
		 //System.out.println(uri.contains("xxx"));
		 //如何无差别的判断，忽略大小写
		 uri  = uri.toUpperCase();
		 System.out.println(uri.contains("LOGIN"));
	 }
	 
	 @Test //测试无条件分页
	 public void test5() throws SQLException{
		   //创建EmpDao
		 EmpDao dao = new EmpDao();
		  List<Emp> emps = dao.queryPage(2, 4);
		  for(Emp e:emps){
			   System.out.println(e.getEname());
		  }
	 }
	 
	 @Test //测试获取总记录数
	 public void test6() throws SQLException{
		   //创建EmpDao
		 EmpDao dao = new EmpDao();
		   int num = dao.getCount();
		   System.out.println(num);
	 }

}
