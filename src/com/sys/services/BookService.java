package com.sys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sys.dao.BookDao;
import com.sys.models.Book;

public class BookService {
	public Book createBook(Scanner sc) {
		Book book = new Book();
		return book;
	}
	
	public void viewListBook() {
		BookDao bookDao = new BookDao();                               
        List<Book> books = new ArrayList<Book>();
        books = bookDao.getAll();
        for(Book b : books) {
            System.out.print(b.getBookId() + "	");
            System.out.print(b.getBookTitle() + "	");
            System.out.print(b.getAuthor() + "	");
            System.out.print(b.getBrief() + "	");
            System.out.print(b.getPublisher() + "	");
            System.out.print(b.getContent() + "	");
            System.out.println(b.getCategory());
        }
	}

}
