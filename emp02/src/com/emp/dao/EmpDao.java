package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.bean.Emp;
import com.emp.util.DBUtils;

public class EmpDao {
	 //��ѯ���еľ���
	 public List<Emp> queryMgr() throws SQLException{
		   //sql	
		 String sql = " select * from t_emp  ";
		 sql += " where empno in( ";
		 sql += " select distinct mgrno from t_emp ) ";
		 //���´����queryAll()����100%��ͬ		 
		 List<Emp> emps = null;
		 //�����������Ľӿ�
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //������Ӷ���
		   try {
			conn = DBUtils.getConnection();
	     //���Ԥ�������
			prep = conn.prepareStatement(sql);
	      //����Ԥ�����ļ�,�������ݿ�
		 //���ؽ��������
	      rs = prep.executeQuery();
	      while(rs.next()){
	    	   if(emps==null){
	    		    //��һ��ѭ��,empsһ��Ϊnull
	    		    //��empsʵ����
	    		    emps = new ArrayList<Emp>();
	    	   }
	    	   //����һ��Ա������
	    	   Emp emp = new Emp();
	    	   //��rs���������emp����
	    	   emp.setEmpno(rs.getString("empno"));
	    	   emp.setEname(rs.getString("ename"));
	    	   emp.setEsex(rs.getString("esex"));
	    	   emp.setEage(rs.getInt("eage"));
	    	   emp.setEsalary(rs.getFloat("esalary"));
	    	   emp.setDeptno(rs.getString("deptno"));
	    	   emp.setMgrno(rs.getString("mgrno"));
	    	   //��emp������ӵ�emps������
	    	   emps.add(emp);
	      }
	      //û�в�ѯ������empsΪnull
	      return emps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			  //�ر���Դ
			  DBUtils.closeAll(rs, prep, conn);
		}
	 }
	 //��ѯ���о����Ա�����
	 public List<String> queryMgrno() throws SQLException{
		   //sql
		   String sql = "select distinct mgrno from t_emp";
		   List<String> list = null;
		   //�����������Ľӿ�
		   Connection conn = null;
		   PreparedStatement prep = null;
		   ResultSet rs = null;
		   
		   //�������
		   try {
			conn = DBUtils.getConnection();
			//���Ԥ�������
			prep = conn.prepareStatement(sql);
			//����Ԥ�����ļ����������ݿ�
			rs = prep.executeQuery();
			//�������������װ����ֵ
			while(rs.next()){
				  if(list==null){
					   //��һ��ѭ��,listһ��Ϊnull
					   //ʵ����list
					   list = new ArrayList<String>();
				  }
				  //��rs�е�����ȡ�������list
				  list.add(rs.getString("mgrno"));
			}
			//û�в�ѯ������listΪnull
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //�ر���Դ
			 DBUtils.closeAll(rs, prep, conn);
		}
		   
	 }
	
	 //����Ա����ţ��޸�Ա����Ϣ
	 public void update(Emp emp) throws SQLException{
		    //sql
		    //���������޸�һ����¼
		    //������������������ֶΣ��������޸�
		   String sql = " update t_emp set ename=?,esex=?,eage=?,esalary=?,deptno=?,mgrno=? "
		   		+ " where empno=? ";
		   //�����������Ľӿ�
		    Connection conn = null;
		    PreparedStatement prep = null;
		    
		    //������Ӷ���
		    try {
				conn = DBUtils.getConnection();
		     //���Ԥ�������
				prep = conn.prepareStatement(sql);
				//���ò���
				prep.setString(1, emp.getEname());
				prep.setString(2, emp.getEsex());
				prep.setInt(3, emp.getEage());
				prep.setFloat(4, emp.getEsalary());
				prep.setString(5, emp.getDeptno());
				prep.setString(6, emp.getMgrno());
				prep.setString(7, emp.getEmpno());
				//����Ԥ�����ļ����������ݿ�
				prep.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}finally{
				 //�ر���Դ
				 DBUtils.closeAll(null, prep, conn);
			}
		   
	 }
	
