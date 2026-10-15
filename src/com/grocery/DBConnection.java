package com.grocery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/grocery_db";
		
		String username="root";
		
		String password="1234";
		
		Connection conn=DriverManager.getConnection(url,username,password);
		
		return conn;
		
		
	}

}
