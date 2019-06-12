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
		    	 System.out.println(e.getEname());
		    }
	  }
	  
	   @Test//���Բ�ѯ���о�����
	  public void test2() throws SQLException{
		    EmpDao dao = new EmpDao();
		    List<String> nos = dao.queryMgrno();
		    for(String no:nos){
		    	 System.out.println(no);
		    }
		    //�����ҳ�����ж�ĳ��Ա����ž��Ǿ�����
		    boolean bl = nos.contains("e005");
		    System.out.println(bl);
	  }
	   
	   @Test //���Բ�ѯ���в���
	  public void test3() throws SQLException{
		   DeptDao dao = new DeptDao();
		    List<Dept> list = dao.queryAll();
		    for(Dept d:list){
		    	 System.out.println(d.getDname());
		    }
	  }
	   
		  @Test //��ѯ���о���
		  public void test4() throws SQLException{
			    //����EmpDao
			    EmpDao dao = new EmpDao();
			    List<Emp> emps = dao.queryMgr();
			    for(Emp e:emps){
			    	 System.out.println(e.getEname());
			    }
		  }
}
