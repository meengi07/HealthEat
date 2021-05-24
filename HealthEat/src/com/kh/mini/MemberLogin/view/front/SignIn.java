package com.kh.mini.MemberLogin.view.front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.kh.mini.MemberLogin.model.vo.Member;

public class SignIn extends Frame{


		
	public SignIn() {
		//창 띄우기 
		JFrame frame = new JFrame();
		frame.setLocation(350, 250);
		frame.setPreferredSize(getPreferredSize());
		Container contentPane = frame.getContentPane();
	
		
		//
		JPanel panel = new JPanel();
		
		JLabel id = new JLabel("ID");
		JTextField idTxt = new JTextField();
		
		JLabel pw1 = new JLabel("비밀번호");
		JPasswordField pw1F = new JPasswordField();
		
		JLabel name = new JLabel("이 름");
		JTextField nameTxt = new JTextField();
		
		JLabel age = new JLabel("나 이");
		JTextField ageTxt = new JTextField();
		
		JLabel gender = new JLabel("성 별");
		JTextField genderTxt = new JTextField();
		
		JButton back = new JButton("돌아가기");
		JButton okay = new JButton("가입하기");
		
		//
		Member m = new Member();
		
		
		//
		
		frame.add(panel);
		panel.setLayout(null);
		//패널 = 칸 만들기 .
		panel.add(id);
		panel.add(idTxt);
		
		panel.add(pw1);
		panel.add(pw1F);

		panel.add(name);
		panel.add(nameTxt);
		
		panel.add(age);
		panel.add(ageTxt);
		
		panel.add(gender);
		panel.add(genderTxt);
		
		panel.add(back);
		
		panel.add(okay);
		// =================
		//			(가로위치, 세로위치, 가로크기, 세로크기)
		id.setBounds		(320, 50, 79, 49); //id border line 1px 예정 
		idTxt.setBounds		(400, 50, 200, 50);  
		pw1.setBounds		(320, 110, 79, 49); //id border line 1px 예정 
		pw1F.setBounds		(400, 110, 200, 50);  
		name.setBounds		(320, 170, 79, 49); //id border line 1px 예정 
		nameTxt.setBounds	(400, 170, 200, 50); 
		age.setBounds		(320, 230, 79, 49); //id border line 1px 예정 
		ageTxt.setBounds	(400, 230, 200, 50);  
		gender.setBounds	(320, 290, 79, 49); //id border line 1px 예정 
		genderTxt.setBounds	(400, 290, 200, 50);  
		back.setBounds		(250, 350, 150, 50); //id border line 1px 예정 
		okay.setBounds		(450, 350, 150, 50); //id border line 1px 예정 
		
		id.setBorder		(new LineBorder(Color.black,1));
		pw1.setBorder		(new LineBorder(Color.black,1));
		name.setBorder		(new LineBorder(Color.black,1));
		age.setBorder		(new LineBorder(Color.black,1));
		gender.setBorder	(new LineBorder(Color.black,1));
		
		
		
		
		frame.setTitle("회원가입");
		frame.setVisible(true);
		frame.setSize(900,600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		
		contentPane.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	
		// button -> back  로그인화면으로 돌아가기 
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login log = new Login();
				
			}
			
		});
		// okayy 회원가입완료 처리, txt파일에 회원정보 저장처리 
		okay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("UserInfo.txt",true));
					bw.write(idTxt.getText() + "/");
					bw.write(pw1F.getText() + "/");
					bw.write(nameTxt.getText() + "/");
					bw.write(ageTxt.getText() + "/");
					bw.write(genderTxt.getText() + "/");
					bw.close();
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					Login log = new Login();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			
		});
	
	
	
	
	
	}
}
