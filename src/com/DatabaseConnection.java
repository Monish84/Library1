package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	Connection con;

	public Connection getConnection() {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			System.out.println("Connection is created...");
		
		
		return con;
	}
}
