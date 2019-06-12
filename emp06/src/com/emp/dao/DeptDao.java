package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.bean.Dept;
import com.emp.util.DBUtils;

//���� t_dept��
public class DeptDao {
    //��ѯ���в��ż�¼
	public List<Dept> queryAll() throws SQLException{
		 //sql
		 String sql = "select * from t_dept";
		 List<Dept> depts = null;
		 //�����������Ľӿ�
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //������Ӷ���
		  try {
			conn = DBUtils.getConnection();
		  //���Ԥ�������
			prep = conn.prepareStatement(sql);
		  //����Ԥ�����ļ����������ݿ�
		   rs = prep.executeQuery();
		   //�������������װ����ֵ����
		   while(rs.next()){
			   if(depts==null){
				    //��һ��ѭ��deptsΪnull
				   //��deptsʵ����
				   depts = new ArrayList<Dept>();
			   }
			   //�������Ŷ���
			    Dept dept = new Dept();
			    //��rs�е��������dept����
			    dept.setDeptno(rs.getString("deptno"));
			    dept.setDname(rs.getString("dname"));
			    dept.setLocation(rs.getString("location"));
			    //��dept������뷵��ֵ������
			    depts.add(dept);
		   }
		   //sqlû�в�ѯ������,deptsΪnull
		   return depts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //�ر���Դ
			 DBUtils.closeAll(rs, prep, conn);
		}
		  
	}
}
