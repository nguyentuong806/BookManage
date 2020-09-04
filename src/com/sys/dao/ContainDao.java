package com.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sys.models.BookCase;
import com.sys.models.Contain;
import com.sys.utils.SQLServerConnect;

public class ContainDao implements Dao<Contain>{

	@Override
	public List<Contain> getAll() {
		return null;
	}

	@Override
	public Contain get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Contain> getListByBookCaseId(int bookCaseId){
		List<Contain> contains = new ArrayList<Contain>();
		Connection conn;
		try {
			conn = SQLServerConnect.getMyConnect();
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM dbo.Contain WHERE book_case_id =" + bookCaseId;
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Contain contain = new Contain();
				contain.setBookCaseId(Integer.parseInt(rs.getString("book_case_id")));
				contain.setBookId(Integer.parseInt(rs.getString("book_id")));
				contain.setCreateDate(rs.getString("create_date"));
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
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dbo.Contain(book_case_id, book_id, create_date)"
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
		// TODO Auto-generated method stub
		return false;
	}

}
