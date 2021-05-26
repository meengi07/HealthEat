package com.sy.mvc.model.vo;

public class Nutri {

	private String basicNutri; //주영양소
	private String manufac; //제조회사
	private String quantity; //용량
	private String price;		//가격
	private String otherNutri; //기타영양소
	private String effect; //효능효과(신체 부위)
	private String viewCount;	//조회수(인기도)
	
	public Nutri() {
		// TODO Auto-generated constructor stub
	}

	public Nutri(String basicNutri, String manufac, String quantity, String price, String otherNutri, String effect,
			String viewCount) {
		super();
		this.basicNutri = basicNutri;
		this.manufac = manufac;
		this.quantity = quantity;
		this.price = price;
		this.otherNutri = otherNutri;
		this.effect = effect;
		this.viewCount = viewCount;
	}

	public String getBasicNutri() {
		return basicNutri;
	}

	public void setBasicNutri(String basicNutri) {
		this.basicNutri = basicNutri;
	}

	public String getManufac() {
		return manufac;
	}

	public void setManufac(String manufac) {
		this.manufac = manufac;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOtherNutri() {
		return otherNutri;
	}

	public void setOtherNutri(String otherNutri) {
		this.otherNutri = otherNutri;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n주영양소 : " + basicNutri
				+ "\n제조사 : " + manufac
				+ "\n용량 : " + quantity
				+ "\n가격 : " + price + "원"
				+ "\n부가영양소 : " + otherNutri
				+ "\n효능효과 : " + effect
				+ "\n인기도(조회수) : " + viewCount
				+ "\n";
	}

}
