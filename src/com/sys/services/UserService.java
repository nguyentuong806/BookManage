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
		return Constants.USER_AUTHORITY;
//		return Constants.ADMIN_AUTHORITY;
	}
}
