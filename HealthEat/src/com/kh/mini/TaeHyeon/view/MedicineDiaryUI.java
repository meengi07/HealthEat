package com.kh.mini.TaeHyeon;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MedicineDiaryUI extends JFrame{
// git에 있는 복용 일기 클래스
public MedicineDiaryUI() {
		
		String[] eatCount = {"1번","2번","3번"};
	
		this.setTitle("복용 일기 메인메뉴");
		this.setBounds(600, 100, 600, 800);
		//this.setSize(600, 800);
		this.setLayout(null);
		
		JPanel panel1 = new JPanel(); // 복용일기 메인 메뉴
		JPanel panel2 = new JPanel(); // 복용일기 작성 페이지
		JPanel panel3 = new JPanel(); // 뵥용일기 작성_요일별 체크 페이지
		JPanel panel4 = new JPanel(); // 복용일기 작성_주기별 체크 페이지
		
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		
		//복용 일기 목록 확인 코드 추가
		
		
		
		//labelTitle.setBounds(50, 10, 50, 150);
		
		//복용 일기 메인 페이지 설정하기
		
		JButton btn1 = new JButton("복용 일기 작성하기");
		JButton btn2 = new JButton("돌아가기");//메인 선택 창으로 돌아가기 버튼
		
		panel1.setLayout(null);
		panel1.setBounds(10, 50, 500, 700);
		btn1.setBounds(200, 500, 200, 40); // 복용일기 작성하기 버튼 위치 및 크기
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false); // 첫 화면 가리기
				panel2.setVisible(true); // 복용 일기 작성하기 페이지 활성화
				panel3.setVisible(false);
				panel4.setVisible(false);
				
			}
		});
		
		panel1.add(btn1);
		panel1.add(btn2);
		btn2.setBounds(250, 600, 100, 40);
		// 해당 버튼을 누렀을 시 메인 선택창으로 돌아가는 액션리스너를 추가
		
		// 복용 일기 작성하는 UI
		
		panel2.setLayout(null);
		panel2.setBounds(0, 0, 600, 800);
		JLabel labelDiary1 = new JLabel("영양제 복용 일기 작성");
		JLabel labelDiary2 = new JLabel("복용 타입을 선택해주세요");
		JLabel labelDiary3 = new JLabel("하루에 몇번 복용하세요?");
		JLabel labelDiary4 = new JLabel("영양제에 대한 메모를 입력해주세요");
		
		// 복용 시간 라벨 배열 생성
		JLabel[] labelDiaryArr = {new JLabel("복용 시간1"),new JLabel("복용 시간2"),new JLabel("복용 시간3")};
	
		
		JTextField textField1 = new JTextField(); // 텍스트 필드 생성
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();
		JTextField textField4 = new JTextField();
		JTextField textField5 = new JTextField();
		
		JTextArea textArea1 = new JTextArea(); // 메모 내용 적으로 텍스트에리어 생성
		
		JComboBox combo = new JComboBox(eatCount); // 콤보 박스 생성
		
		JCheckBox week = new JCheckBox("요일별"); // 체크박스 생성
		JCheckBox byCycle = new JCheckBox("주기별");
		
		
		//panel2.add(new JLabel("영양제 복용 일기 작성"));
		labelDiary1.setBounds(100, 30, 200, 40);
		labelDiary2.setBounds(100, 150, 200, 40);
		labelDiary3.setBounds(20, 270, 200, 40);
		labelDiary4.setBounds(150, 500, 250, 40);
		
		labelDiaryArr[0].setBounds(150, 300, 200, 40);
		labelDiaryArr[1].setBounds(150, 350, 200, 40);
		labelDiaryArr[2].setBounds(150, 400, 200, 40);
		
		textField1.setBounds(100, 80, 250, 20);
		textField2.setBounds(100, 200, 250, 20);
		textField3.setBounds(250, 310, 250, 20);
		textField4.setBounds(250, 360, 250, 20);
		textField5.setBounds(250, 410, 250, 20);
		
		textArea1.setBounds(75, 530, 400, 200);
		
		combo.setBounds(20, 300, 100, 40); // 복용 횟수 선택 콤보 박스
		
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int index = cb.getSelectedIndex();
				
				if(index == 0) {
					panel2.add(labelDiaryArr[0]);
					panel2.add(textField3);
					panel2.setBounds(0, 0, 700, 900);
					
				}else if(index == 1) {
					panel2.add(labelDiaryArr[0]);
					panel2.add(textField3);
					panel2.setBounds(0, 0, 700, 900);
					
					panel2.add(labelDiaryArr[1]);
					panel2.add(textField4);
					panel2.setBounds(0, 0, 750, 900);
					
				}else {
					panel2.add(labelDiaryArr[0]);
					panel2.add(textField3);
					panel2.setBounds(0, 0, 700, 900);
					
					panel2.add(labelDiaryArr[1]);
					panel2.add(textField4);
					panel2.setBounds(0, 0, 750, 900);
					
					panel2.add(labelDiaryArr[2]);
					panel2.add(textField5);
					panel2.setBounds(0, 0, 800, 900);
					;
				}
								
			}
		});
		
		
		
		panel2.add(labelDiary1);
		panel2.add(textField1);
		panel2.add(labelDiary2);
		panel2.add(textField2);
		panel2.add(labelDiary3);
		panel2.add(labelDiary4);
		panel2.add(textArea1);
		panel2.add(combo);
		
		
		
		
		this.add(panel1);
		this.add(panel2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		
		new MedicineDiaryUI();
		
	}

}
