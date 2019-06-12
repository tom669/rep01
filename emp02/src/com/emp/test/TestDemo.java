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
		    	 System.out.println(e.getEname());
		    }
	  }
	  
	   @Test//测试查询所有经理编号
	  public void test2() throws SQLException{
		    EmpDao dao = new EmpDao();
		    List<String> nos = dao.queryMgrno();
		    for(String no:nos){
		    	 System.out.println(no);
		    }
		    //如何在页面上判断某个员工编号就是经理编号
		    boolean bl = nos.contains("e005");
		    System.out.println(bl);
	  }
	   
	   @Test //测试查询所有部门
	  public void test3() throws SQLException{
		   DeptDao dao = new DeptDao();
		    List<Dept> list = dao.queryAll();
		    for(Dept d:list){
		    	 System.out.println(d.getDname());
		    }
	  }
	   
		  @Test //查询所有经理
		  public void test4() throws SQLException{
			    //创建EmpDao
			    EmpDao dao = new EmpDao();
			    List<Emp> emps = dao.queryMgr();
			    for(Emp e:emps){
			    	 System.out.println(e.getEname());
			    }
		  }
}
