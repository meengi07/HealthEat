package com.kh.mini.TaeHyeon.view;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;

public class mainPanel extends JFrame implements ActionListener {

	private JPanel mainPanel = new JPanel(); // 복용일기 메인 메뉴.
	private JPanel writePanel = new JPanel(); // 복용일기 작성 페이지
	private JPanel seePanel = new JPanel(); // 뵥용일기 작성된 내용 확인
	private TextField textField1, textField2, textField3, textField4, byTextField1, byTextField2;
	private TextArea textArea1;
	private JTextArea textArea2, textArea3, textArea4;
	private JButton btn3, btn4, btn5, btn6, btn7;
	private JCheckBox[] checkWeek = new JCheckBox[7];
	private String[] weekDays = { "월", "화", "수", "목", "금", "토", "일" };
	private String[] count = new String[7];
	private JTable table;
	private String[] header = new String[] { "제목", "작성 일자", "내용" };
	private String title, days, text;
	
	// 현재 날짜 가져오기
	Date today = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
	String ftToday = ft.format(today);
	
	// table 변경 방지!!!!!!!
	DefaultTableModel model = new DefaultTableModel(header, 0) {
		boolean isCellImmutable(int header, int data) {
			// 테이블 내용 수정 방지
			return false;
		}
	};
	
	// table에서 선택한 행을 담을 변수
	int row = 0;

