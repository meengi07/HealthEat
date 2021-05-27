package com.kh.mini.Member.view.menuBar;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.Member.view.front.Login;

public class ChangeInfo extends Frame {

	//private UserInfo ui = new UserInfo();
	Login log = new Login();
	private String[] strArr = new String[5];
	
	
	public ChangeInfo() {
		//회원정보 수정 및 팝업 
		//Login log = new Login();
		//String str = log.strArr()
		//strArr = log.getArr();
		//System.out.println(strArr[1]);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		//프레임 크기 및 위치 설정 
		frame.setTitle("회원정보 수정");
		frame.setVisible(true);
		frame.setSize(900,600);
		frame.setLocationRelativeTo(null); //화면 중앙에 띄움 
		frame.setResizable(false); // 창 크기 고정 (불변)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
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
		
		if( !pwTxt1.getText().equals(pwTxt2.getText()) ) {
			JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
		}
		
		//회원정보 수정하고 저장 
		chgBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String dum = "" ;
					String str ;
					String[] arr = new String[5]; //기존 txt 
					strArr = new String[5]; //수정 txt 
					BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));
					BufferedWriter bw = new BufferedWriter(new FileWriter("UserInfo.txt",true));
					String pw = pwTxt2.getText();
					
					
					while((str=br.readLine()) !=null) {
						arr = str.split("/");		
					}
					
					for(int i = 0; i < strArr.length; i++) {
						if(i == 1) {
							strArr[i] = pw;
						}
						
						if(i != 1) {
							strArr[i] = arr[i];
						}
						
					}
					for(int i = 0; i < strArr.length; i++) {
						dum += strArr[i];
						if(i != 4) {
							dum +="/";
						}
						if(i == 4) {
							dum += "\n";
						}
					}
					//BufferedWriter bw2 = new BufferedWriter(new FileWriter("UserInfo.txt",true));
					//bw.write("\n");
					
					bw.write(dum);
					bw.close();
					br.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				
				}
				
				JOptionPane.showMessageDialog(null, "내용이 변경되었습니다.");
				try {
					UserInfo ui = new UserInfo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		//돌아가기 버튼 
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					UserInfo ui = new UserInfo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		
	}
}
