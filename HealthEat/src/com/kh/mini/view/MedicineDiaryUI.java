package com.kh.mini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MedicineDiaryUI extends JFrame{
// git에 있는 복용 일기 클래스
public MedicineDiaryUI() {
		
		this.setTitle("복용 일기 메인메뉴");
		this.setBounds(600, 100, 600, 800);
		//this.setSize(600, 800);
		this.setLayout(null);
		
		JPanel panel1 = new JPanel(); // 복용일기 메인 메뉴
		JPanel panel2 = new JPanel(); // 복용일기 작성 페이지
		JPanel panel3 = new JPanel(); // 뵥용일기 작성_요일별 체크 페이지
		JPanel panel4 = new JPanel(); // 복용일기 작성_주기별 체크 페이지
		
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		
		//복용 일기 목록 확인 코드 추가
		
		
		
		//labelTitle.setBounds(50, 10, 50, 150);
		
		//복용 일기 메인 페이지 설정하기
		
		JButton btn1 = new JButton("복용 일기 작성하기");
		JButton btn2 = new JButton("돌아가기");//메인 선택 창으로 돌아가기 버튼
		
		panel1.setLayout(null);
		panel1.setBounds(10, 50, 500, 700);
		btn1.setBounds(200, 500, 200, 40); // 복용일기 작성하기 버튼 위치 및 크기
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false); // 첫 화면 가리기
				panel2.setVisible(true); // 복용 일기 작성하기 페이지 활성화
				panel3.setVisible(false);
				panel4.setVisible(false);
				
			}
		});
		
		panel1.add(btn1);
		panel1.add(btn2);
		btn2.setBounds(250, 600, 100, 40);
		// 해당 버튼을 누렀을 시 메인 선택창으로 돌아가는 액션리스너를 추가
		
		this.add(panel1);
		this.add(panel2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
