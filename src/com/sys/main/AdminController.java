package com.sys.main;

import java.util.Scanner;

import com.sys.models.Book;
import com.sys.models.User;
import com.sys.services.BookCaseService;
import com.sys.services.BookService;
import com.sys.utils.Constants;
import com.sys.utils.InputData;

public class AdminController {
	public static void admin() {
		Scanner sc = new Scanner(System.in);
		BookService bookService = new BookService();
		BookCaseService bookCaseService = new BookCaseService();
		String choice;

		do {
			System.out.println("Hello Admin, Please select a function bellow by entering the corresponding number.");
			System.out.println("1. View List Books");
			System.out.println("2. Search Books");
			System.out.println("3. Read Book");
			System.out.println("4. View Your BookCase");
			System.out.println("5. Edit Your BookCase");
			System.out.println("6. Create Book");
			System.out.println("7. Delete Book");
			System.out.println("8. Edit Book");
			System.out.println("0. Logout");
			choice = sc.nextLine();
			choice = choice.trim();
			switch (choice) {
			case Constants.VIEW_LIST_BOOK:
				bookService.viewListBook();
				break;
			case Constants.SEARCH_BOOK:
				bookService.Search(sc);
				break;
			case Constants.READ_BOOK:
				bookService.readBook(sc);
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
			case Constants.CREATE_BOOK:
				bookService.createBook(sc);
				break;
			case Constants.DELETE_BOOK:
				bookService.removeBook();
				break;
			case Constants.UPDATE_CONTENT_BOOK:
				bookService.updateBook(sc, InputData.inputInt("Please enter book id:", sc));
				break;
			default:
				choice = Constants.LOGOUT;
				break;
			}
		} while (choice != Constants.LOGOUT);
		System.out.println("LOGOUT! CLOSED");
	}
}
