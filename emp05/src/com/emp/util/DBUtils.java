package com.emp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {  
	 private static ComboPooledDataSource ds 
	    = new ComboPooledDataSource("mysql"); 
	
	//静态方法，通过DBUtils类外部调用
	//获得连接对象
	public static Connection getConnection() throws SQLException{
	//不是直接从数据库中获得连接
	//而是从连接池中获得连接
       return ds.getConnection();
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
		    	  //不是真正的关闭连接
		    	  //而是将连接返回给连接池
		    	   conn.close();
		      }
		      
	}
	
	public static void main(String[] args) throws SQLException {
		    Connection conn = getConnection();
		    System.out.println(conn);
	}
}
