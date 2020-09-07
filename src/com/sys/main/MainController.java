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

	//thay doi o day
	public static void main(String[] args) throws SQLException {
		Connection conn = SQLServerConnect.getMyConnect();
		if (conn != null) System.out.println("Connection Successfully!");
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();		
		System.out.println("hello");
		System.out.println("Wellcome to Read Book  Application! Please enter your username and password.");
		String userName = InputData.inputString("User name:", sc);
		String password = InputData.inputString("Password:", sc);
		userService.checkUserLogin(userName, password);
		user = new User(3, "user", "1234");
		int authoriry = 2;
		switch (authoriry) {
		case Constants.ADMIN_AUTHORITY:
			AdminController.admin();
			break;
		case Constants.USER_AUTHORITY:
			UserController.user();
			break;
		case Constants.ADMIN_USER_AUTHORITY:
			//account la admin & user
			break;
		default:
			break;
		}	
	}

}