	public mainPanel() {
		// 메인 메뉴 패널 활성화
		mainPanel.setVisible(true);
		writePanel.setVisible(false);
		seePanel.setVisible(false);
		
		this.setLayout(null);
		this.setTitle("복용 일기 메인메뉴");
		this.setBounds(600, 100, 900, 600);
		// this.setSize(600, 800);
		this.setResizable(false); // 사이즈 수정 불가
		
		this.add(seeJPanel());
		this.add(mainPanelUI());
		this.add(writeJPanelUI());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

	}
	// 메인 UI 패널
	public JPanel mainPanelUI() {

		mainPanel.setLayout(null);
		mainPanel.setBounds(10, 50, 900, 600); 

		JButton btn1 = new JButton("복용 일기 작성하기");
		JButton btn2 = new JButton("돌아가기");// 메인 선택 창으로 돌아가기 버튼
		btn3 = new JButton("삭제");
		btn4 = new JButton("확인");
		
		btn1.setBounds(650, 100, 200, 40); // 복용일기 작성하기 버튼 위치 및 크기
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainPanel.setVisible(false);
				writePanel.setVisible(true); // 복용 일기 작성 페이지 활성화

			}
		});
		
		// 해당 버튼을 누렀을 시 메인 선택창으로 돌아가는 액션리스너를 추가
		btn2.setBounds(700, 430, 100, 40);

		// 삭제 버튼 위치
		btn3.setBounds(200, 400, 70, 50);
		
		// 수정하기 기능 코드
		btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String[] input = new String[3];
				
				mainPanel.setVisible(false);
				seePanel.setVisible(true);
				
				model.setValueAt(textArea2.getText(), row, 0);
				model.setValueAt(textArea3.getText(), row, 1);
				model.setValueAt(textArea4.getText(), row, 2);
				
				System.out.println(model);
				System.out.println(row);
				// 입력된 텍스트 불러오기
				textArea2.setText("");
				textArea3.setText("");
				textArea4.setText("");
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("saveDiary.txt"));
					for(int i = 0; i < table.getRowCount(); i++) {
						for(int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getValueAt(i, j).toString() + ",");
						}
						bw.newLine();
					}
					
					bw.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// 수정확인 팝업창 띄우기
				int answer = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "ok", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					System.out.println("수정됨");
					JOptionPane.showMessageDialog(null, "수정되었습니다");
					
					seePanel.setVisible(false);
					mainPanel.setVisible(true);
					
				}
			}
		});
		

		// 확인하기 버튼 위치
		btn4.setBounds(300, 400, 70, 50);

		// 저장일기 table 생성
		table = new JTable(model);
		table.setRowHeight(25); // 행 높이 25로 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(250); // 0번째 열 너비 100으로 조정
		table.setModel(model);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 40, 550, 300);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		table.revalidate();
		table.repaint();

		showAllList(); // saveDiary.txt 정보 출력 메소드

		// table 마우스 클릭 시 객체 선택하기
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
			}

		});

		// table 목록에서 선택하여 더블 클릭 시 상세 조회로 이동
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow(); // 선택한 셀의 행번호
				String a = (String) model.getValueAt(row, 0); // 첫번쩨 행에서 몇번짼꺼를 가져올것이다.

				// 데티블에 값을 위치 시키는 코드 필요

			}

		});

		// 버튼 클릭시 삭제하기 이벤트

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "ok", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					System.out.println("에러나난다");
					diaryDelete();
					JOptionPane.showMessageDialog(null, "삭제되었습니다");
				}
			}

		});

		// 선택한 테이블 행 확인하기 버튼 이벤트
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow(); // 선택한 셀의 행번호
				title = (String) table.getValueAt(row, 0); // 첫번쩨 행에서 몇번짼꺼를 가져올것이다.
				days = (String) table.getValueAt(row, 1);
				text = (String) table.getValueAt(row, 2);

				System.out.println(title);
				System.out.println(days);
				System.out.print(text);
				textArea2.setText(title);
				textArea3.setText(days);
				textArea4.setText(text);

				seePanel.revalidate();
				seePanel.repaint();

				mainPanel.setVisible(false);
				seePanel.setVisible(true);

			}
		});

		JLabel showTitle = new JLabel("등록된 영양제 복용 일기");

		mainPanel.add(btn1); // 복용 일기 작성하기
		mainPanel.add(btn2); // 메인 선택화면으로 돌아가기
		mainPanel.add(btn3); // 일기 삭제하기
		mainPanel.add(btn4); // 복용일기 확인 버튼
		mainPanel.add(scroll);

		return mainPanel;

	}

	// 복용 일기 작성 UI 설정하기
	public JPanel writeJPanelUI() {

		String[] eatCount = { "1번", "2번", "3번" };
		
		writePanel.setLayout(null);
		writePanel.setBounds(0, 0, 900, 600);

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
		btn6 = new JButton("수정하기");
		saveBtn.addActionListener(this); // 등록하기 버튼 활성화

		// 텍스트 필드 추가
		textField1 = new TextField(15);
		textField2 = new TextField(15);
		textField3 = new TextField(15);
		textField4 = new TextField(15);

		byTextField1 = new TextField(15);
		byTextField2 = new TextField(15);

		// 텍스트 에리어 추가
		textArea1 = new TextArea();

		// 위치 조정

		labelDiary1.setBounds(100, 30, 200, 40);
		labelDiary2.setBounds(100, 120, 200, 40);
		labelDiary3.setBounds(20, 270, 200, 40);
		labelDiary4.setBounds(550, 50, 250, 40);

		labelDiaryArr[0].setBounds(150, 300, 100, 40);
		labelDiaryArr[1].setBounds(150, 350, 100, 40);
		labelDiaryArr[2].setBounds(150, 400, 100, 40);

		textField1.setBounds(100, 80, 250, 25);
		textField2.setBounds(250, 310, 250, 25);
		textField3.setBounds(250, 360, 250, 25);
		textField4.setBounds(250, 410, 250, 25);

		textArea1.setBounds(550, 100, 300, 200);

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

		backBtn.setBounds(650, 450, 150, 50);
		saveBtn.setBounds(650, 350, 150, 50);
		
		// 수정시 버튼 체인치 등록 -> 수정
		btn6.setBounds(650, 350, 150, 50);
		
		
		// 복용 주기 회수 선택
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();

				if (index == 0) {
					writePanel.add(labelDiaryArr[0]);
					writePanel.add(textField2);
					writePanel.setBounds(0, 0, 900, 600);

					labelDiaryArr[0].setVisible(true);
					labelDiaryArr[1].setVisible(false);
					labelDiaryArr[2].setVisible(false);
					textField2.setVisible(true);
					textField3.setVisible(false);
					textField4.setVisible(false);

				} else if (index == 1) {
					writePanel.add(labelDiaryArr[0]);
					writePanel.add(textField2);
					writePanel.setBounds(0, 0, 900, 600);

					writePanel.add(labelDiaryArr[1]);
					writePanel.add(textField3);
					writePanel.setBounds(0, 0, 900, 600);

					labelDiaryArr[0].setVisible(true);
					labelDiaryArr[1].setVisible(true);
					labelDiaryArr[2].setVisible(false);
					textField2.setVisible(true);
					textField3.setVisible(true);
					textField4.setVisible(false);

				} else {
					writePanel.add(labelDiaryArr[0]);
					writePanel.add(textField2);
					writePanel.setBounds(0, 0, 900, 600);

					writePanel.add(labelDiaryArr[1]);
					writePanel.add(textField3);
					writePanel.setBounds(0, 0, 900, 600);

					writePanel.add(labelDiaryArr[2]);
					writePanel.add(textField4);
					writePanel.setBounds(0, 0, 900, 600);

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

					writePanel.setBounds(0, 0, 950, 600);

				} else {

					for (int i = 0; i < checkWeek.length; i++) {
						checkWeek[i].setVisible(false);
					}

					writePanel.setBounds(0, 0, 970, 600);

				}

			}
		});
		// 요일 선택시 String 요일 문자열 받아오기

		for (int i = 0; i < checkWeek.length; i++) {
			checkWeek[i].addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						if (e.getItem() == checkWeek[0]) {
							count[0] = "월";
						} else if (e.getItem() == checkWeek[1]) {
							count[1] = "화";
						} else if (e.getItem() == checkWeek[2]) {
							count[2] = "수";
						} else if (e.getItem() == checkWeek[3]) {
							count[3] = "목";
						} else if (e.getItem() == checkWeek[4]) {
							count[4] = "금";
						} else if (e.getItem() == checkWeek[5]) {
							count[5] = "토";
						} else {
							count[6] = "일";
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
					writePanel.setBounds(0, 0, 900, 600);
				} else {
					bylabelDiary1.setVisible(false);
					bylabelDiary2.setVisible(false);
					byTextField1.setVisible(false);
					byTextField2.setVisible(false);
					writePanel.setBounds(0, 0, 900, 600);
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

		
		
		String dummy = "";

		try {
			File tempDir = new File("saveDiary.txt");
			if (!tempDir.exists()) // 경로에 폴더가 존재하지 않으면
				tempDir.mkdirs(); // 물리적으로 폴더 생성

			// 파일명과 같은 파일명이 있을 경우 덮어쓰기 판단
			FileWriter fw = new FileWriter(tempDir);
			// File.separator
			BufferedWriter bf = new BufferedWriter(fw);

			// 체크 박스 시, 누렀을 때 일요일

			bf.write(textField1.getText() + ", ");
			bf.write(ftToday + ", ");
			bf.write(textField2.getText() + " ");
			bf.write(textField3.getText() + " ");
			bf.write(textField4.getText() + " ");
			bf.write(byTextField1.getText() + " ");
			bf.write(byTextField2.getText() + " ");

			// 아이템 리스너 필드 count만 가져와서 일요일을 가져오기

			// 선택한 요일별 체큭 박스 text 파일에 저장
			for (int i = 0; i < count.length; i++) {
				if (count[i] != null)
					bf.write(count[i] + " ");
			}

			bf.write(textArea1.getText() + "\n"); // 마지막 입력후 한줄은 내린다

			bf.close(); // 저장 후 텍스트 필드의 값을 가져온 자원들을 해제한다.

			for (int i = 0; i < checkWeek.length; i++) {
				checkWeek[i].setText("");
			}

			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			byTextField1.setText("");
			byTextField2.setText("");
			textArea1.setText("");

			FileReader fr = new FileReader("saveDiary.txt"); // String 형으로 파일을 불러온다.
			BufferedReader br = new BufferedReader(fr); // 한줄씩 일기 위해(빠른속도로 읽기위해)
			// 파일 이름을 현제 Date 값으로 받아서 이름을 짓자
			String line; // while의 조건부

			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				model.addRow(arr);

				System.out.println(line);

			}
			br.close(); // 읽어온 자원들을 해제한다.

		} catch (FileNotFoundException e1) {
			System.out.println("파일이 존재하지 않네용!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// 저장된 일기 내용 table에 보여주기
	public void showAllList() {

		BufferedReader br2 = null;

		try {
			br2 = new BufferedReader(new FileReader("saveDiary.txt"));
			String str = null;
			while ((str = br2.readLine()) != null) { // 한줄씩 읽어오기
				String[] srr = str.split(", "); // , 를 기준으로 str 나눠서 arr 만들기
				model.addRow(srr);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void diaryDelete() {
		// 테이블 행 지우기
		if (table.getSelectedRow() == -1) {
			return;
		} else { // 테이블에서 행이 선택되면,
			model.removeRow(table.getSelectedRow()); // model에서 선택된 테이블 행 지우기
		}

		// txt 파일에서 데이터 지우기
		BufferedWriter bw = null;
		try {
			// default가 false이므로 새로 데이터 파일 생성
			bw = new BufferedWriter(new FileWriter("saveDiary.txt"));
			for (int i = 0; i < table.getRowCount(); i++) {
				for (int j = 0; j < table.getColumnCount(); i++) {
					bw.write(table.getValueAt(i, j).toString() + ",");
					// table의 행열 기준 각각 값 얻어와서 /로 구분하며 파일에 데이터 입력
				}
				bw.newLine(); // 행이 발뀔 때 라인 바꿔주기
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 저장된 영양제 복용일기 보여주는 창
	public JPanel seeJPanel() {

		seePanel.setLayout(null);
		seePanel.setBounds(10, 50, 900, 600);
		// seePanel.setVisible(true);
		// mainPanel.setVisible(false);

		btn5 = new JButton("돌아가기");
		btn7 = new JButton("수정하기");

		textArea2 = new JTextArea(title);
		textArea3 = new JTextArea(days);
		textArea4 = new JTextArea(text);

		textArea2.setBounds(50, 50, 300, 100);
		textArea3.setBounds(50, 200, 300, 100);
		textArea4.setBounds(50, 350, 450, 100);
		
		btn5.setBounds(700, 430, 100, 50);
		btn7.setBounds(700, 330, 100, 50);
		
		// 돌아가기 버튼 활성화
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seePanel.setVisible(false);
				mainPanel.setVisible(true); // 복용 일기 작성 페이지 활성화

			}
		});
		

		seePanel.add(textArea2);
		seePanel.add(textArea3);
		seePanel.add(textArea4);

		seePanel.add(btn5);
		seePanel.add(btn7);
		
		return seePanel;

	}
	
	public static void main(String[] args) {
		
		new mainPanel();

	}
	
}
