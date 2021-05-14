package com.kh.mini.model.vo;

public class Book { 
	
	
	
	
	void PostIt() {
		//이민재
		
		System.out.println("성공");
		
	}


	private String kkjname;
	private int kkjprice;
	private int kkjnum;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getKkjname() {
		return kkjname;
	}

	public void setKkjname(String kkjname) {
		this.kkjname = kkjname;
	}

	public int getKkjprice() {
		return kkjprice;
	}

	public void setKkjprice(int kkjprice) {
		this.kkjprice = kkjprice;
	}

	public int getKkjnum() {
		return kkjnum;
	}

	public void setKkjnum(int kkjnum) {
		this.kkjnum = kkjnum;
	}

	public Book(String kkjname, int kkjprice, int kkjnum) {
		super();
		this.kkjname = kkjname;
		this.kkjprice = kkjprice;
		this.kkjnum = kkjnum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return kkjname + " " + kkjprice + " " + kkjnum;
	}


	
}
