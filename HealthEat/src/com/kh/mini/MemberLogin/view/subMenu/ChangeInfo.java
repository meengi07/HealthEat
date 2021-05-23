package com.kh.mini.MemberLogin.view.subMenu;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.MemberLogin.view.menuBar.UserInfo;

public class ChangeInfo extends Frame {

	private UserInfo ui = new UserInfo();
	
	public ChangeInfo() {
	
		//회원정보 수정 및 팝업 
		JFrame frame = new JFrame();
	
		
		JPanel panel = new JPanel();
		
		JLabel titleInfo = new JLabel("변경할 내용을 입력해주세요");
		JLabel chgPw1 = new JLabel("변경할 비밀번호");
		JLabel chgPw2 = new JLabel("비밀번호 확인");
		JLabel age = new JLabel("나이");
		JLabel gender = new JLabel("성별");
		
		JTextField pwTxt1 = new JTextField(); 		//비번1 
		JTextField pwTxt2 = new JTextField();		//비번2 
		JTextField ageTxt1 = new JTextField();		//나이 
		JTextField genderTxt1 = new JTextField();	//성별 
		
		JButton chgBtn = new JButton("변경하기");
		JButton backBtn = new JButton("돌아가기");
		
		panel.setLayout(null);
		titleInfo.setBounds		(400, 30, 200, 50);
		chgPw1.setBounds		(320, 100, 100, 50);
		pwTxt1.setBounds		(420, 100, 200, 50);
		chgPw2.setBounds		(320, 150, 100, 50);
		pwTxt2.setBounds		(420, 150, 200, 50);
		age.setBounds			(320, 200, 100, 50);
		ageTxt1.setBounds		(420, 200, 200, 50);
		gender.setBounds		(320, 250, 100, 50);
		genderTxt1.setBounds	(420, 250, 200, 50);
		chgBtn.setBounds		(380, 350, 200, 50);
		backBtn.setBounds		(380, 400, 200, 50);
		
		
		panel.add(titleInfo);
		panel.add(chgPw1);
		panel.add(chgPw2);
		panel.add(age);
		panel.add(gender);
		panel.add(pwTxt1);
		panel.add(pwTxt2);
		panel.add(ageTxt1);
		panel.add(genderTxt1);
		panel.add(chgBtn);
		panel.add(backBtn);
		
		setTitle("회원정보 수정");
		setVisible(true);
		setSize(900,600);
		setLocationRelativeTo(null); //화면 중앙에 띄움 
		setResizable(false); // 창 크기 고정 (불변)
		
		chgBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "내용이 변경되었습니다.");
				UserInfo ui = new UserInfo();
			}
			
		});
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserInfo ui = new UserInfo();
			}
			
		});
		
		
		add(panel);
		
	}
}
