package com.kh.mini.searchAdmin.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.mini.searchAdmin.model.vo.Nutri;

public class NutriManager {

	//영양제 리스트
	public ArrayList<Nutri> nList = new ArrayList<Nutri>();
	
	{
		//String basicNutri, String manufac, String quantity, int price, String otherNutri, String effect, int viewCount
		//주영양소, 제조사, 용량, 가격, 부가영양소, 효능효과, 인기도(기본0)
		nList.add(new Nutri("비타민D3", "Now Foods", "120정", 6500, "", "튼튼한 뼈 유지, 면역계 강화", 0));
		nList.add(new Nutri("마그네슘", "Doctor's Best", "120정", 10700, "", "뼈, 심장, 신경 및 근육 건강 지원", 0));
		nList.add(new Nutri("CoQ10", "California Gold Nutrition", "150정", 20000, "", "심혈관계 건강 지원", 0));
		nList.add(new Nutri("LactoBif 프로바이오틱", "California Gold Nutrition", "60정", 22000, "", "소화기관 건강 지원", 0));
		nList.add(new Nutri("프로폴리스", "Y.S. Eco Bee Farms", "90정", 12800, "", "호흡기 건강 지원", 0));
		nList.add(new Nutri("분리유청단백질", "EVLution Nutrition", "1.6파운드", 31000, "", "근육 생성, 근육 회복, 단백질 합성, 근육 강화", 0));
	}
	

	
	public NutriManager() {
		// TODO Auto-generated constructor stub
	}
	
	
	//영양제 전체 리스트 주소값 리턴
	public ArrayList<Nutri> showAll2() {
		System.out.println(nList);
		return nList;
	}
	
	
	//영양소 키워드 검색 리스트 출력
	public ArrayList<Nutri> searchList2(String keyword) {
		
		ArrayList<Nutri> searchList = new ArrayList<Nutri>();
		
		for (int i = 0; i < nList.size(); i++) {
			if (((List<Nutri>) nList.get(i)).contains(keyword)) {
				//searchList[count] = nList[i]; //어떻게 바꿔야 하지??
				searchList.add(nList.get(i));
			} 
		}
		
		return searchList;
	}
	
	
	//======================================================================================================================
	
	//관리자모드 - 영양제 등록
	public void newNutri(String basicNutri, String manufac, String quantity, int price, String otherNutri, String effect, int viewCount) {
		//view에서 입력 받아와서 넣기
		//String basicNutri, String manufac, String quantity, int price, String otherNutri, String effect, int viewCount
		nList.add(new Nutri(basicNutri, manufac, quantity, price, otherNutri, effect, 0));
	}
	
	
	public void editNutriShow(String keyword) {
		//검색어 포함된 영양제 목록 출력
		System.out.println(nList.contains(keyword));
		
	}
	
	public void editNutri(int index, String basicNutri, String manufac, String quantity, int price, String otherNutri, String effect, int viewCount) {
		//수정할 인덱스 선택해서 수정
		nList.set(index, new Nutri(basicNutri, manufac, quantity, price, otherNutri, effect, 0));
	}
	
	
	public void deleteNutri(int index) {
		//삭제할 인덱스 선택해서 삭제
		nList.remove(index);
	}

}