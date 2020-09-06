package com.sys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sys.models.BookCase;
import com.sys.utils.SQLServerConnect;

public class BookCaseDao implements Dao<BookCase>{
	Connection con;
	Statement statement;
	public BookCaseDao(){
		try{
			con = SQLServerConnect.getMyConnect();
			statement = con.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	

	@Override
	public List<BookCase> getAll() {
		return null;
	}

	@Override
	public BookCase get(int user_id) {
		BookCase bookCase = new BookCase();
		try {
			Connection conn = SQLServerConnect.getMyConnect();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM dbo.BookCase WHERE user_id = 2");
			while(rs.next()) {
				bookCase.setBookCaseId(Integer.parseInt(rs.getString("book_case_id")));
				bookCase.setBookCaseName(rs.getString("book_case_name"));
				bookCase.setUserId(Integer.parseInt(rs.getString("user_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookCase;
	}

	@Override
	public boolean insert(BookCase t) {
		return false;
	}

	@Override
	public boolean update(BookCase t) {
		String id  = Integer.toString(t.getBookCaseId());
		try{
			String query = "UPADATE dbo.BookCase "
							+"SET book_case_id = " +t.getBookCaseName()
							+"SET user_id = " +t.getUserId()
							+"WHERE book_case_id = "+id;
			statement.executeQuery(query);
			con.close();
			return true;
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
			System.out.println("Error update!");
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		String query  = "DELETE FROM dbo.BookCase WHERE book_case_id = "+id;
		try {
			statement.executeQuery(query);	
			con.close();			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error delete!");
		}
		return false;
	}

}
