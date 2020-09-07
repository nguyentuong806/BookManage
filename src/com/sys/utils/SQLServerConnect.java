package com.sys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnect {
	
	public static Connection getMyConnect() throws SQLException {
		String hostName = "localhost";
		String sqlInstanceName = "SQLSERVER";
		String database = "BookManagement";
		String userName = "sa";
		String password = "Password123@jkl#";
		return getMyConnect(hostName, sqlInstanceName, database, userName, password);
	}

	private static Connection getMyConnect(String hostName, String sqlInstanceName, String database, String userName,
			String password) {

		String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName
				+ ";databaseName=" + database;

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (SQLException e) {
			System.out.println("Connection faild!");
			return null;
		}
		return conn;
	}
}
