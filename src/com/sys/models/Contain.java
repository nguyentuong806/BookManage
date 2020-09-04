package com.sys.models;

public class Contain {
	private static final long UIDSerialVersion = 1L;
	private int bookCaseId;
	private int bookId;
	private String createDate;

	public Contain() {
		
	}

	public int getBookCaseId() {
		return bookCaseId;
	}

	public void setBookCaseId(int bookCaseId) {
		this.bookCaseId = bookCaseId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Contain [bookCaseId=" + bookCaseId + ", bookId=" + bookId + ", createDate=" + createDate + "]";
	}
	

}
