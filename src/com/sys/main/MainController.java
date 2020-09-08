package com.sys.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.sys.dao.UserDao;
import com.sys.dao.UserRoleDao;
import com.sys.models.User;
import com.sys.models.UserRole;
import com.sys.services.BookCaseService;
import com.sys.services.BookService;
import com.sys.services.UserService;
import com.sys.utils.Constants;
import com.sys.utils.InputData;
import com.sys.utils.SQLServerConnect;

public class MainController {

	public static User user;

	public static void main(String[] args) throws SQLException {
		Connection conn = SQLServerConnect.getMyConnect();
		if (conn != null)
			System.out.println("Connection Successfully!");
		Scanner sc = new Scanner(System.in);
		UserDao userDao = new UserDao();
		UserRoleDao userRoleDao = new UserRoleDao();
		BookService bookService = new BookService();
		BookCaseService bookCaseService = new BookCaseService();

		do {
			List<User> listUser = userDao.getAll();
			List<UserRole> listUserRole = userRoleDao.getAll();
			int authoriry = UserService.login(sc, listUser, listUserRole);
			String choice;
			do {
				System.out
						.println("Hello User, Please select a function bellow by entering the corresponding number.");
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
					if (authoriry == Constants.ADMIN_AUTHORITY) {
						bookService.createBook(sc);
					}else {
						System.out.println("You don't have permission!");
					}
					break;
				case Constants.DELETE_BOOK:
					if (authoriry == Constants.ADMIN_AUTHORITY) {
						bookService.removeBook();
					}else {
						System.out.println("You don't have permission!");
					}
					break;
				case Constants.UPDATE_CONTENT_BOOK:
					if (authoriry == Constants.ADMIN_AUTHORITY) {
						bookService.updateBook(sc, InputData.inputInt("Please enter book id:", sc));
					}else {
						System.out.println("You don't have permission!");
					}
					break;
				default:
					choice = Constants.LOGOUT;
					user = null;
					break;
				}
			} while (choice != Constants.LOGOUT);
		} while (true);
	}

}
