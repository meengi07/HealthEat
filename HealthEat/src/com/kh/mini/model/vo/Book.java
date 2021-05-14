package com.kh.mini.model;

public class Book {

	
	private String kkjname2;
	private int kkjprice2;
	private int kkjnum2;
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}


	public Book(String kkjname2, int kkjprice2, int kkjnum2) {
		super();
		this.kkjname2 = kkjname2;
		this.kkjprice2 = kkjprice2;
		this.kkjnum2 = kkjnum2;
	}


	public String getKkjname2() {
		return kkjname2;
	}


	public void setKkjname2(String kkjname2) {
		this.kkjname2 = kkjname2;
	}


	public int getKkjprice2() {
		return kkjprice2;
	}


	public void setKkjprice2(int kkjprice2) {
		this.kkjprice2 = kkjprice2;
	}


	public int getKkjnum2() {
		return kkjnum2;
	}


	public void setKkjnum2(int kkjnum2) {
		this.kkjnum2 = kkjnum2;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "삐삒 경준입니다";
	}

}
