package com.sys.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sys.models.Book;
import com.sys.utils.Constants;

public class UserService {
	
	/**
	 * Check user login & authority 
	 * @param userName
	 * @param password
	 * @return
	 */
//	public int checkUserLogin(String userName, String password) {
		
//		
//		String query = "SELECT * FROM Users";
//		String sql = "SELECT * FROM dbo.[Book]";
//		conn = SQLServerConnect.getMyConnect();
//		Statement statement = conn.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		while (rs.next()) {
//			book = new Book();
//			book.setBookId(Integer.parseInt(rs.getString("BookID")));
//			book.setBookTitle(rs.getNString("BookTitle"));
//			book.setAuthor(rs.getString("Author"));
//			book.setBrief(rs.getString("Brief"));
//			book.setPublisher(rs.getNString("Publisher"));
//			book.setContent(rs.getNString("Content"));
//			book.setCategory(rs.getNString("Category"));
//			books.add(book);
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return books;
//		
//		return Constants.ADMIN_AUTHORITY;
//	}
}
