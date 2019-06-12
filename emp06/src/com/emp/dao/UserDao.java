package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.bean.User;
import com.emp.util.DBUtils;

//依据需求写dao
public class UserDao {
	 //依据用户名和密码查询用户对象
	 public User  findUser(String username,String password) throws SQLException{
		     //sql
		    String sql = "select * from t_user where user_name=? and user_pass=?";
		    User user = null;
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
				prep.setString(1, username);
				prep.setString(2, password);
			  //发送预编译文件,操作数据库
				rs = prep.executeQuery();
				while(rs.next()){
					//实例化user
					 user = new User();
					 //用rs中的数据填充user对象
					 user.setUser_id(rs.getString("user_id"));
					 user.setUser_name(rs.getString("user_name"));
					 user.setUser_pass(rs.getString("user_pass"));
				}
				//查询没有数据,user为null
				return user;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}finally{
				 //关闭资源
				 DBUtils.closeAll(rs, prep, conn);
			}
		     
		    
	 }
	
	 //注册
	 //将User对象保存到数据库中
	 public void saveUser(User user) throws SQLException{
		  //sql
		 String sql = "insert into t_user values(?,?,?)";
		 //声明两个核心接口
		 Connection conn = null;
		 PreparedStatement prep = null;
		 
		 //获得连接对象
		  try {
			conn = DBUtils.getConnection();
		  //获得预编译对象
			prep = conn.prepareStatement(sql);
			//设置参数
			prep.setString(1, user.getUser_id());
			prep.setString(2, user.getUser_name());
			prep.setString(3, user.getUser_pass());
			//发送预编译文件，操作数据库
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			 //关闭资源
			 DBUtils.closeAll(null, prep, conn);
		}
	 }
	
	
     //登录
	 //输入用户名和密码,查看用户是否存在
	 public int queryUser(String username,String password) throws SQLException{ 
		  //sql
		  //查询返回 1 用户存在-->登录成功
		  //查询返回 0 用户不存在-->用户名或密码错误
		  String sql = "select count(*)  from t_user where user_name=? and user_pass=?";
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
			prep.setString(1, username);
			prep.setString(2, password);
		  //发送预编译文件，操作数据库
		  //返回结果集
		   rs = prep.executeQuery();
		   rs.next();
		   return rs.getInt(1);// 0 1

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
