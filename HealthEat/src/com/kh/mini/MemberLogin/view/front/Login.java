package com.kh.mini.MemberLogin.view.front;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.kh.mini.MemberLogin.model.vo.Member;

public class Login extends Frame {
//로그인 화면 뷰어, 프레임과 패널을 구현해서 로그인창 만들기. 
	
	private Member m = new Member();
	
	//private JPanel panel;
	private JLabel id = new JLabel("ID : ");
	private JLabel pw = new JLabel("PW : ");
	private JTextField tf = new JTextField(10); // 숫자10은 칸수 
	private JButton logBtn, joinBtn;
	private JPasswordField pwf = new JPasswordField(10);
	
	
	public Login() {
		
		//로그인 메인페이지 
		JFrame frame = new JFrame("영양제 복용일기 프로그램");
		frame.setLocation(350, 250);
		frame.setPreferredSize(new Dimension(1500,800));
		Container contentPane = frame.getContentPane();
		
		JPanel panel = new JPanel(); 
		
		JLabel id = new JLabel("ID");
		JTextField idTxt = new JTextField();
		JLabel pw = new JLabel("PW");
		JPasswordField pwTxt = new JPasswordField();
		JButton logBtn = new JButton("로그인");
		JButton sigBtn = new JButton("회원가입");
		JButton masterBtn = new JButton("관리자 권한");
		

		JPanel idP = new JPanel(); //아이디 칸  
		JPanel idT = new JPanel(); //아이디 입력 
		JPanel pwP = new JPanel(); //비밀번호 
		JPanel pwT = new JPanel(); //비밀번호 입력  
		JPanel logP = new JPanel(); //로그인버튼 칸 
		JPanel signP = new JPanel(); //가입버튼 칸 
		
		frame.setTitle("영양제 복용일기 프로그램");
		frame.setVisible(true);
		frame.setSize(900,600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		idP.add(id);
		idT.add(idTxt);
		pwP.add(pw);
		pwT.add(pwTxt);
		//		(가로위치, 세로위치, 가로크기, 세로크기)
		panel.setLayout(null); 
		idP.setBounds		(250,140,49,49);	
		idTxt.setBounds		(300,140,300,50);
		pwP.setBounds		(250,190,49,49);
		pwTxt.setBounds		(300,190,300,50);
		logBtn.setBounds	(350,270,150,50);
		sigBtn.setBounds	(350,330,150,50);
		masterBtn.setBounds	(700, 500, 120, 40);
		
		idP.setBorder(new LineBorder(Color.gray,1));
		pwP.setBorder(new LineBorder(Color.gray,1));
		
		panel.add(idP);
		panel.add(idTxt);
		panel.add(pwP);
		panel.add(pwTxt);
		panel.add(logBtn);
		panel.add(sigBtn);
		panel.add(masterBtn);
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		
		
		//로그인버튼 
 		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String str;
					ArrayList arr = new ArrayList<String[]>();
					BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));
				
						while((str=br.readLine()) !=null) {
							String[] srr = str.split("/");
							arr.add(srr);
							if(idTxt.getText().equals(srr[0]) && pwTxt.getText().equals(srr[1])) {
								JOptionPane.showMessageDialog(null, "로그인에 성공했습니다. ");
								MenuBar mb = new MenuBar();
							}else {
								JOptionPane.showMessageDialog(null, "로그인에 실패했습니다. ");
							}
						}
						br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
 			
 		});
 		sigBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignIn sign = new SignIn();
			}
 			
 		});
 		
 		
 		

	}


	
}
	
