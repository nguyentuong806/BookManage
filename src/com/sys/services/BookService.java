package com.sys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sys.dao.BookDao;
import com.sys.models.Book;
import com.sys.utils.InputData;


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
		BookDao bookDao=new  BookDao();
		bookDao.insert(book);
	}
	
	public void viewListBook() {

	}

}
