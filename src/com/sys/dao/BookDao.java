package com.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sys.models.Book;
import com.sys.utils.SQLServerConnect;

public class BookDao implements Dao<Book> {

	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<Book>();
		Connection conn;
		Book book = null;
		try {
			conn = SQLServerConnect.getMyConnect();
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM dbo.Book";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setBookId(Integer.parseInt(rs.getString("book_id")));
				book.setBookTitle(rs.getNString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setBrief(rs.getString("brief"));
				book.setPublisher(rs.getNString("publisher"));
				book.setContent(rs.getNString("content"));
				book.setCategory(rs.getNString("category"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book get(int id) {
		Connection conn;
		Book book = null;
		try {
			conn = SQLServerConnect.getMyConnect();
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM dbo.Book WHERE book_id =" + id;
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				book = new Book();
				book.setBookId(Integer.parseInt(rs.getString("book_id")));
				book.setBookTitle(rs.getNString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setBrief(rs.getString("brief"));
				book.setPublisher(rs.getNString("publisher"));
				book.setContent(rs.getNString("content"));
				book.setCategory(rs.getNString("category"));
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
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}
}
