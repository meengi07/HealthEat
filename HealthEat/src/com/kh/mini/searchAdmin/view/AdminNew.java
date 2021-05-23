package com.kh.mini.searchAdmin.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.searchAdmin.controller.NutriManager;

public class AdminNew extends JFrame {

	public static void main(String[] args) {
		new AdminNew();
	}
	
	private NutriManager nm = new NutriManager();
	
	//관리자 모드 - 영양제 신규 등록
	public AdminNew() {
		//창 이름
		JFrame frame = new JFrame("영양제 신규 등록");
		
		//패널
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 840, 840/12*9);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		//패널뷰 조정
		panel.setVisible(true);
		
		//정보 입력창
		JLabel lab1 = new JLabel("주영양소 : ");
		lab1.setLocation(40, 100);
		lab1.setSize(200, 30);
		
		JTextField text1 = new JTextField();
		text1.setLocation(150, 100);
		text1.setSize(300, 30);
		
		JLabel lab2 = new JLabel("제조사 : ");
		lab2.setLocation(40, 150);
		lab2.setSize(200, 30);
		
		JTextField text2 = new JTextField();
		text2.setLocation(150, 150);
		text2.setSize(300, 30);
		
		JLabel lab3 = new JLabel("용량 : ");
		lab3.setLocation(40, 200);
		lab3.setSize(200, 30);
		
		JTextField text3 = new JTextField();
		text3.setLocation(150, 200);
		text3.setSize(300, 30);
		
		JLabel lab4 = new JLabel("가격 : ");
		lab4.setLocation(40, 250);
		lab4.setSize(200, 30);
		
		JTextField text4 = new JTextField();
		text4.setLocation(150, 250);
		text4.setSize(300, 30);
		
		JLabel lab5 = new JLabel("부가영양소 : ");
		lab5.setLocation(40, 300);
		lab5.setSize(200, 30);
		
		JTextField text5 = new JTextField();
		text5.setLocation(150, 300);
		text5.setSize(300, 30);
		
		JLabel lab6 = new JLabel("효능효과 : ");
		lab6.setLocation(40, 350);
		lab6.setSize(200, 30);
		
		JTextField text6 = new JTextField();
		text6.setLocation(150, 350);
		text6.setSize(300, 30);
		
		JButton btn = new JButton("등  록");
		btn.setLocation(200, 450);
		btn.setSize(100, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panel.add(lab1);
		panel.add(text1);
		
		//event 넣기
		//등록 버튼 - nList의 마지막 인덱스에 추가
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//text1~6 값 nm의 newNutri에 넘겨주기
				//nm.newNutri(text1, text2, text3, text4, text5, text6, 0);
				
				
				//팝업창
				int answer = JOptionPane.showConfirmDialog(null, "등록 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					
				}
			}
		});
		
		
		//프레임에 패널 넣기
		frame.add(panel);
		
		//프레임 기본 설정
		this.setPreferredSize(new Dimension(840, 840/12*9));
		this.setSize(840, 840/12*9);
		this.setLayout(null);
		this.setLocationRelativeTo(null); //화면 가운데 뜨게
		this.setResizable(false); //false : 화면크기 조정 안되도록// true : 화면크기 조정되도록
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
