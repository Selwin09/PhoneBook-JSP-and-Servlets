package com.connection;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DatabaseMetaData;
//import java.sql.SQLException;

public class DbConnect {
	private static Connection connection;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","12345678");
			
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return connection;
	}

}
