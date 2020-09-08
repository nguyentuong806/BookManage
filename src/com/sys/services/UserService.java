package com.sys.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sys.main.MainController;
import com.sys.models.Book;
import com.sys.models.User;
import com.sys.models.UserRole;
import com.sys.utils.Constants;
import com.sys.utils.InputData;

public class UserService {
	
	/**
	 * Login to application
	 * @param sc
	 * @param listUser
	 * @param listUserRole
	 * @return
	 */
	public static int login (Scanner sc,List<User> listUser, List<UserRole> listUserRole){
//		for (User user : listUser) {
//			System.out.println(user.toString());
//		}
        System.out.println("Welcome to Read Book Application! Please enter your username and password.");
        String userName = InputData.inputString("User name : ", sc);
        String password = InputData.inputString("Password : ", sc);

        for(User u : listUser){
            if(u.getUserName().equals(userName) && u.getPassword().equals(password)){
                MainController.user = u;
            }
        }
        if(MainController.user!= null){
            for(UserRole ur : listUserRole){
                if(MainController.user.getId()==ur.getUserId()){
                    if(ur.getRoleId() == Constants.ADMIN_AUTHORITY){
                        return Constants.ADMIN_AUTHORITY;
                    }
                }
            }
            return Constants.USER_AUTHORITY;
        }
        else{
            return 0;
        }
    }
}