	//����Ա����Ų�ѯһ��Ա����¼
	public Emp queryByEmpno(String empno) throws SQLException{
		 //sql
		 String sql = "select * from t_emp where empno=?";
		 //��������ֵ
		 Emp emp = null;
		 //�����������Ľӿ�
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //������Ӷ���
		   try {
			conn = DBUtils.getConnection();
	     //���Ԥ�������
			prep = conn.prepareStatement(sql);
			//���ò���
			prep.setString(1, empno);
	      //����Ԥ�����ļ�,�������ݿ�
		 //���ؽ��������
	      rs = prep.executeQuery();
	      while(rs.next()){
	    	   //����һ��Ա������
	           emp = new Emp();
	    	   //��rs���������emp����
	    	   emp.setEmpno(rs.getString("empno"));
	    	   emp.setEname(rs.getString("ename"));
	    	   emp.setEsex(rs.getString("esex"));
	    	   emp.setEage(rs.getInt("eage"));
	    	   emp.setEsalary(rs.getFloat("esalary"));
	    	   emp.setDeptno(rs.getString("deptno"));
	    	   emp.setMgrno(rs.getString("mgrno"));
	      }
	      //û�в�ѯ������empΪnull
	      return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			  //�ر���Դ
			  DBUtils.closeAll(rs, prep, conn);
		}
		 
	}
	
	//ɾ��һ����¼
	public void delete(String empno) throws SQLException{
		  //sql
		  String sql = "delete from t_emp where empno=?";
		  //�����������Ľӿ�
		  Connection conn = null;
		  PreparedStatement prep = null;
		  
		  //������Ӷ���
		  try {
			conn = DBUtils.getConnection();
			//���Ԥ�������
			prep = conn.prepareStatement(sql);
			//���ò���
			prep.setString(1, empno);
			//����Ԥ�����ļ����������ݿ�
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //�ر���Դ
			 DBUtils.closeAll(null, prep, conn);
		}
		  
	}
	
	//����һ����¼
	public void save(Emp emp) throws SQLException{
		//sql
		String sql = "insert into t_emp values (?,?,?,?,?,?,?)";
		//�����������Ľӿ�
		Connection conn = null;
		PreparedStatement prep = null;
		
		//������Ӷ���
		  try {
			conn = DBUtils.getConnection();
	     //���Ԥ�������
			prep = conn.prepareStatement(sql);
		  //���ò���
			prep.setString(1, emp.getEmpno());
			prep.setString(2, emp.getEname());
			prep.setString(3, emp.getEsex());
			prep.setInt(4, emp.getEage());
			prep.setFloat(5, emp.getEsalary());
			prep.setString(6, emp.getDeptno());
			prep.setString(7, emp.getMgrno());
		  //����Ԥ�����ļ����������ݿ�
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //�ر���Դ
			 DBUtils.closeAll(null, prep, conn);
		}
	}
	
	
    //��ѯ���еļ�¼
	public List<Emp> queryAll() throws SQLException{
		 //sql
		 String sql = "select * from t_emp";
		 //��������ֵ
		 List<Emp> emps = null;
		 //�����������Ľӿ�
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //������Ӷ���
		   try {
			conn = DBUtils.getConnection();
	     //���Ԥ�������
			prep = conn.prepareStatement(sql);
	      //����Ԥ�����ļ�,�������ݿ�
		 //���ؽ��������
	      rs = prep.executeQuery();
	      while(rs.next()){
	    	   if(emps==null){
	    		    //��һ��ѭ��,empsһ��Ϊnull
	    		    //��empsʵ����
	    		    emps = new ArrayList<Emp>();
	    	   }
	    	   //����һ��Ա������
	    	   Emp emp = new Emp();
	    	   //��rs���������emp����
	    	   emp.setEmpno(rs.getString("empno"));
	    	   emp.setEname(rs.getString("ename"));
	    	   emp.setEsex(rs.getString("esex"));
	    	   emp.setEage(rs.getInt("eage"));
	    	   emp.setEsalary(rs.getFloat("esalary"));
	    	   emp.setDeptno(rs.getString("deptno"));
	    	   emp.setMgrno(rs.getString("mgrno"));
	    	   //��emp������ӵ�emps������
	    	   emps.add(emp);
	      }
	      //û�в�ѯ������empsΪnull
	      return emps;
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
