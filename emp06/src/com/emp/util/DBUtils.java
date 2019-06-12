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
	
	//��̬������ͨ��DBUtils���ⲿ����
	//������Ӷ���
	public static Connection getConnection() throws SQLException{
	//����ֱ�Ӵ����ݿ��л������
	//���Ǵ����ӳ��л������
       return ds.getConnection();
	}
	
	//�ر���Դ
	public static void closeAll(ResultSet rs,PreparedStatement prep,
			  Connection conn) throws SQLException{
		      if(rs!=null){
		    	    rs.close();
		      }
		      
		      if(prep!=null){
		    	   prep.close();
		      }
		      
		      if(conn!=null){
		    	  //���������Ĺر�����
		    	  //���ǽ����ӷ��ظ����ӳ�
		    	   conn.close();
		      }
		      
	}
	
	public static void main(String[] args) throws SQLException {
		    Connection conn = getConnection();
		    System.out.println(conn);
	}
}
