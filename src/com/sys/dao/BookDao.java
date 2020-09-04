package com.sys.dao;

import java.sql.Connection;
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
			while(rs.next()) {
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
			while(rs.next()) {
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
		return false;
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
