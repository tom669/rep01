package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.bean.Dept;
import com.emp.util.DBUtils;

//操作 t_dept表
public class DeptDao {
    //查询所有部门记录
	public List<Dept> queryAll() throws SQLException{
		 //sql
		 String sql = "select * from t_dept";
		 List<Dept> depts = null;
		 //声明三个核心接口
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		 //获得连接对象
		  try {
			conn = DBUtils.getConnection();
		  //获得预编译对象
			prep = conn.prepareStatement(sql);
		  //发送预编译文件，操作数据库
		   rs = prep.executeQuery();
		   //遍历结果集，封装返回值集合
		   while(rs.next()){
			   if(depts==null){
				    //第一轮循环depts为null
				   //将depts实例化
				   depts = new ArrayList<Dept>();
			   }
			   //创建部门对象
			    Dept dept = new Dept();
			    //用rs中的数据填充dept对象
			    dept.setDeptno(rs.getString("deptno"));
			    dept.setDname(rs.getString("dname"));
			    dept.setLocation(rs.getString("location"));
			    //将dept对象放入返回值集合中
			    depts.add(dept);
		   }
		   //sql没有查询到数据,depts为null
		   return depts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			 //关闭资源
			 DBUtils.closeAll(rs, prep, conn);
		}
		  
	}
}
