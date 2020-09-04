package com.sys.services;

import com.sys.utils.Constants;

public class UserService {
	
	/**
	 * Check user login & authority 
	 * @param userName
	 * @param password
	 * @return
	 */
	public int checkUserLogin(String userName, String password) {
		// add method
		//System.out.println("Username or Password is wrong!\nPleass enter again:");
		return Constants.USER_AUTHORITY;
	}
}
