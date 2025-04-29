package com.infobeans.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/employeedb";
	private static final String USER = "root";
	private static final String PASSWORD = "raghvendra";
	
	// Method to establish a connection
	
	public static  Connection getConnection() 
	{
		Connection connection=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(URL,USER,PASSWORD);
		}
		
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
		return connection;
	}
}
