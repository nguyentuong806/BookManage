package com.sys.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.sql.Statement;

import com.sys.models.User;
import com.sys.utils.SQLServerConnect;

public class UserDao implements Dao<User>{

	@Override
	public List<User> getAll() {
		List<User> listUser = new ArrayList<>();
		Connection conn;
        try {
            String query = "SELECT * FROM dbo.[User]";
            conn = SQLServerConnect.getMyConnect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                User user = new User( rs.getInt(1), rs.getString(2),rs.getString(3));
                listUser.add(user);
            }
            return listUser;
        } catch (Exception e) {
            System.out.println("Faild!");
        }
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
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

}
