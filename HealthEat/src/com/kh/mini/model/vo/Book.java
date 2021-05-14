package com.kh.mini.model.vo;

import java.util.Scanner;

public class Book {

	
	    Scanner sc = new Scanner(System.in);
	
		public void Upbit() {
			System.out.println("코인번호를 입력하세요");
			int coin = sc.nextInt();
			
			String co = "";
			switch(coin) {
			
			case 1 :  co = "그리스톨 코인" ;
				 break;
				 
			case 2 :  co = "스팀머니" ;
			 break;
			
			case 3 :  co = "이오스" ;
			 break;
			
			case 4 :  co = "헤데라해시그래프" ;
			 break;
			
			}
			
			
			
			
			
			
			System.out.println("그리스톨 코인");
			
			
		}
	
	
	
}
