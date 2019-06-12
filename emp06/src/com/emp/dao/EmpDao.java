package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.bean.Dept;
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
	    	   //��emp�������ӵ�emps������
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
	 //��ѯ���о�����Ա�����
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
				prep.setString(5, emp.getDept().getDeptno());
				prep.setString(6, emp.getMgr().getEmpno());
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
	 //sql	
	 String sql = " select e.empno ,e.ename ,e.esex,e.eage,e.esalary, ";
	  sql += " d.deptno,d.dname,d.location, ";
	  sql += " m.empno 'mgrno',m.ename 'mename' ";
	  sql += " from t_emp e left join t_dept d ";
	  sql += " on e.deptno = d.deptno ";
	  sql += " left join t_emp m ";
	  sql += " on e.mgrno = m.empno ";
	  sql += " where e.empno=? ";
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
	    	   //����һ�����Ŷ���
	    	   Dept d = new Dept();
	    	   d.setDeptno(rs.getString("deptno"));
	    	   d.setDname(rs.getString("dname"));
	    	   d.setLocation(rs.getString("location"));
	    	   //���������ø�Ա��
	    	   emp.setDept(d);
	    	   //����һ����������(ʵ�ʻ���Ա��)
	    	   Emp mgr = new Emp();
	    	   mgr.setEmpno(rs.getString("mgrno"));
	    	   mgr.setEname(rs.getString("mename"));
	    	   //���������ø�Ա��
	    	   emp.setMgr(mgr);
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
			prep.setString(6, emp.getDept().getDeptno());
			prep.setString(7, emp.getMgr().getEmpno());
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
		 String sql = " select e.empno ,e.ename ,e.esex,e.eage,e.esalary, ";
		  sql += " d.deptno,d.dname,d.location, ";
		  sql += " m.empno 'mgrno',m.ename 'mename' ";
		  sql += " from t_emp e left join t_dept d ";
		  sql += " on e.deptno = d.deptno ";
		  sql += " left join t_emp m ";
		  sql += " on e.mgrno = m.empno ";
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
	    	   //����һ�����Ŷ���
	    	   Dept d = new Dept();
	    	   d.setDeptno(rs.getString("deptno"));
	    	   d.setDname(rs.getString("dname"));
	    	   d.setLocation(rs.getString("location"));
	    	   //���������ø�Ա��
	    	   emp.setDept(d);
	    	   //����һ����������(ʵ�ʻ���Ա��)
	    	   Emp mgr = new Emp();
	    	   mgr.setEmpno(rs.getString("mgrno"));
	    	   mgr.setEname(rs.getString("mename"));
	    	   //���������ø�Ա��
	    	   emp.setMgr(mgr);
	    	   //��emp�������ӵ�emps������
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
	
	
	//��������ҳ��ѯ
	public List<Emp> queryPage(int pageNo,int pageSize) throws SQLException{
		 //sql	
		 String sql = " select e.empno ,e.ename ,e.esex,e.eage,e.esalary, ";
		  sql += " d.deptno,d.dname,d.location, ";
		  sql += " m.empno 'mgrno',m.ename 'mename' ";
		  sql += " from t_emp e left join t_dept d ";
		  sql += " on e.deptno = d.deptno ";
		  sql += " left join t_emp m ";
		  sql += " on e.mgrno = m.empno "; 
		  sql += " limit ?,?";
		  
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
			//���ò���
			prep.setInt(1, (pageNo-1)*pageSize);
			prep.setInt(2, pageSize);
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
	    	   //����һ�����Ŷ���
	    	   Dept d = new Dept();
	    	   d.setDeptno(rs.getString("deptno"));
	    	   d.setDname(rs.getString("dname"));
	    	   d.setLocation(rs.getString("location"));
	    	   //���������ø�Ա��
	    	   emp.setDept(d);
	    	   //����һ����������(ʵ�ʻ���Ա��)
	    	   Emp mgr = new Emp();
	    	   mgr.setEmpno(rs.getString("mgrno"));
	    	   mgr.setEname(rs.getString("mename"));
	    	   //���������ø�Ա��
	    	   emp.setMgr(mgr);
	    	   //��emp�������ӵ�emps������
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
	
	//���t_emp���е��ܼ�¼��
	public int getCount() throws SQLException{
		 //sql
		 String sql = "select count(*)  from t_emp";
		 //�����������Ľӿ�
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //�������
		 try {
			conn = DBUtils.getConnection();
	     //���Ԥ�������
			prep = conn.prepareStatement(sql);
			//�������ݿ�
			rs = prep.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 DBUtils.closeAll(rs, prep, conn);
		}
	}
}