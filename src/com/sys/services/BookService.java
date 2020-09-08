package com.sys.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sys.dao.BookDao;
import com.sys.models.Book;
import com.sys.utils.Constants;
import com.sys.utils.InputData;
import com.sys.utils.SQLServerConnect;

public class BookService {
	public void createBook(Scanner sc) {
		Book book = new Book();
		System.out.println("Enter the information.");
		book.setBookTitle(InputData.inputString("1. Enter the name: ", sc));
		book.setAuthor(InputData.inputString("2. Enter the author: ", sc));
		book.setPublisher(InputData.inputString("3. Enter the publisher", sc));
		book.setBrief(InputData.inputString("4. Enter the prief", sc));
		book.setCategory(InputData.inputString("5. Enter the category", sc));
		book.setContent(InputData.inputString("6. Enter the content", sc));
		BookDao bookDao = new BookDao();
		if (bookDao.insert(book)) {
			System.out.println("Book successfully created!");
		} else {
			System.out.println("Book fail created!");
		}
	}

	public void viewListBook() {
		BookDao bookDao = new BookDao();
		List<Book> books = new ArrayList<Book>();
		books = bookDao.getAll();
		System.out.printf("%-5s %-25s %-25s %-25s %-25s %-25s\n", "Id", "Title", "Author", "Brief", "Publisher", "Category");
		for (Book book : books) {
			System.out.printf("%-6s", book.getBookId());
			System.out.printf("%-26s", book.getBookTitle());
			System.out.printf("%-26s", book.getAuthor());
			System.out.printf("%-26s", book.getBrief());
			System.out.printf("%-26s", book.getPublisher());
			System.out.printf("%-26s", book.getCategory());
			System.out.println();
		}
	}

	
	public void readBook(Scanner sc) {
		BookDao bookDao = new BookDao();
		int id = InputData.inputInt("Please enter the book's id:", sc);
		if (bookDao.get(id).getBookId() == id) {
			System.out.println(bookDao.get(id).getBookTitle());
			System.out.println(bookDao.get(id).getContent());
		} else {
			System.out.println("This book is not exist!");
		}
	}

	public void removeBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter book's id :");

		int id = sc.nextInt();
		BookDao bookDao = new BookDao();
		if (bookDao.delete(id)) {
			System.out.println("Remove is successfully!");
		}
	}

	public void Search(Scanner sc) {
		String choice;
		BookDao bookDao = new BookDao();
		List<Book> books = new ArrayList<Book>();
		do {
			System.out.println("Please select search type : ");
			System.out.println("\t1.By name");
			System.out.println("\t2.By author");
			System.out.println("\t3.By category");
			System.out.println("\t4.Exit ");
			System.out.println("> choose:");
			choice = sc.nextLine();
			choice = choice.trim();
			switch (choice) {
			case Constants.SEARCH_BY_NAME:
				String name = InputData.inputString("Please enter book's name :", sc);
				books = bookDao.search(name);
				BookService.displayListBook(books);
				break;
			case Constants.SEARCH_BY_AUTHOR:
				String author = InputData.inputString("Please enter book's author :", sc);
				books = bookDao.search(author);
				BookService.displayListBook(books);
				break;
			case Constants.SEARCH_BY_CATEGORY:
				String category = InputData.inputString("Please enter book's category :", sc);
				books = bookDao.search(category);
				BookService.displayListBook(books);
				break;
			default:
				choice = Constants.LOGOUT;
				break;
			}
		} while (choice != Constants.LOGOUT);
	}

	public static void displayListBook(List<Book> books) {
		System.out.println("Has " + books.size() + " book");
		System.out.printf("%-5s %-25s %-25s %-25s %-25s \n", "Id", "Author", "Category", "Title", "Publisher");
		for (Book book : books) {
			System.out.printf("%-6s", book.getBookId());
			System.out.printf("%-26s", book.getBookTitle());
			System.out.printf("%-26s", book.getAuthor());
			System.out.printf("%-26s", book.getCategory());
			System.out.printf("%-26s", book.getPublisher());
			System.out.println();
		}
	}

	/**
	 * Update book by ID book
	 * @param id
	 */
	public static void updateBook(Scanner sc, int id) {
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
