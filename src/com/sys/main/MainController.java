package com.sys.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.sys.models.User;
import com.sys.services.BookCaseService;
import com.sys.services.UserService;
import com.sys.utils.Constants;
import com.sys.utils.InputData;
import com.sys.utils.SQLServerConnect;

public class MainController {
	
	public static User user;

	
	public static void main(String[] args) throws SQLException {
		Connection conn = SQLServerConnect.getMyConnect();
		if (conn != null) System.out.println("Connection Successfully!");
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();		
		System.out.println("Wellcome to Read Book  Application! Please enter your username and password.");
		String userName = InputData.inputString("User name:", sc);
		String password = InputData.inputString("Password:", sc);
		int authoriry = Constants.ADMIN_AUTHORITY;
		user = new User(3, "user", "1234");
		switch (authoriry) {
		case Constants.ADMIN_AUTHORITY:
			AdminController.admin();
			break;
		case Constants.USER_AUTHORITY:
			UserController.user();
			break;
		default:
			break;
		}
	}

}
