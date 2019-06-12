package com.emp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {  
    //�ĸ���Ҫ����
	public static final String DRIVER = "com.mysql.jdbc.Driver";//�����ַ���
	public static final String URL="jdbc:mysql://localhost:3306/empdb";//�����ַ���
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	//����ص�ʱ��Ὣ��̬��ִ��һ��,��������ִ��
	//���ǽ�DBUtils.class ����������ڴ��Ӧ������
	static{
		  //ע������
		  try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//��̬������ͨ��DBUtils���ⲿ����
	//������Ӷ���
	public static Connection getConnection() throws SQLException{
		/*
		Connection conn = 
		      DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;*/
		return DriverManager.getConnection(URL, USER, PASSWORD);
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
		    	   conn.close();
		      }
		      
	}
	
	public static void main(String[] args) throws SQLException {
		    Connection conn = getConnection();
		    System.out.println(conn);
	}
}
