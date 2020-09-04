package com.sys.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String formatDate(Date date, String formatDate) { 
        DateFormat dateFormat = new SimpleDateFormat(formatDate);  
        String strDate = dateFormat.format(date);  
        return strDate;
	}
}
