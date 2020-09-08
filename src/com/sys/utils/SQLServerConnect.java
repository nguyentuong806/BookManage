package com.sys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnect {
	
	private SQLServerConnect() {
		
	}
	 private static Connection con = null; 
	  
	    static
	    { 
	    	String hostName = "localhost";
			String sqlInstanceName = "SQLSERVER";
			String database = "BookManagement";
			String userName = "sa";
			String password = "Password123@jkl#";
			String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName
					+ ";databaseName=" + database;
	        try { 
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            con = DriverManager.getConnection(connectionURL, userName, password); 
	        } 
	        catch (ClassNotFoundException | SQLException e) { 
	            e.printStackTrace(); 
	        } 
	    }
	
	public static Connection getMyConnect() throws SQLException {
		if(con!=null) {
			return con;
		}
		return null;
	}
}
