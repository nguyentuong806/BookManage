package com.sys.dao;

import java.util.List;

import java.sql.*;
import java.sql.Statement;

import com.sys.models.User;
import com.sys.utils.SQLServerConnect;

public class UserDao implements Dao<User>{

	Connection con;
	Statement statement;
	public UserDao(){
		try{
			con = SQLServerConnect.getMyConnect();
			statement = con.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public boolean insert(User t) {
		return false;
	}

	@Override
	public boolean update(User t) {
//		String id  = Integer.toString(t.getId());
//		try{
//			String query = "UPADATE dbo.User "
//							+"SET Username = " +t.getUserName()
//							+"SET Password = " +t.getPassword()
//							+"WHERE UserID = "+id;
//			statement.executeQuery(query);
//			con.close();
//			return true;
//		}catch(SQLException sqlException){
//			sqlException.printStackTrace();
//			System.out.println("Error update!");
//		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

}
