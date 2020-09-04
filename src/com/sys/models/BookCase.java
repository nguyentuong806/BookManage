package com.sys.models;

import java.io.Serializable;

public class BookCase implements Serializable{
	private static final long UIDSerialVersion = 1L;
	private int bookCaseId;
	private String bookCaseName;
	private int userId;
	public BookCase() {
		
	}
	public int getBookCaseId() {
		return bookCaseId;
	}
	public void setBookCaseId(int bookCaseId) {
		this.bookCaseId = bookCaseId;
	}
	public String getBookCaseName() {
		return bookCaseName;
	}
	public void setBookCaseName(String bookCaseName) {
		this.bookCaseName = bookCaseName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BookCase [bookCaseId=" + bookCaseId + ", bookCaseName=" + bookCaseName + ", userId=" + userId + "]";
	}
	

}
