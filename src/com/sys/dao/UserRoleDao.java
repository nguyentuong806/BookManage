package com.sys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sys.models.UserRole;
import com.sys.utils.SQLServerConnect;

public class UserRoleDao implements Dao<UserRole>{

	@Override
	public List<UserRole> getAll() {
		List<UserRole> listUserRole = new ArrayList<>();
		Connection conn;
		try {
            String query = "SELECT * FROM dbo.[UserRole]";
            conn = SQLServerConnect.getMyConnect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                UserRole userRole = new UserRole(rs.getInt("UserID"), rs.getInt("RoleID"));
                listUserRole.add(userRole);
            }
            return listUserRole;
        } catch (Exception e) {
            System.out.println("Faild!");
        }
		return null;
	}

	@Override
	public UserRole get(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean insert(UserRole t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserRole t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
