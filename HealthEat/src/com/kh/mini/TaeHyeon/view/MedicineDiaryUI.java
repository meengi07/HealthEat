package com.kh.mini.TaeHyeon.view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MedicineDiaryUI extends JFrame{
// git에 있는 복용 일기 클래스
	
	public MedicineDiaryUI() {

		String[] eatCount = { "1번", "2번", "3번" };
		
		
		this.setTitle("복용 일기 메인메뉴");
		this.setBounds(600, 100, 600, 900);
		// this.setSize(600, 800);
		this.setLayout(null);

		JPanel panel1 = new JPanel(); // 복용일기 메인 메뉴
		JPanel panel2 = new JPanel(); // 복용일기 작성 페이지
		JPanel panel3 = new JPanel(); // 뵥용일기 작성_요일별 체크 페이지
		JPanel panel4 = new JPanel(); // 복용일기 작성_주기별 체크 페이지

		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);

		// 복용 일기 목록 확인 코드 추가

		// labelTitle.setBounds(50, 10, 50, 150);

		// 복용 일기 메인 페이지 설정하기

		JButton btn1 = new JButton("복용 일기 작성하기");
		JButton btn2 = new JButton("돌아가기");// 메인 선택 창으로 돌아가기 버튼

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
		JLabel[] labelDiaryArr = { new JLabel("복용 시간1"), new JLabel("복용 시간2"), new JLabel("복용 시간3") };

		JTextField textField1 = new JTextField(); // 텍스트 필드 생성
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();
		JTextField textField4 = new JTextField();

		JTextArea textArea1 = new JTextArea(); // 메모 내용 적으로 텍스트에리어 생성

		JComboBox combo = new JComboBox(eatCount); // 콤보 박스 생성

		JCheckBox week = new JCheckBox("요일별"); // 체크박스 생성
		JCheckBox byCycle = new JCheckBox("주기별");

		// 요일별 체크시 요일 체크 박스
		JCheckBox week1 = new JCheckBox("월");
		JCheckBox week2 = new JCheckBox("화");
		JCheckBox week3 = new JCheckBox("수");
		JCheckBox week4 = new JCheckBox("목");
		JCheckBox week5 = new JCheckBox("금");
		JCheckBox week6 = new JCheckBox("토");
		JCheckBox week7 = new JCheckBox("일");

		// 주기별 체크시 텍스트 필드
		JLabel bylabelDiary1 = new JLabel("시작날짜를 입력");
		JLabel bylabelDiary2 = new JLabel("복용주기를 입력");
		JTextField byTextField1 = new JTextField(); // 시작날짜 복용주기 입력 텍스트 필드
		JTextField byTextField2 = new JTextField();

		// 버튼 추가
		JButton backBtn = new JButton("돌아가기");
		JButton saveBtn = new JButton("등록하기");

		// 위치 조정

		labelDiary1.setBounds(100, 30, 200, 40);
		labelDiary2.setBounds(100, 120, 200, 40);
		labelDiary3.setBounds(20, 270, 200, 40);
		labelDiary4.setBounds(150, 500, 250, 40);

		labelDiaryArr[0].setBounds(150, 300, 200, 40);
		labelDiaryArr[1].setBounds(150, 350, 200, 40);
		labelDiaryArr[2].setBounds(150, 400, 200, 40);

		textField1.setBounds(100, 80, 250, 20);
		textField2.setBounds(250, 310, 250, 20);
		textField3.setBounds(250, 360, 250, 20);
		textField4.setBounds(250, 410, 250, 20);

		textArea1.setBounds(75, 530, 400, 200);

		combo.setBounds(20, 300, 100, 40); // 복용 횟수 선택 콤보 박스

		week.setBounds(100, 150, 80, 40);
		byCycle.setBounds(350, 150, 80, 40);

		week1.setBounds(30, 200, 50, 40);
		week2.setBounds(80, 200, 50, 40);
		week3.setBounds(130, 200, 50, 40);
		week4.setBounds(180, 200, 50, 40);
		week5.setBounds(230, 200, 50, 40);
		week6.setBounds(280, 200, 50, 40);
		week7.setBounds(330, 200, 50, 40);

		bylabelDiary1.setBounds(80, 180, 200, 40);
		bylabelDiary2.setBounds(300, 180, 200, 40);
		byTextField1.setBounds(80, 220, 200, 20);
		byTextField2.setBounds(300, 220, 200, 20);

		backBtn.setBounds(400, 750, 150, 50);
		saveBtn.setBounds(180, 750, 150, 50);

		// 복용 주기 회수 선택
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();

				if (index == 0) {
					panel2.add(labelDiaryArr[0]);
					panel2.add(textField2);
					panel2.setBounds(0, 0, 700, 900);

					labelDiaryArr[0].setVisible(true);
					labelDiaryArr[1].setVisible(false);
					labelDiaryArr[2].setVisible(false);
					textField2.setVisible(true);
					textField3.setVisible(false);
					textField4.setVisible(false);

				} else if (index == 1) {
					panel2.add(labelDiaryArr[0]);
					panel2.add(textField2);
					panel2.setBounds(0, 0, 700, 900);

					panel2.add(labelDiaryArr[1]);
					panel2.add(textField3);
					panel2.setBounds(0, 0, 750, 900);

					labelDiaryArr[0].setVisible(true);
					labelDiaryArr[1].setVisible(true);
					labelDiaryArr[2].setVisible(false);
					textField2.setVisible(true);
					textField3.setVisible(true);
					textField4.setVisible(false);

				} else {
					panel2.add(labelDiaryArr[0]);
					panel2.add(textField2);
					panel2.setBounds(0, 0, 700, 900);

					panel2.add(labelDiaryArr[1]);
					panel2.add(textField3);
					panel2.setBounds(0, 0, 750, 900);

					panel2.add(labelDiaryArr[2]);
					panel2.add(textField4);
					panel2.setBounds(0, 0, 800, 900);

					labelDiaryArr[0].setVisible(true);
					labelDiaryArr[1].setVisible(true);
					labelDiaryArr[2].setVisible(true);
					textField2.setVisible(true);
					textField3.setVisible(true);
					textField4.setVisible(true);
				}

			}
		});
		// 요일별 선택 시 요일 등장
		week.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panel2.add(week1);
					panel2.add(week2);
					panel2.add(week3);
					panel2.add(week4);
					panel2.add(week5);
					panel2.add(week6);
					panel2.add(week7);
					week1.setVisible(true);
					week2.setVisible(true);
					week3.setVisible(true);
					week4.setVisible(true);
					week5.setVisible(true);
					week6.setVisible(true);
					week7.setVisible(true);
					panel2.setBounds(0, 0, 700, 900);
				} else {
					week1.setVisible(false);
					week2.setVisible(false);
					week3.setVisible(false);
					week4.setVisible(false);
					week5.setVisible(false);
					week6.setVisible(false);
					week7.setVisible(false);
					panel2.setBounds(0, 0, 700, 900);
				}

			}
		});

		// 주기별 선택 시 주기별 입력 등장
		byCycle.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					panel2.add(bylabelDiary1);
					panel2.add(bylabelDiary2);
					panel2.add(byTextField1);
					panel2.add(byTextField2);
					bylabelDiary1.setVisible(true);
					bylabelDiary2.setVisible(true);
					byTextField1.setVisible(true);
					byTextField2.setVisible(true);
					panel2.setBounds(0, 0, 700, 900);
				} else {
					bylabelDiary1.setVisible(false);
					bylabelDiary2.setVisible(false);
					byTextField1.setVisible(false);
					byTextField2.setVisible(false);
					panel2.setBounds(0, 0, 700, 900);
				}
			}
		});

		// 돌아가기 버튼 활성화
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panel2.setVisible(false);
				panel1.setVisible(true);

			}
		});

		// 저장하기 팝업 창 띄우기

		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int cfm1 = JOptionPane.showConfirmDialog(null, "복용 일기 등록하시겠습니까?", "영양제 복용 일기",
						JOptionPane.OK_CANCEL_OPTION);

				if (cfm1 == JOptionPane.YES_OPTION) {
					panel1.setVisible(true);
					panel2.setVisible(false);
				}
			}
		});
		
		
		
		panel2.add(labelDiary1);
		panel2.add(textField1);
		panel2.add(labelDiary2);
		panel2.add(labelDiary3);
		panel2.add(labelDiary4);
		panel2.add(textArea1);
		panel2.add(week);
		panel2.add(byCycle);
		panel2.add(combo);
		panel2.add(backBtn);
		panel2.add(saveBtn);

		this.add(panel1);
		this.add(panel2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}



	public static void main(String[] args) {

		new MedicineDiaryUI();

	}

}
