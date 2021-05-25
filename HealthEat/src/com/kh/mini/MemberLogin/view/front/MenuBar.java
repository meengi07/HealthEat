package com.kh.mini.MemberLogin.view.front;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.mini.MemberLogin.view.menuBar.UserInfo;

public class MenuBar extends Frame{

	public MenuBar() {
		//메뉴바 
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		JButton userInfo = new JButton("회원 정보 관리");
		JButton healthNum = new JButton("영양 점수 ");
		JButton eatNote = new JButton("복용 일기 관리");
		JButton healthInfo = new JButton("영양제 정보 조회");
		JButton help = new JButton("실시간 문의");
		JButton back = new JButton("돌아가기");
		
		//프레임 위치 및 크기 설정 
		frame.setTitle("== Health Eat ==");
		frame.setVisible(true);
		frame.setSize(900,600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		//프레임, 패널 생성 
		frame.add(panel);
		panel.setLayout(null);
		panel.add(userInfo);
		panel.add(healthNum);
		panel.add(eatNote);
		panel.add(healthInfo);
		panel.add(help);
		panel.add(back);
		
		//		(가로위치, 세로위치, 가로크기, 세로크기)
		userInfo.setBounds	(350, 30, 200, 60);
		healthNum.setBounds	(350, 110, 200, 60);
		eatNote.setBounds	(350, 190, 200, 60);
		healthInfo.setBounds(350, 270, 200, 60);
		help.setBounds		(350, 350, 200, 60);
		back.setBounds		(350, 430, 200, 60);
		
		// 회원 정보 조회 , 관리창으로 연결버튼 
		userInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					UserInfo ui = new UserInfo();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		// 영양 점수 관리 기능 연결버튼 
		healthNum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		
		// 복용 일기 연결버튼 
		eatNote.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		
		// 영양제 정보 조회버튼 
		healthInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		// 실시간 문의 연결버튼 
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 
				
			}
			
		});
		
		//돌아가기 버튼 
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Login lo = new Login();
			}
			
		});
	}
	
	
}
