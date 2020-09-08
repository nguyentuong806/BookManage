package com.sys.main;

import java.util.Scanner;

import com.sys.models.User;
import com.sys.services.BookCaseService;
import com.sys.services.BookService;
import com.sys.utils.Constants;

public class UserController {
	public static void user() {
		BookCaseService bookCaseService = new BookCaseService();
		BookService bookService = new BookService();
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			System.out.println("Hello User, Please select a function bellow by entering the corresponding number.");
			System.out.println("1. View List Books");
			System.out.println("2. Search Books");
			System.out.println("3. Read Book");
			System.out.println("4. View Your BookCase");
			System.out.println("5. Edit Your BookCase");
			System.out.println("0. Logout");
			choice = sc.nextLine();
			choice = choice.trim();
			switch (choice) {
			case Constants.VIEW_LIST_BOOK:
				bookService.viewListBook();
				break;
			case Constants.SEARCH_BOOK:
				break;
			case Constants.READ_BOOK:
				break;
			case Constants.VIEW_YOUR_BOOKCASE:
				bookCaseService.viewBookCase();
				break;
			case Constants.EDIT_YOUR_BOOKCASE:
				String choiceEditBookCase;
				do {
					System.out.println("Please enter the number:");
					System.out.println("1. Add a new book");
					System.out.println("2. Remove a book");
					System.out.println("3. Clear BookCase");
					System.out.println("0. Exit");
					choiceEditBookCase = sc.nextLine();
					choiceEditBookCase = choiceEditBookCase.trim();
					switch (choiceEditBookCase) {
					case Constants.ADD_NEW_BOOK:
						bookCaseService.addNewBook(sc);
						break;
					case Constants.REMOVE_BOOK:
						bookCaseService.removeBook(sc);
						break;
					case Constants.CLEAR_BOOKCASE:
						bookCaseService.clearBookCase();
						break;
					default:
						choiceEditBookCase = Constants.LOGOUT;
						break;
					}
				} while (choiceEditBookCase != Constants.LOGOUT);
				break;
			default:
				choice = Constants.LOGOUT;
				break;
			}
		} while (choice != Constants.LOGOUT);
		System.out.println("LOGOUT! CLOSED");
	}
}
