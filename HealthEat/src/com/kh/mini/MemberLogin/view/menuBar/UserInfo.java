package com.kh.mini.MemberLogin.view.menuBar;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.mini.MemberLogin.view.front.Login;
import com.kh.mini.MemberLogin.view.front.MenuBar;
import com.kh.mini.MemberLogin.view.subMenu.ChangeInfo;

public class UserInfo extends Frame{

	private Login log = new Login();
	private String[] strArr = new String[5];
	
	public UserInfo() {
		//회원님의 개인정보입니다. 
		//이름 나이 성별 출력 후 
		//버튼 -> 회원정보수정 , 회원탈퇴하기, 돌아가기 
		//패널, 버튼만들기 
		strArr = log.getArr();
			//로그인한 유저정보 가져옴 
		//System.out.println(strArr[0]);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		JLabel info = new JLabel("회원님의 개인 정보 입니다.");
		JLabel nameLabel = new JLabel("이름 ");
		JLabel name = new JLabel();
		JLabel ageLabel = new JLabel("나이 ");
		JLabel age = new JLabel();
		JLabel genderLabel = new JLabel("성별 ");
		JLabel gender = new JLabel();
		JButton changeInfo = new JButton("회원 정보 수정");
		JButton deleteInfo = new JButton("회원 탈퇴");
		JButton back = new JButton("돌아가기");
		
		panel.setLayout(null);
		
		
		
		//				(가로위치, 세로위치, 가로크기, 세로크기)
		info.setBounds			(400, 30, 200, 50); //회원님의 개인정보입니다 라벨 띄움 (위치 중앙 상단)
		nameLabel.setBounds		(340, 100, 400, 50); //이름 안내라벨 
		name.setBounds			(340, 130, 400, 50); //회원 이름 표기 
		ageLabel.setBounds		(340, 180, 400, 50); //나이 안내라벨 
		age.setBounds			(340, 210, 400, 50); //나이 표기 
		genderLabel.setBounds	(340, 260, 400, 50); //성별 안내라벨 
		gender.setBounds		(340, 290, 400, 50); //성별 표기
		changeInfo.setBounds	(380, 380, 200, 50); //회원정보수정 버튼 
		deleteInfo.setBounds	(380, 430, 200, 50); //회원탈퇴 버튼 
		back.setBounds			(380, 480, 200, 50); //돌아가기 버튼 
		
		//레이블 글씨에 밑줄긋기 
		Font font = name.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		name.setFont(font.deriveFont(attributes));
		
		Font font2 = age.getFont();
		Map attributes1 = font2.getAttributes();
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		age.setFont(font.deriveFont(attributes1));
		
		Font font3 = gender.getFont();
		Map attributes2 = font3.getAttributes();
		attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		gender.setFont(font.deriveFont(attributes2));
		
		//프레임 위치 및 크기 설정 
		frame.setTitle("회원정보관리");
		frame.setVisible(true);
		frame.setSize(900,600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		/*
		String str1;
		ArrayList arr = new ArrayList<String[]>();

		BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));
		
		while((str1=br.readLine()) !=null) {
			String[] srr = str1.split("/");
			arr.add(srr);
			
			
		}
		*/
		name.setText(strArr[2]);	// 회원이름 출력 
		age.setText(strArr[3]);	// 나이 출력 
		gender.setText(strArr[4]); // 성별 출력 
		//회원정보수정 화면으로 이동 버튼 
		
		panel.add(info);
		panel.add(nameLabel);
		panel.add(name);
		panel.add(ageLabel);
		panel.add(age);
		panel.add(genderLabel);
		panel.add(gender);
		panel.add(changeInfo);
		panel.add(deleteInfo);
		panel.add(back);
		//panel.repaint();
		
		frame.add(panel);
		
		changeInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeInfo ci = new ChangeInfo();
				
			}
			
		});
		
		//회원탈퇴 버튼. 누르면 txt 내용 초기화
		deleteInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "회원을 탈퇴 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter("UserInfo",true));
						//bw = new BufferedWriter(new FileWriter("UserInfo")); //재선언 시 파일내용 초기화, 즉 삭제한다.
						//한줄만 삭제하게 만들어야함. 
						
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					JOptionPane.showMessageDialog(null, "회원탈퇴가 완료되었습니다.");
					Login lg = new Login();
				}else {
					return;
				}
				
			}
			
		});
		
		//돌아가기 
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 MenuBar menu = new MenuBar();
			}
			
		});
		
		
	}
	
}

