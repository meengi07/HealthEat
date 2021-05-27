package com.kh.mini.Member.view.front;

import java.awt.Color;
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
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.kh.mini.Member.view.menuBar.UserInfo;
import com.kh.mini.searchAdmin.view.AdminMode;

public class Login extends Frame {
//로그인 화면 뷰어, 프레임과 패널을 구현해서 로그인창 만들기. 
	private String[] arr = new String[5];
	//ArrayList arr = new ArrayList<String[]>();
	//private String[] krr= new String[5];
	private JPanel panel1 = new JPanel();
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
						//뭐
						
						if(idTxt.getText().equals(arr[0]) && pwTxt.getText().equals(arr[1])) {
							JOptionPane.showMessageDialog(null, "로그인에 성공했습니다. ");
							MenuBar mb = new MenuBar();
						}else {
							JOptionPane.showMessageDialog(null, "로그인에 실패했습니다. ");
						};
						panel1.revalidate();
						panel1.repaint();
						
						br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
 			
			
 		});
 		System.out.println(arr[0]); // 결과값 null뜸. 
 		sigBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignIn sign = new SignIn();
				frame.setVisible(false);
			}
 			
 		});
 		masterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AdminMode am = new AdminMode();
			}
 			
 		});
 		

	}

		
		public void UserInfo() {
			
			String[] srr = arr;
			System.out.println(arr[1]);
			System.out.println(srr[1]);
			//System.out.println(krr[1]);
			
			//회원님의 개인정보입니다. 
			//이름 나이 성별 출력 후 
			//버튼 -> 회원정보수정 , 회원탈퇴하기, 돌아가기 
			//패널, 버튼만들기 
			
			//로그인한 유저정보 가져옴 
			System.out.println("arr의 값은 ? : "+arr[2]);
			JFrame frame = new JFrame();
			//JPanel panel = new JPanel();
			
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
			
			panel1.setLayout(null);
			
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
			name.setText(arr[2]);	// 회원이름 출력 
			age.setText(arr[3]);	// 나이 출력 
			gender.setText(arr[4]); // 성별 출력 
			//회원정보수정 화면으로 이동 버튼 
			
			panel1.add(info);
			panel1.add(nameLabel);
			panel1.add(name);
			panel1.add(ageLabel);
			panel1.add(age);
			panel1.add(genderLabel);
			panel1.add(gender);
			panel1.add(changeInfo);
			panel1.add(deleteInfo);
			panel1.add(back);
			//panel.repaint();
			
			frame.add(panel1);
			
			changeInfo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ChangeInfo();
					
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

	
	
	public void ChangeInfo() {
		//회원정보 수정 및 팝업 
		//Login log = new Login();
		//String str = log.strArr()
		
		
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
					arr = new String[5]; //수정 txt 
					BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));
					BufferedWriter bw = new BufferedWriter(new FileWriter("UserInfo.txt",true));
					String pw = pwTxt2.getText();
					
					
					while((str=br.readLine()) !=null) {
						arr = str.split("/");		
					}
					
					for(int i = 0; i < arr.length; i++) {
						if(i == 1) {
							arr[i] = pw;
						}
						
						if(i != 1) {
							arr[i] = arr[i];
						}
						
					}
					for(int i = 0; i < arr.length; i++) {
						dum += arr[i];
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
	
