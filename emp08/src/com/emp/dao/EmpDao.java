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
	 //查询所有的经理
	 public List<Emp> queryMgr() throws SQLException{
		   //sql	
		 String sql = " select * from t_emp  ";
		 sql += " where empno in( ";
		 sql += " select distinct mgrno from t_emp ) ";
		 //以下代码和queryAll()方法100%相同		 
		 List<Emp> emps = null;
		 //声明三个核心接口
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //获得连接对象
		   try {
			conn = DBUtils.getConnection();
	     //获得预编译对象
			prep = conn.prepareStatement(sql);
	      //发送预编译文件,操作数据库
		 //返回结果集对象
	      rs = prep.executeQuery();
	      while(rs.next()){
	    	   if(emps==null){
	    		    //第一轮循环,emps一定为null
	    		    //将emps实例化
	    		    emps = new ArrayList<Emp>();
	    	   }
	    	   //创建一个员工对象
	    	   Emp emp = new Emp();
	    	   //用rs中数据填充emp对象
	    	   emp.setEmpno(rs.getString("empno"));
	    	   emp.setEname(rs.getString("ename"));
	    	   emp.setEsex(rs.getString("esex"));
	    	   emp.setEage(rs.getInt("eage"));
	    	   emp.setEsalary(rs.getFloat("esalary"));
	    	   //将emp对象添加到emps集合中
	    	   emps.add(emp);
	      }
	      //没有查询到数据emps为null
	      return emps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			  //关闭资源
			  DBUtils.closeAll(rs, prep, conn);
		}
	 }
	 //查询所有经理的员工编号
	 public List<String> queryMgrno() throws SQLException{
		   //sql
		   String sql = "select distinct mgrno from t_emp";
		   List<String> list = null;
		   //声明三个核心接口
		   Connection conn = null;
		   PreparedStatement prep = null;
		   ResultSet rs = null;
		   
		   //获得连接
		   try {
			conn = DBUtils.getConnection();
			//获得预编译对象
			prep = conn.prepareStatement(sql);
			//发送预编译文件，操作数据库
			rs = prep.executeQuery();
			//遍历结果集，封装返回值
			while(rs.next()){
				  if(list==null){
					   //第一轮循环,list一定为null
					   //实例化list
					   list = new ArrayList<String>();
				  }
				  //将rs中的数据取出，填充list
				  list.add(rs.getString("mgrno"));
			}
			//没有查询到数据list为null
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //关闭资源
			 DBUtils.closeAll(rs, prep, conn);
		}
		   
	 }
	
	 //依据员工编号，修改员工信息
	 public void update(Emp emp) throws SQLException{
		    //sql
		    //依据主键修改一条记录
		    //除开主键以外的所有字段，都可以修改
		   String sql = " update t_emp set ename=?,esex=?,eage=?,esalary=?,deptno=?,mgrno=? "
		   		+ " where empno=? ";
		   //声明两个核心接口
		    Connection conn = null;
		    PreparedStatement prep = null;
		    
		    //获得连接对象
		    try {
				conn = DBUtils.getConnection();
		     //获得预编译对象
				prep = conn.prepareStatement(sql);
				//设置参数
				prep.setString(1, emp.getEname());
				prep.setString(2, emp.getEsex());
				prep.setInt(3, emp.getEage());
				prep.setFloat(4, emp.getEsalary());
				prep.setString(5, emp.getDept().getDeptno());
				prep.setString(6, emp.getMgr().getEmpno());
				prep.setString(7, emp.getEmpno());
				//发送预编译文件，操作数据库
				prep.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}finally{
				 //关闭资源
				 DBUtils.closeAll(null, prep, conn);
			}
		   
	 }
	
	//依据员工编号查询一个员工记录
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
		 //声明返回值
		 Emp emp = null;
		 //声明三个核心接口
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //获得连接对象
		   try {
			conn = DBUtils.getConnection();
	     //获得预编译对象
			prep = conn.prepareStatement(sql);
			//设置参数
			prep.setString(1, empno);
	      //发送预编译文件,操作数据库
		 //返回结果集对象
	      rs = prep.executeQuery();
	      while(rs.next()){
	    	   //创建一个员工对象
	           emp = new Emp();
	    	   //用rs中数据填充emp对象
	    	   emp.setEmpno(rs.getString("empno"));
	    	   emp.setEname(rs.getString("ename"));
	    	   emp.setEsex(rs.getString("esex"));
	    	   emp.setEage(rs.getInt("eage"));
	    	   emp.setEsalary(rs.getFloat("esalary"));
	    	   //创建一个部门对象
	    	   Dept d = new Dept();
	    	   d.setDeptno(rs.getString("deptno"));
	    	   d.setDname(rs.getString("dname"));
	    	   d.setLocation(rs.getString("location"));
	    	   //将部门设置给员工
	    	   emp.setDept(d);
	    	   //创建一个经理对象(实质还是员工)
	    	   Emp mgr = new Emp();
	    	   mgr.setEmpno(rs.getString("mgrno"));
	    	   mgr.setEname(rs.getString("mename"));
	    	   //将经理设置给员工
	    	   emp.setMgr(mgr);
	      }
	      //没有查询到数据emp为null
	      return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			  //关闭资源
			  DBUtils.closeAll(rs, prep, conn);
		}
		 
	}
	
	//删除一条记录
	public void delete(String empno) throws SQLException{
		  //sql
		  String sql = "delete from t_emp where empno=?";
		  //声明两个核心接口
		  Connection conn = null;
		  PreparedStatement prep = null;
		  
		  //获得连接对象
		  try {
			conn = DBUtils.getConnection();
			//获得预编译对象
			prep = conn.prepareStatement(sql);
			//设置参数
			prep.setString(1, empno);
			//发送预编译文件，操作数据库
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //关闭资源
			 DBUtils.closeAll(null, prep, conn);
		}
		  
	}
	
	//保存一条记录

	public void save(Emp emp) throws SQLException{
		//sql
		String sql = "insert into t_emp values (?,?,?,?,?,?,?)";
		//声明两个核心接口
		Connection conn = null;
		PreparedStatement prep = null;
		
		//获得连接对象
		  try {
			conn = DBUtils.getConnection();
	     //获得预编译对象
			prep = conn.prepareStatement(sql);
		  //设置参数
			prep.setString(1, emp.getEmpno());
			prep.setString(2, emp.getEname());
			prep.setString(3, emp.getEsex());
			prep.setInt(4, emp.getEage());
			prep.setFloat(5, emp.getEsalary());
			prep.setString(6, emp.getDept().getDeptno());
			prep.setString(7, emp.getMgr().getEmpno());
		  //发送预编译文件，操作数据库
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //关闭资源
			 DBUtils.closeAll(null, prep, conn);
		}
	}
	
	
    //查询所有的记录
	public List<Emp> queryAll() throws SQLException{
		 //sql	
		 String sql = " select e.empno ,e.ename ,e.esex,e.eage,e.esalary, ";
		  sql += " d.deptno,d.dname,d.location, ";
		  sql += " m.empno 'mgrno',m.ename 'mename' ";
		  sql += " from t_emp e left join t_dept d ";
		  sql += " on e.deptno = d.deptno ";
		  sql += " left join t_emp m ";
		  sql += " on e.mgrno = m.empno ";
		 //声明返回值
		 List<Emp> emps = null;
		 //声明三个核心接口
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //获得连接对象
		   try {
			conn = DBUtils.getConnection();
	     //获得预编译对象
			prep = conn.prepareStatement(sql);
	      //发送预编译文件,操作数据库
		 //返回结果集对象
	      rs = prep.executeQuery();
	      while(rs.next()){
	    	   if(emps==null){
	    		    //第一轮循环,emps一定为null
	    		    //将emps实例化
	    		    emps = new ArrayList<Emp>();
	    	   }
	    	   //创建一个员工对象
	    	   Emp emp = new Emp();
	    	   //用rs中数据填充emp对象
	    	   emp.setEmpno(rs.getString("empno"));
	    	   emp.setEname(rs.getString("ename"));
	    	   emp.setEsex(rs.getString("esex"));
	    	   emp.setEage(rs.getInt("eage"));
	    	   emp.setEsalary(rs.getFloat("esalary"));
	    	   //创建一个部门对象
	    	   Dept d = new Dept();
	    	   d.setDeptno(rs.getString("deptno"));
	    	   d.setDname(rs.getString("dname"));
	    	   d.setLocation(rs.getString("location"));
	    	   //将部门设置给员工
	    	   emp.setDept(d);
	    	   //创建一个经理对象(实质还是员工)
	    	   Emp mgr = new Emp();
	    	   mgr.setEmpno(rs.getString("mgrno"));
	    	   mgr.setEname(rs.getString("mename"));
	    	   //将经理设置给员工
	    	   emp.setMgr(mgr);
	    	   //将emp对象添加到emps集合中
	    	   emps.add(emp);
	      }
	      //没有查询到数据emps为null
	      return emps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			  //关闭资源
			  DBUtils.closeAll(rs, prep, conn);
		}
		 
	}
	
	
	//无条件分页查询
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
		  
		 //声明返回值
		 List<Emp> emps = null;
		 //声明三个核心接口
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //获得连接对象
		   try {
			conn = DBUtils.getConnection();
	     //获得预编译对象
			prep = conn.prepareStatement(sql);
			//设置参数
			prep.setInt(1, (pageNo-1)*pageSize);
			prep.setInt(2, pageSize);
	      //发送预编译文件,操作数据库
		 //返回结果集对象
	      rs = prep.executeQuery();
	      while(rs.next()){
	    	   if(emps==null){
	    		    //第一轮循环,emps一定为null
	    		    //将emps实例化
	    		    emps = new ArrayList<Emp>();
	    	   }
	    	   //创建一个员工对象
	    	   Emp emp = new Emp();
	    	   //用rs中数据填充emp对象
	    	   emp.setEmpno(rs.getString("empno"));
	    	   emp.setEname(rs.getString("ename"));
	    	   emp.setEsex(rs.getString("esex"));
	    	   emp.setEage(rs.getInt("eage"));
	    	   emp.setEsalary(rs.getFloat("esalary"));
	    	   //创建一个部门对象
	    	   Dept d = new Dept();
	    	   d.setDeptno(rs.getString("deptno"));
	    	   d.setDname(rs.getString("dname"));
	    	   d.setLocation(rs.getString("location"));
	    	   //将部门设置给员工
	    	   emp.setDept(d);
	    	   //创建一个经理对象(实质还是员工)
	    	   Emp mgr = new Emp();
	    	   mgr.setEmpno(rs.getString("mgrno"));
	    	   mgr.setEname(rs.getString("mename"));
	    	   //将经理设置给员工
	    	   emp.setMgr(mgr);
	    	   //将emp对象添加到emps集合中
	    	   emps.add(emp);
	      }
	      //没有查询到数据emps为null
	      return emps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			  //关闭资源
			  DBUtils.closeAll(rs, prep, conn);
		}
		 
	}
	
	
	//无条件分页查询
		public List<Emp> queryPage(int pageNo,int pageSize,String condition) throws SQLException{
			 //创建参数集合
			  List params = new ArrayList();
			//sql	
			 String sql = " select e.empno ,e.ename ,e.esex,e.eage,e.esalary, ";
			  sql += " d.deptno,d.dname,d.location, ";
			  sql += " m.empno 'mgrno',m.ename 'mename' ";
			  sql += " from t_emp e left join t_dept d ";
			  sql += " on e.deptno = d.deptno ";
			  sql += " left join t_emp m ";
			  sql += " on e.mgrno = m.empno "; 
			  //condition不为null或者""才能拼接
			  if(condition!=null  && !"".equals(condition.trim()) ){
			      sql += " where e.ename like ?";
			      params.add("%"+condition+"%");
			  }
			  
			  
			  sql += " limit ?,?";
			  params.add((pageNo-1)*pageSize);
			  params.add(pageSize);
			  
			 //声明返回值
			 List<Emp> emps = null;
			 //声明三个核心接口
			 Connection conn = null;
			 PreparedStatement prep = null;
			 ResultSet rs = null;
			 
			 //获得连接对象
			   try {
				conn = DBUtils.getConnection();
		     //获得预编译对象
				prep = conn.prepareStatement(sql);
				//设置参数,遍历参数集合params
				for (int i = 0; i < params.size(); i++) {
					  prep.setObject(i+1, params.get(i));
				}
			    
		      //发送预编译文件,操作数据库
			 //返回结果集对象
		      rs = prep.executeQuery();
		      while(rs.next()){
		    	   if(emps==null){
		    		    //第一轮循环,emps一定为null
		    		    //将emps实例化
		    		    emps = new ArrayList<Emp>();
		    	   }
		    	   //创建一个员工对象
		    	   Emp emp = new Emp();
		    	   //用rs中数据填充emp对象
		    	   emp.setEmpno(rs.getString("empno"));
		    	   emp.setEname(rs.getString("ename"));
		    	   emp.setEsex(rs.getString("esex"));
		    	   emp.setEage(rs.getInt("eage"));
		    	   emp.setEsalary(rs.getFloat("esalary"));
		    	   //创建一个部门对象
		    	   Dept d = new Dept();
		    	   d.setDeptno(rs.getString("deptno"));
		    	   d.setDname(rs.getString("dname"));
		    	   d.setLocation(rs.getString("location"));
		    	   //将部门设置给员工
		    	   emp.setDept(d);
		    	   //创建一个经理对象(实质还是员工)
		    	   Emp mgr = new Emp();
		    	   mgr.setEmpno(rs.getString("mgrno"));
		    	   mgr.setEname(rs.getString("mename"));
		    	   //将经理设置给员工
		    	   emp.setMgr(mgr);
		    	   //将emp对象添加到emps集合中
		    	   emps.add(emp);
		      }
		      //没有查询到数据emps为null
		      return emps;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}finally{
				  //关闭资源
				  DBUtils.closeAll(rs, prep, conn);
			}
			 
		}
	
	//获得t_emp表中的总记录数
	public int getCount() throws SQLException{
		 //sql
		 String sql = "select count(*)  from t_emp";
		 //声明三个核心接口
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //获得连接
		 try {
			conn = DBUtils.getConnection();
	     //获得预编译对象
			prep = conn.prepareStatement(sql);
			//操作数据库
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
	
	//依据条件condition,可以查询出多少条记录
		public int getCount(String condition) throws SQLException{
			 //sql
			 String sql = "select count(*)  from t_emp where ename like ?";
			 //声明三个核心接口
			 Connection conn = null;
			 PreparedStatement prep = null;
			 ResultSet rs = null;
			 
			 //获得连接
			 try {
				conn = DBUtils.getConnection();
		     //获得预编译对象
				prep = conn.prepareStatement(sql);
				//设置参数
				prep.setString(1, "%"+condition+"%");
				//操作数据库
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
