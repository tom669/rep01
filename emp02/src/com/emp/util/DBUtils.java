package com.emp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {  
    //四个重要参数
	public static final String DRIVER = "com.mysql.jdbc.Driver";//驱动字符串
	public static final String URL="jdbc:mysql://localhost:3306/empdb";//连接字符串
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	//类加载的时候会将静态块执行一次,后续都不执行
	//就是将DBUtils.class 放入虚拟机内存对应区域解读
	static{
		  //注册驱动
		  try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//静态方法，通过DBUtils类外部调用
	//获得连接对象
	public static Connection getConnection() throws SQLException{
		/*
		Connection conn = 
		      DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;*/
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	//关闭资源
	public static void closeAll(ResultSet rs,PreparedStatement prep,
			  Connection conn) throws SQLException{
		      if(rs!=null){
		    	    rs.close();
		      }
		      
		      if(prep!=null){
		    	   prep.close();
		      }
		      
		      if(conn!=null){
		    	   conn.close();
		      }
		      
	}
	
	public static void main(String[] args) throws SQLException {
		    Connection conn = getConnection();
		    System.out.println(conn);
	}
}
