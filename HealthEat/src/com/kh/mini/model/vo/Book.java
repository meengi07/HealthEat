package com.kh.mini.model.vo;

public class Book {

	private String name;
	private String bookNum;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public void mingi() {
		//김민기 
	}

	public Book(String name, String bookNum) {
		super();
		this.name = name;
		this.bookNum = bookNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name : " + name + "bookNum : " + bookNum; 
	}
	
}
