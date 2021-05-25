package com.kh.mini.TaeHyeon.view;

import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.control.ComboBox;
import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class mainPanel extends JFrame implements ActionListener {

	// FunctionPanel fp = new FunctionPanel();

	private JPanel mainPanel = new JPanel(); // 복용일기 메인 메뉴
	private JPanel writePanel = new JPanel(); // 복용일기 작성 페이지
	private JPanel seePanel = new JPanel(); // 뵥용일기 작성된 내용 확인
	private TextField textField1, textField2, textField3, textField4, byTextField1, byTextField2;
	private TextArea textArea1;
	private JCheckBox[] checkWeek = new JCheckBox[7];
	public mainPanel() {
		// 메인 메뉴 패널 활성화
		mainPanel.setVisible(true);
		writePanel.setVisible(false);
		seePanel.setVisible(false);

	}

	public JPanel mainPanelUI() {

		mainPanel.setLayout(null);
		mainPanel.setBounds(10, 50, 500, 700);

		JButton btn1 = new JButton("복용 일기 작성하기");
		JButton btn2 = new JButton("돌아가기");// 메인 선택 창으로 돌아가기 버튼

		btn1.setBounds(200, 500, 200, 40); // 복용일기 작성하기 버튼 위치 및 크기
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainPanel.setVisible(false);
				writePanel.setVisible(true); // 복용 일기 작성 페이지 활성화

			}
		});

		btn2.setBounds(250, 600, 100, 40);
		// 해당 버튼을 누렀을 시 메인 선택창으로 돌아가는 액션리스너를 추가

		JLabel showTitle = new JLabel("등록된 영양제 복용 일기");

		mainPanel.add(btn1);
		mainPanel.add(btn2);

		return mainPanel;

	}

	// 복용일기 UI 설정하기
	public JPanel writeJPanelUI() {

		String[] eatCount = { "1번", "2번", "3번" };
		String[] weekDays = { "월", "화", "수", "목", "금", "토", "일" };

		writePanel.setLayout(null);
		writePanel.setBounds(0, 0, 600, 800);

		JLabel labelDiary1 = new JLabel("영양제 복용 일기 작성");
		JLabel labelDiary2 = new JLabel("복용 타입을 선택해주세요");
		JLabel labelDiary3 = new JLabel("하루에 몇번 복용하세요?");
		JLabel labelDiary4 = new JLabel("영양제에 대한 메모를 입력해주세요");

		// 복용 시간 라벨 배열 생성
		JLabel[] labelDiaryArr = { new JLabel("복용 시간1"), new JLabel("복용 시간2"), new JLabel("복용 시간3") };

		JComboBox combo = new JComboBox(eatCount); // 콤보 박스 생성

		JCheckBox week = new JCheckBox("요일별"); // 체크박스 생성
		JCheckBox byCycle = new JCheckBox("주기별");
		
		
		// 요일별 체크시 요일 체크 박스
		//JCheckBox[] checkWeek = { new JCheckBox("월"), new JCheckBox("화"), new JCheckBox("수"), new JCheckBox("목"),
				//new JCheckBox("금"), new JCheckBox("토"), new JCheckBox("일"), };
		//checkWeek = {new Checkbox("월"), new Checkbox("화"), new Checkbox("수"),
		//		new Checkbox("목"), new Checkbox("금"), new Checkbox("토"), new Checkbox("일")};
		checkWeek[0] = new JCheckBox(weekDays[0]);
		checkWeek[1] = new JCheckBox(weekDays[1]);
		checkWeek[2] = new JCheckBox(weekDays[2]);
		checkWeek[3] = new JCheckBox(weekDays[3]);
		checkWeek[4] = new JCheckBox(weekDays[4]);
		checkWeek[5] = new JCheckBox(weekDays[5]);
		checkWeek[6] = new JCheckBox(weekDays[6]);
		
		
		JLabel bylabelDiary1 = new JLabel("시작날짜를 입력");
		JLabel bylabelDiary2 = new JLabel("복용주기를 입력");

		// 버튼 추가
		JButton backBtn = new JButton("돌아가기");
		JButton saveBtn = new JButton("등록하기");
		saveBtn.addActionListener(this); // 등록하기 버튼 활성화

		// 텍스트 필드 추가
		textField1 = new TextField(15);
		textField2 = new TextField(15);
		textField3 = new TextField(15);
		textField4 = new TextField(15);

		byTextField1 = new TextField(15);
		byTextField2 = new TextField(15);

		// 텍스트 에이러 추가
		textArea1 = new TextArea();

		// 위치 조정

		labelDiary1.setBounds(100, 30, 200, 40);
		labelDiary2.setBounds(100, 120, 200, 40);
		labelDiary3.setBounds(20, 270, 200, 40);
		labelDiary4.setBounds(150, 470, 250, 40);

		labelDiaryArr[0].setBounds(150, 300, 100, 40);
		labelDiaryArr[1].setBounds(150, 350, 100, 40);
		labelDiaryArr[2].setBounds(150, 400, 100, 40);

		textField1.setBounds(100, 80, 250, 20);
		textField2.setBounds(250, 310, 250, 20);
		textField3.setBounds(250, 360, 250, 20);
		textField4.setBounds(250, 410, 250, 20);

		textArea1.setBounds(75, 530, 400, 200);

		combo.setBounds(20, 300, 100, 40); // 복용 횟수 선택 콤보 박스

		week.setBounds(100, 150, 80, 40);
		byCycle.setBounds(350, 150, 80, 40);

		checkWeek[0].setBounds(30, 180, 70, 100);
		checkWeek[1].setBounds(100, 180, 70, 100);
		checkWeek[2].setBounds(170, 180, 70, 100);
		checkWeek[3].setBounds(240, 180, 70, 100);
		checkWeek[4].setBounds(310, 180, 70, 100);
		checkWeek[5].setBounds(380, 180, 70, 100);
		checkWeek[6].setBounds(450, 180, 70, 100);

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
					writePanel.add(labelDiaryArr[0]);
					writePanel.add(textField2);
					writePanel.setBounds(0, 0, 700, 900);

					labelDiaryArr[0].setVisible(true);
					labelDiaryArr[1].setVisible(false);
					labelDiaryArr[2].setVisible(false);
					textField2.setVisible(true);
					textField3.setVisible(false);
					textField4.setVisible(false);

				} else if (index == 1) {
					writePanel.add(labelDiaryArr[0]);
					writePanel.add(textField2);
					writePanel.setBounds(0, 0, 700, 900);

					writePanel.add(labelDiaryArr[1]);
					writePanel.add(textField3);
					writePanel.setBounds(0, 0, 750, 900);

					labelDiaryArr[0].setVisible(true);
					labelDiaryArr[1].setVisible(true);
					labelDiaryArr[2].setVisible(false);
					textField2.setVisible(true);
					textField3.setVisible(true);
					textField4.setVisible(false);

				} else {
					writePanel.add(labelDiaryArr[0]);
					writePanel.add(textField2);
					writePanel.setBounds(0, 0, 700, 900);

					writePanel.add(labelDiaryArr[1]);
					writePanel.add(textField3);
					writePanel.setBounds(0, 0, 750, 900);

					writePanel.add(labelDiaryArr[2]);
					writePanel.add(textField4);
					writePanel.setBounds(0, 0, 800, 900);

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

					for (int i = 0; i < checkWeek.length; i++) {
						writePanel.add(checkWeek[i]);
						checkWeek[i].setVisible(true);
					}

					writePanel.setBounds(0, 0, 700, 900);

				} else {

					for (int i = 0; i < checkWeek.length; i++) {
						checkWeek[i].setVisible(false);
					}

					writePanel.setBounds(0, 0, 700, 900);

				}

			}
		});
		// 요일 선택시 String 요일 문자열 받아오기
		
		for (int i = 0; i < checkWeek.length; i++) {
			checkWeek[i].addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						
						if(e.getItem()==checkWeek[0]) {
							System.out.println(weekDays[0]);
						}else if(e.getItem()==checkWeek[1]) {
							System.out.println(weekDays[1]);
						}else if(e.getItem()==checkWeek[2]) {
							System.out.println(weekDays[2]);
						}else if(e.getItem()==checkWeek[3]) {
							System.out.println(weekDays[3]);
						}else if(e.getItem()==checkWeek[4]) {
							System.out.println(weekDays[4]);
						}else if(e.getItem()==checkWeek[5]) {
							System.out.println(weekDays[5]);
						}else  {
							System.out.println(weekDays[6]);
						}
						
					}

				}

			});
		}
			
		// 주기별 선택 시 주기별 입력 등장
		byCycle.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					writePanel.add(bylabelDiary1);
					writePanel.add(bylabelDiary2);
					writePanel.add(byTextField1);
					writePanel.add(byTextField2);
					bylabelDiary1.setVisible(true);
					bylabelDiary2.setVisible(true);
					byTextField1.setVisible(true);
					byTextField2.setVisible(true);
					writePanel.setBounds(0, 0, 700, 900);
				} else {
					bylabelDiary1.setVisible(false);
					bylabelDiary2.setVisible(false);
					byTextField1.setVisible(false);
					byTextField2.setVisible(false);
					writePanel.setBounds(0, 0, 700, 900);
				}
			}
		});

		// 돌아가기 버튼 활성화
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				writePanel.setVisible(false);
				mainPanel.setVisible(true);

			}
		});

		// 저장하기 팝업 창 띄우기

		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int cfm1 = JOptionPane.showConfirmDialog(null, "복용 일기 등록하시겠습니까?", "영양제 복용 일기",
						JOptionPane.OK_CANCEL_OPTION);

				if (cfm1 == JOptionPane.YES_OPTION) {
					mainPanel.setVisible(true);
					writePanel.setVisible(false);
				}
			}
		});

		writePanel.add(labelDiary1);
		writePanel.add(textField1);
		writePanel.add(labelDiary2);
		writePanel.add(labelDiary3);
		writePanel.add(labelDiary4);
		writePanel.add(textArea1);
		writePanel.add(week);
		writePanel.add(byCycle);
		writePanel.add(combo);
		writePanel.add(backBtn);
		writePanel.add(saveBtn);

		return writePanel;

	}
	// 복용일기 등록에서 입력된 값을 text 파일에 저장
	@Override
	public void actionPerformed(ActionEvent e) {

		// String path = "C:\\DiaryDataTextFile";
		// 현재 날짜 가져오기
		Date today = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String ftToday = ft.format(today);
		String[] weekDays = { "월", "화", "수", "목", "금", "토", "일" };
		
		try {
			File tempDir = new File("C:\\new");
			if (!tempDir.exists()) // 경로에 폴더가 존재하지 않으면
				tempDir.mkdirs(); // 물리적으로 폴더 생성
			// File dirFile = new File(tempDir + File.separator + "\saveDiay.txt");
			//File[] fileList = tempDir.listFiles();

			// 파일명과 같은 파일명이 있을 경우 덮어쓰기 판단
			// FileWriter fw = new FileWriter("saveDiary.txt", true);

			FileWriter fw = new FileWriter(tempDir + File.separator + ftToday + ".txt", true);

			BufferedWriter bf = new BufferedWriter(fw);
			
			
			
			bf.write(textField1.getText() + " ");
			bf.write(textField2.getText() + " ");
			bf.write(textField3.getText() + " ");
			bf.write(textField4.getText() + " ");
			bf.write(byTextField1.getText() + " ");
			bf.write(byTextField2.getText() + " ");
			
			
			/*
			bf.write(checkWeek[0].getText() + " ");
			bf.write(checkWeek[1].getText() + " ");
			bf.write(checkWeek[2].getText() + " ");
			bf.write(checkWeek[3].getText() + " ");
			bf.write(checkWeek[4].getText() + " ");
			bf.write(checkWeek[5].getText() + " ");
			bf.write(checkWeek[6].getText() + " ");
			*/

			bf.write(textArea1.getText() + "\n"); // 마지막 입력후 한줄은 내린다
			
			
			bf.close(); // 저장 후 텍스트 필드의 값을 가져온 자원들을 해제한다.
			
			for(int i = 0; i < checkWeek.length; i++) {
				checkWeek[i].setText("");
			}
			
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			byTextField1.setText("");
			byTextField2.setText("");
			textArea1.setText("");

			FileReader fr = new FileReader("C:\\new\\" + ftToday + ".txt"); // String 형으로 파일을 불러온다.
			BufferedReader br = new BufferedReader(fr); // 한줄씩 일기 위해(빠른속도로 읽기위해)
			// 파일 이름을 현제 Date 값으로 받아서 이름을 짓자
			String str = null; // while의 조건부

			while ((str = br.readLine()) != null) {
				System.out.println(str); // null이 될때까지 한줄씩 읽어온다.

			}
			br.close(); // 읽어온 자원들을 해제한다.
		} catch (FileNotFoundException e1) {
			System.out.println("파일이 존재하지 않네용!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
