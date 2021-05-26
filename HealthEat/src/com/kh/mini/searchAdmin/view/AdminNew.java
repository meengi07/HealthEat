package com.kh.mini.searchAdmin.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTextField;

import com.sy.mvc.controller.NutriManager2;

public class AdminNew extends JFrame {
		
	private AdminMode am = new AdminMode();
	
	//관리자 모드 - 영양제 신규 등록
	public AdminNew() {
		//창 이름
		JFrame frame = new JFrame("영양제 신규 등록");
		
		//패널
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 840, 840/12*9);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		//정보 입력창
		JLabel title = new JLabel("영양제 신규 등록");
		title.setBounds(150, 40, 200, 30);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
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
		
		//버튼
		JButton reset = new JButton("모두 지우기");
		reset.setBounds(50, 470, 120, 50);
		
		JButton register = new JButton("등  록");
		register.setBounds(200, 440, 200, 50);
		
		JButton exit = new JButton("돌아가기");
		exit.setBounds(200, 500, 200, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panel.add(title);
		panel.add(lab1);
		panel.add(lab2);
		panel.add(lab3);
		panel.add(lab4);
		panel.add(lab5);
		panel.add(lab6);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		panel.add(text4);
		panel.add(text5);
		panel.add(text6);
		panel.add(reset);
		panel.add(register);
		panel.add(exit);
		
		//event 넣기
		//초기화 버튼 - 입력된 내용 모두 지우기
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//팝업창 확인 후 초기화
				int answer = JOptionPane.showConfirmDialog(null, "입력된 내용을 모두 지우시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					text1.setText("");
					text2.setText("");
					text3.setText("");
					text4.setText("");
					text5.setText("");
					text6.setText("");
					JOptionPane.showMessageDialog(null, "입력된 내용을 모두 지웠습니다.");
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					
				}
			}
		});
		
		//등록 버튼 - nutriList에 추가
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//팝업창
				int answer = JOptionPane.showConfirmDialog(null, "등록 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					BufferedWriter bw = null;
					//txt파일에 데이터 넣기
					try {
						bw = new BufferedWriter(new FileWriter("nutriList.txt", true));
						bw.write(text1.getText() + "/");
						bw.write(text2.getText() + "/");
						bw.write(text3.getText() + "/");
						bw.write(text4.getText() + "/");
						bw.write(text5.getText() + "/");
						bw.write(text6.getText() + "/");
						bw.write("0/\n"); //인기도(조회수) - 기본 0으로 셋팅
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							bw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
					
					//등록 후 전체조회 화면(AdminMode)으로 자동 전환
					panel.setVisible(false);
					AdminMode flip = new AdminMode();
					flip.setVisible(true);
					frame.dispose();					
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					
				}
			}
		});

		//돌아가기 버튼 - AdminMode 클래스 메인으로 돌아가기
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//클래스 화면 전환
				panel.setVisible(false);
				
				AdminMode flip = new AdminMode();
				flip.setVisible(true);
				frame.dispose();
			}
		});
		
		//프레임에 패널 넣기
		frame.add(panel);
		
		//프레임 기본 설정
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null); //화면 가운데 뜨게
		frame.setResizable(false); //false : 화면크기 조정 안되도록// true : 화면크기 조정되도록
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
