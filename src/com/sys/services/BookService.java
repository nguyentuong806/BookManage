package com.sys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sys.dao.BookDao;
import com.sys.models.Book;
import com.sys.utils.InputData;

public class BookService {
	static Scanner sc = new Scanner(System.in);
	public Book createBook(Scanner sc) {
		Book book = new Book();
		return book;
	}
	
	public void viewListBook() {

	}
	/**
	 * Update book by ID book
	 * @param id
	 */
	public static void updateBook(int id) {
		BookDao bookDao =  new BookDao();
		Book book = bookDao.get(id);
		String contentBook;
		while (true) {
			if (book != null) {
				contentBook = InputData.inputString("Please enter new book's content:", sc);
				break;
			} else {
				System.out.println("Book not exist in database.");
				return;
			}
		}
		book.setContent(contentBook);
		if(bookDao.update(book)){
			System.out.println("book successfully updated!");
			return;
		}
			System.out.println("Failed!");
	}

}
