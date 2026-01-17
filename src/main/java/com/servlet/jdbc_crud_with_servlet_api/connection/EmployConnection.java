package com.servlet.jdbc_crud_with_servlet_api.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class EmployConnection {
	public static Connection getEmployConnection() {
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-a12","root","Kaif@123");
			
		} catch (SQLException e) {
			System.out.println("Exception caught: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
