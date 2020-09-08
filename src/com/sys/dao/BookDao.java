package com.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

import com.sys.models.Book;
import com.sys.utils.SQLServerConnect;

public class BookDao implements Dao<Book> {
	Connection conn;
	Statement statement;
	
	public BookDao() {
		try {
			conn = SQLServerConnect.getMyConnect();
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<Book>();
//		Connection conn;
		Book book = null;
		try {
//			conn = SQLServerConnect.getMyConnect();
//			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM dbo.[Book]";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setBookId(Integer.parseInt(rs.getString("BookID")));
				book.setBookTitle(rs.getNString("BookTitle"));
				book.setAuthor(rs.getString("Author"));
				book.setBrief(rs.getString("Brief"));
				book.setPublisher(rs.getNString("Publisher"));
				book.setContent(rs.getNString("Content"));
				book.setCategory(rs.getNString("Category"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book get(int id) {
//		Connection conn;
		Book book = null;
		try {
//			conn = SQLServerConnect.getMyConnect();
//			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM dbo.[Book] WHERE BookID =" + id;
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setBookId(Integer.parseInt(rs.getString("BookID")));
				book.setBookTitle(rs.getNString("BookTitle"));
				book.setAuthor(rs.getString("Author"));
				book.setBrief(rs.getString("Brief"));
				book.setPublisher(rs.getNString("Publisher"));
				book.setContent(rs.getNString("Content"));
				book.setCategory(rs.getNString("Category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public boolean insert(Book t) {
		Connection conn;
		try {
			conn = SQLServerConnect.getMyConnect();
			String sql = "INSERT INTO Book VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getBookTitle());
			ps.setString(2, t.getAuthor());
			ps.setString(3, t.getBrief());
			ps.setString(4, t.getPublisher());
			ps.setString(5, t.getContent());
			ps.setString(6, t.getCategory());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

	@Override
	public boolean update(Book t) {
		Connection conn;
		int book_id = t.getBookId();
		try {
			conn = SQLServerConnect.getMyConnect();
			Statement statement = conn.createStatement();
			String query = "UPADATE dbo.[Book] "
							+"SET BookTitle = " +t.getBookTitle()
							+"SET Author = " +t.getAuthor()
							+"SET Brief = " +t.getBrief()
							+"SET Publisher = " +t.getPublisher()
							+"SET Content = " +t.getContent()
							+"SET Category = " +t.getCategory()
							+"WHERE BookID = "+book_id;
			statement.executeQuery(query);				
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error update!");
		}
		return false;

	}

	@Override
	public boolean delete(int id) {
		String query  = "DELETE FROM dbo.[Book] WHERE BookID = "+id;
		Connection conn;
		try {
			conn = SQLServerConnect.getMyConnect();
			Statement statement = conn.createStatement();
			statement.executeQuery(query);				
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error delete!");
		}
		return false;
	}
}
