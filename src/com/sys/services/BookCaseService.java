package com.sys.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.sys.dao.BookCaseDao;
import com.sys.dao.BookDao;
import com.sys.dao.ContainDao;
import com.sys.main.MainController;
import com.sys.models.Book;
import com.sys.models.BookCase;
import com.sys.models.Contain;
import com.sys.models.User;
import com.sys.utils.InputData;
import com.sys.utils.Utils;

public class BookCaseService {
	BookCaseDao bookCaseDao = new BookCaseDao();
	ContainDao containDao = new ContainDao();
	/**
	 * Get book case id user
	 * @param user
	 * @return
	 */
	public static int getBookCaseId(User user) {
		BookCaseDao bookCaseDao = new BookCaseDao();
		BookCase bookCase = bookCaseDao.get(user.getId());
		int bookCaseId = bookCase.getBookCaseId();
		return bookCaseId;
	}
	
	/**
	 * View book case
	 * @param user_id
	 */
	public void viewBookCase() {
		List<Contain> contains = new ArrayList<Contain>();
		ContainDao containDao = new ContainDao();
		int book_case_id = BookCaseService.getBookCaseId(MainController.user);
		contains = containDao.getListByBookCaseId(book_case_id);
		
		BookDao bookDao = new BookDao();
		List<Book> books = new ArrayList<Book>();
		for (Contain contain : contains) {
			int book_id = contain.getBookId();
			Book book = bookDao.get(book_id);
			books.add(book);
		}
		BookCaseService.displayBookCase(books);
	}
	
	/**
	 * Add a new book to book case
	 * @param sc
	 */
	public void addNewBook(Scanner sc) {
		ContainDao containDao = new ContainDao();
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.getAll();
		System.out.println("Total " + books.size() + " book");
		System.out.println("Id	Title	Author	Category	Publisher");
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			System.out.println(book.getBookId() + "	"
					+ book.getBookTitle() + "	"
					+ book.getAuthor() + "	"
					+ book.getCategory() + "	"
					+ book.getPublisher());
		}
		
		int bookId;
		while (true) {
			bookId = InputData.inputInt("Please enter the id:", sc);
			Book book = bookDao.get(bookId);
			if (book != null) {
				break;
			} else {
				System.out.println("Book not exist in database.");
			}
		}
		String createDate = Utils.formatDate(Calendar.getInstance().getTime(), "YYYY-MM-dd");
		int bookCaseId = BookCaseService.getBookCaseId(MainController.user);
		Contain contain = new Contain();
		contain.setBookCaseId(bookCaseId);
		contain.setBookId(bookId);
		contain.setCreateDate(createDate);
		if (containDao.insert(contain)) {
			System.out.println("Add Successfully!");
		} else {
		}
		
	}
	
	/**
	 * Remove a book from book case
	 * @param sc
	 */
	public void removeBook(Scanner sc) {
		int bookId = Integer.parseInt(InputData.inputString("Enter book id to remove:", sc));
		if (containDao.delete(bookId)) {
			System.out.println("Remove is successfully!");
		}
	}
	
	/**
	 * Remove all book case
	 */
	public void clearBookCase() {
		if (containDao.deleteAll()) {
			System.out.println("Clear successfully!\nYour BookCase is empty");
		}
	}
	
	
	/**
	 * Display list books in book case
	 * @param books
	 */
	public static void displayBookCase(List<Book> books) {
		System.out.println("Your BookCase has " + books.size() + " book");
		System.out.println("Stt	Id	Name	Author	Category	Title	Publisher");
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			System.out.println((i+1) + "	"
					+ book.getBookId() + "	"
					+ book.getBookTitle() + "	"
					+ book.getAuthor() + "	"
					+ book.getCategory() + "	"
					+ book.getBookTitle() + "	"
					+ book.getPublisher());
		}
	}

}
