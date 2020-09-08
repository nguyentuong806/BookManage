package com.sys.main;

import java.util.Scanner;

import com.sys.models.User;
import com.sys.services.BookService;
import com.sys.utils.Constants;
import com.sys.utils.InputData;

public class AdminController {
	public static void admin() {
		Scanner sc = new Scanner(System.in);
		BookService bookService = new BookService(); 
		String choice;
		
		do {
			System.out.println("Hello Admin, Please select a function bellow by entering the corresponding number.");
			System.out.println("1. Create Book");
			System.out.println("2. Delete Book");
			System.out.println("3. Edit Book");
			System.out.println("0. Logout");
			choice = sc.nextLine();
			choice = choice.trim();
			switch (choice) {
			case Constants.CREATE_BOOK:
				break;
			case Constants.DELETE_BOOK:
				break;
			case Constants.UPDATE_CONTENT_BOOK:
				bookService.updateBook(InputData.inputInt("Please enter book id:", sc));
				break;
			default:
				choice = Constants.LOGOUT;
				break;
			}
		} while (choice != Constants.LOGOUT);
		System.out.println("LOGOUT! CLOSED");
	}
}
