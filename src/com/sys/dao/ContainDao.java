package com.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sys.main.MainController;
import com.sys.models.BookCase;
import com.sys.models.Contain;
import com.sys.services.BookCaseService;
import com.sys.utils.SQLServerConnect;

public class ContainDao implements Dao<Contain>{
	
	Connection conn;
	Statement statement;
	
	public ContainDao() {
		try {
			conn = SQLServerConnect.getMyConnect();
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Contain> getAll() {
		return null;
	}

	@Override
	public Contain get(int id) {
		return null;
	}
	
	public List<Contain> getListByBookCaseId(int bookCaseId){
		List<Contain> contains = new ArrayList<Contain>();
		Connection conn;
		try {
			conn = SQLServerConnect.getMyConnect();
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM dbo.[Contain] WHERE BookCaseID =" + bookCaseId;
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Contain contain = new Contain();
				contain.setBookCaseId(Integer.parseInt(rs.getString("BookCaseID")));
				contain.setBookId(Integer.parseInt(rs.getString("BookID")));
				contain.setCreateDate(rs.getString("CreateDate"));
				contains.add(contain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contains;
	}

	@Override
	public boolean insert(Contain t) {
		Connection conn;
		try {
			conn = SQLServerConnect.getMyConnect();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dbo.[Contain](BookCaseID, BookID, CreateDate)"
					+ "VALUES (?, ?, ?)");
			ps.setString(1, String.valueOf(t.getBookCaseId()));
			ps.setString(2, String.valueOf(t.getBookId()));
			ps.setString(3, t.getCreateDate());
			int rs = ps.executeUpdate();
			if (rs == 1) return true;
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
		return false;
	}

	@Override
	public boolean update(Contain t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		BookCaseService bookCaseService = new BookCaseService();
		int bookCaseId = bookCaseService.getBookCaseId(MainController.user);
		String sql = "DELETE FROM dbo.[Contain] WHERE BookCaseID =" + bookCaseId + "AND BookID =" + id;
		try {
			int rs = statement.executeUpdate(sql);
			if (rs == 1) return true;
		} catch (SQLException e) {
			System.out.println("Delete Faild!");
		}
		return false;
	}

	public boolean deleteAll() {
		BookCaseService bookCaseService = new BookCaseService();
		int bookCaseId = bookCaseService.getBookCaseId(MainController.user);
		String sql = "DELETE FROM dbo.[Contain] WHERE BookCaseID =" + bookCaseId;
		try {
			int rs = statement.executeUpdate(sql);
			if (rs == 1) return true;
		} catch (SQLException e) {
			System.out.println("Delete All Faild!");
		}
		return false;
	}
}
