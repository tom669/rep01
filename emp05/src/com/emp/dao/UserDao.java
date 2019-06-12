package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.bean.User;
import com.emp.util.DBUtils;

//��������дdao
public class UserDao {
	 //�����û����������ѯ�û�����
	 public User  findUser(String username,String password) throws SQLException{
		     //sql
		    String sql = "select * from t_user where user_name=? and user_pass=?";
		    User user = null;
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
				prep.setString(1, username);
				prep.setString(2, password);
			  //����Ԥ�����ļ�,�������ݿ�
				rs = prep.executeQuery();
				while(rs.next()){
					//ʵ����user
					 user = new User();
					 //��rs�е��������user����
					 user.setUser_id(rs.getString("user_id"));
					 user.setUser_name(rs.getString("user_name"));
					 user.setUser_pass(rs.getString("user_pass"));
				}
				//��ѯû������,userΪnull
				return user;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}finally{
				 //�ر���Դ
				 DBUtils.closeAll(rs, prep, conn);
			}
		     
		    
	 }
	
	 //ע��
	 //��User���󱣴浽���ݿ���
	 public void saveUser(User user) throws SQLException{
		  //sql
		 String sql = "insert into t_user values(?,?,?)";
		 //�����������Ľӿ�
		 Connection conn = null;
		 PreparedStatement prep = null;
		 
		 //������Ӷ���
		  try {
			conn = DBUtils.getConnection();
		  //���Ԥ�������
			prep = conn.prepareStatement(sql);
			//���ò���
			prep.setString(1, user.getUser_id());
			prep.setString(2, user.getUser_name());
			prep.setString(3, user.getUser_pass());
			//����Ԥ�����ļ����������ݿ�
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			 //�ر���Դ
			 DBUtils.closeAll(null, prep, conn);
		}
	 }
	
	
     //��¼
	 //�����û���������,�鿴�û��Ƿ����
	 public int queryUser(String username,String password) throws SQLException{ 
		  //sql
		  //��ѯ���� 1 �û�����-->��¼�ɹ�
		  //��ѯ���� 0 �û�������-->�û������������
		  String sql = "select count(*)  from t_user where user_name=? and user_pass=?";
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
			prep.setString(1, username);
			prep.setString(2, password);
		  //����Ԥ�����ļ����������ݿ�
		  //���ؽ����
		   rs = prep.executeQuery();
		   rs.next();
		   return rs.getInt(1);// 0 1

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
