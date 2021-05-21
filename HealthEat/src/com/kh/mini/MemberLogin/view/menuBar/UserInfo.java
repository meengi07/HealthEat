package com.kh.mini.MemberLogin.view.menuBar;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.mini.MemberLogin.view.front.Login;
import com.kh.mini.MemberLogin.view.front.MenuBar;
import com.kh.mini.MemberLogin.view.subMenu.ChangeInfo;

public class UserInfo extends Frame{

	
	
	public UserInfo() {
		//회원님의 개인정보입니다. 
		//이름 나이 성별 출력 후 
		//버튼 -> 회원정보수정 , 회원탈퇴하기, 돌아가기 
		JFrame frame = new JFrame();
		frame.setLocation(350, 250);
		
		//패널, 버튼만들기 
		JPanel panel = new JPanel();
		
		JLabel info = new JLabel("회원님의 개인 정보 입니다.");
		
		JLabel nameLabel = new JLabel("이름 ");
		JLabel name = new JLabel("__________________________________________");
		JLabel ageLabel = new JLabel("나이 ");
		JLabel age = new JLabel("__________________________________________");
		JLabel genderLabel = new JLabel("성별 ");
		JLabel gender = new JLabel("__________________________________________");
		
		JButton changeInfo = new JButton("회원 정보 수정");
		JButton deleteInfo = new JButton("회원 탈퇴");
		JButton back = new JButton("돌아가기");
		
		panel.setLayout(null);
		
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
		
		setTitle("회원정보관리");
		setVisible(true);
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		add(panel);
		
		changeInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangeInfo ci = new ChangeInfo();
				
			}
			
		});
		
		deleteInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "회원을 탈퇴 하시겠습니까?", "확인", JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "회원탈퇴가 완료되었습니다.");
					Login lg = new Login();
				}else {
					return;
				}
				
			}
			
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 MenuBar menu = new MenuBar();
			}
			
		});
		
		
	}
	
}

