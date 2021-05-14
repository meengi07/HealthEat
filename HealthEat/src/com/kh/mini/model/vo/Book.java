package com.kh.mini.model.vo;

public class Book { 
	
	
	
	
	void PostIt() {
		//�씠誘쇱옱1
		
		System.out.println("�꽦怨�");
		
	}
	public void testKKJ() {
		System.out.println("잘올라갔나?");
	}
	
	public void testBook() {
		
		System.out.println("諛⑺깭�쁽 �엯�땲�떎.");
		System.out.println("�옒遺��긽�뱶由쎈땲�떎.");
		
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
