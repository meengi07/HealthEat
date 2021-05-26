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
	private String[] arr = new String[5];
	//ArrayList arr = new ArrayList<String[]>();
	public String[] getArr() {
		System.out.println(arr[0]);
		return arr;
		
	}
	
	public Login() {
		
		//로그인 메인페이지 
		JFrame frame = new JFrame("영양제 복용일기 프로그램");
		JPanel panel = new JPanel(); 
		
		JLabel id = new JLabel("ID");
		JTextField idTxt = new JTextField();
		JLabel pw = new JLabel("PW");
		JPasswordField pwTxt = new JPasswordField();
		JButton logBtn = new JButton("로그인");
		JButton sigBtn = new JButton("회원가입");
		JButton masterBtn = new JButton("관리자 권한");
		
		// 레이블, 필드, 버튼을 각각 패널에 넣고 -> 메인패널에 각 패널들을 넣어 정렬함.  
		JPanel idP = new JPanel(); //아이디 칸  
		JPanel idT = new JPanel(); //아이디 입력 
		JPanel pwP = new JPanel(); //비밀번호 
		JPanel pwT = new JPanel(); //비밀번호 입력  
		JPanel logP = new JPanel(); //로그인버튼 칸 
		JPanel signP = new JPanel(); //가입버튼 칸 
		
		//프레임 크기및 위치등 설정 
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
		// 각 패널 위치및 크기 조정 
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
		
		
		//로그인버튼 
 		logBtn.addActionListener(new ActionListener() {
 			
 			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String idT = idTxt.getText();
					String str;
					//String[] arr;
					//arr = new String[5]; //회원정보배열에 담기 
					BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));
						//아이디 비교해서 해당 아이디 정보 불러오기 
						
						while((str=br.readLine()) !=null) {
							if(str.indexOf(idT) == 0 )	{
								arr = str.split("/");
							}
						}
						//System.out.println(arr[1]);
						if(idTxt.getText().equals(arr[0]) && pwTxt.getText().equals(arr[1])) {
							JOptionPane.showMessageDialog(null, "로그인에 성공했습니다. ");
							MenuBar mb = new MenuBar();
						}else {
							JOptionPane.showMessageDialog(null, "로그인에 실패했습니다. ");
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
				frame.setVisible(false);
			}
 			
 		});
 	
 		

	}
	
	
	
}
	
