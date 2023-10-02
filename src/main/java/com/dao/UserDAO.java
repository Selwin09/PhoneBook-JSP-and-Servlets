package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {
	private Connection connection;

	public UserDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean userRegister(User user)
	{
		boolean f=false;
		
		try {
			
			String sql="insert into user(name,email,password) values(?,?,?)";
			
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, user.getName());
			preparedstatement.setString(2, user.getEmail());
			preparedstatement.setString(3, user.getPassword());
			
			int i=preparedstatement.executeUpdate();
			if(i==1)
			{
				f=true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return f;
	}
	
	public User loginUser(String e,String p)
	{
		
		User user=null;
		
		try {
			String sql="select * from user where email=? and password=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1,e);
			preparedstatement.setString(2,p);
			
			ResultSet resultset=preparedstatement.executeQuery();

			while(resultset.next())
			{
				user=new User();
				user.setId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
				user.setPassword(resultset.getString(4));
			
			}
		} catch(Exception exception){
			exception.printStackTrace();
		}
		return user;
	}

}
