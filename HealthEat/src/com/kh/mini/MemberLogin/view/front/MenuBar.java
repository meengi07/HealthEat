package com.kh.mini.MemberLogin.view.front;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuBar extends Frame{

	public MenuBar() {
		
		JFrame frame = new JFrame();
		frame.setLocation(350, 250);
		Container contentPane = frame.getContentPane();
		
		JPanel panel = new JPanel();
		
		JButton userInfo = new JButton("회원 정보 관리");
		JButton healthNum = new JButton("영양 점수 ");
		JButton eatNote = new JButton("복용 일기 관리");
		JButton healthInfo = new JButton("영양제 정보 조회");
		JButton help = new JButton("실시간 문의");
		
		panel.setLayout(null);
		panel.add(userInfo);
		panel.add(healthNum);
		panel.add(eatNote);
		panel.add(healthInfo);
		panel.add(help);
		
		//		(가로위치, 세로위치, 가로크기, 세로크기)
		userInfo.setBounds	(350, 50, 200, 60);
		healthNum.setBounds	(350, 150, 200, 60);
		eatNote.setBounds	(350, 250, 200, 60);
		healthInfo.setBounds(350, 350, 200, 60);
		help.setBounds		(350, 450, 200, 60);
		
		setTitle("== Health Eat ==");
		setVisible(true);
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(panel);
		
		userInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원 정보 조회 , 관리창으로 연결 
				
			}
			
		});
		healthNum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 영양 점수 관리 기능 연결 
				
			}
			
		});
		eatNote.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 복용 일기 연결 
				
			}
			
		});
		healthInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 영양제 정보 조회
				
			}
			
		});
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 실시간 문의 연결 
				
			}
			
		});
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	
}
