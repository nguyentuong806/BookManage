package com.sys.utils;

import java.util.Scanner;

public class InputData {
	public static int inputInt(String msg, Scanner sc) {
		int value = 0;
		while(true) {
			try {
				System.out.println(msg);
				value = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid data. Try again!");
			}
		}
		return value;
	}
	
	public static double inputDouble(String msg, Scanner sc) {
		double value = 0;
		while(true) {
			try {
				System.out.println(msg);
				value = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid data. Try again!");
			}
		}
		return value;
	}
	
	public static String inputString(String msg, Scanner sc) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
}
