package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

	int count = 0;
	String counts = "123";

	public Main() {

		this.setTitle("마이페이지 UI TEST");
		this.setSize(500, 700);
		// BorderLayout layout = new BorderLayout();
		this.setLayout(null);

		JPanel panel1 = new JPanel(); // 메인 페이지
		JPanel panel2 = new JPanel(); // 건강 체크 페이지
		JPanel panel3 = new JPanel(); // 게시판 페이지

		JPanel panel4 = new JPanel(); // 건강 체크 페이지
		JPanel panel5 = new JPanel(); // 건강 확인 페이지
		JPanel panel6 = new JPanel(); // 건강 체크 페이지2

		JPanel panel7 = new JPanel(); // 게시판 등록 페이지
		JPanel panel8 = new JPanel(); // 게시판 수정 페이지
		JPanel panel9 = new JPanel(); // 게시글 눌렀을 시 페이지

		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);
		panel6.setVisible(false);
		panel7.setVisible(false);

		//

		// 점수체크
		// 점수 체크 메뉴
		JButton btn20 = new JButton("확인");
		btn20.setLocation(200, 400);
		btn20.setSize(100, 50);
		btn20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel5.setVisible(false);
				panel1.setVisible(true);

			}

		});
		panel5.setLayout(null);
		panel5.setBounds(0, 0, 500, 700);
		JLabel label15 = new JLabel("건강 점수 및 코맨트 : " + counts);
		label15.setLocation(100, 100);
		label15.setSize(500, 100);
		panel5.add(label15);
		panel5.add(btn20);

		// 메인 페이지 설정

		JButton btn1 = new JButton("건강 체크");
		JButton btn2 = new JButton("리뷰 게시판");
		panel1.setLayout(null);
		panel1.setBounds(0, 0, 500, 700);
		btn1.setBounds(70, 200, 150, 100);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);

			}

		});
		panel1.add(btn1);
		btn2.setBounds(230, 200, 150, 100);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel3.setVisible(true);

			}

		});
		panel1.add(btn2);

		// 건강 관리 페이지 설정

		panel2.setLayout(null);
		panel2.setBounds(0, 0, 500, 700);
		JLabel label1 = new JLabel("건강 체크를 시작하시곘습니까?");
		JButton btn3 = new JButton("YES");

		JButton btn4 = new JButton("No");
		btn3.setBounds(120, 300, 100, 100);
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panel2.setVisible(false);
				panel4.setVisible(true);
			}

		});
		btn4.setBounds(270, 300, 100, 100);
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
			}

		});
		label1.setBounds(150, 200, 300, 100);
		panel2.add(label1);
		panel2.add(btn3);
		panel2.add(btn4);

		// 건강관리 페이지1 _ 문항 START

		panel4.setLayout(null);
		panel4.setBounds(0, 0, 500, 700);
		JLabel label10 = new JLabel("주 음주 횟수");
		JCheckBox box1 = new JCheckBox("주 1회");

		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
				System.out.println(count);

			}

		});

		JCheckBox box2 = new JCheckBox("주 2~3회");
		box2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;
				System.out.println(count);

			}

		});
		JCheckBox box3 = new JCheckBox("주 4~5회");
		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;
				System.out.println(count);

			}

		});
		JCheckBox box4 = new JCheckBox("매일");
		box4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 4;
				System.out.println(count);

			}

		});

		label10.setBounds(20, 5, 100, 100);
		box1.setBounds(60, 60, 100, 50);
		box2.setBounds(60, 100, 100, 50);
		box3.setBounds(60, 140, 100, 50);
		box4.setBounds(60, 180, 100, 50);

		JLabel label11 = new JLabel("하루 담배 횟수");
		JCheckBox box5 = new JCheckBox("1~5개피");
		box5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
				System.out.println(count);
			}

		});
		JCheckBox box6 = new JCheckBox("5~10개피");
		box6.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;
				System.out.println(count);

			}

		});
		JCheckBox box7 = new JCheckBox("10~15개피");
		box7.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;
				System.out.println(count);

			}

		});
		JCheckBox box8 = new JCheckBox("한 갑");
		box8.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 4;
				System.out.println(count);

			}

		});

		label11.setBounds(250, 5, 100, 100);
		box5.setBounds(290, 60, 100, 50);
		box6.setBounds(290, 100, 100, 50);
		box7.setBounds(290, 140, 100, 50);
		box8.setBounds(290, 180, 100, 50);

		JLabel label12 = new JLabel("아침에 일어나는게 피곤하고 힘들다");
		JCheckBox box9 = new JCheckBox("YES");
		box9.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 20;
			}

		});
		JCheckBox box10 = new JCheckBox("NO");
		box10.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
			}

		});

		label12.setBounds(20, 280, 200, 100);
		box9.setBounds(60, 340, 100, 50);
		box10.setBounds(60, 380, 100, 50);
		panel4.add(label12);
		panel4.add(box9);
		panel4.add(box10);

		JLabel label13 = new JLabel("피부가 가렵다");
		JCheckBox box11 = new JCheckBox("YES");
		box9.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 20;
			}

		});
		JCheckBox box12 = new JCheckBox("NO");
		box10.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
			}

		});

		label13.setBounds(250, 280, 200, 100);
		box11.setBounds(290, 340, 100, 50);
		box12.setBounds(290, 380, 100, 50);
		panel4.add(label13);
		panel4.add(box11);
		panel4.add(box12);

		JButton btn10 = new JButton("취소");
		JButton btn11 = new JButton("다음");

		btn10.setBounds(140, 610, 80, 50);
		btn11.setBounds(240, 610, 80, 50);

		btn10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel4.setVisible(false);
				panel1.setVisible(true);

			}

		});

		btn11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel4.setVisible(false);
				panel6.setVisible(true);

			}

		});

		panel6.setBounds(0, 0, 500, 700);
		panel6.setLayout(null);

		JLabel label30 = new JLabel("손톱이 하얗거나 세로줄이 생긴다");
		JCheckBox box20 = new JCheckBox("YES");
		box20.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;

			}

		});

		JCheckBox box21 = new JCheckBox("NO");

		label30.setBounds(20, 5, 200, 100);
		box20.setBounds(60, 60, 100, 50);
		box21.setBounds(60, 100, 100, 50);

		panel6.add(label30);
		panel6.add(box20);
		panel6.add(box21);

		JLabel label31 = new JLabel("신체에 붉은 반점이 일어난다");
		JCheckBox box22 = new JCheckBox("YES");
		box22.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JCheckBox box23 = new JCheckBox("NO");

		label31.setBounds(250, 5, 200, 100);
		box22.setBounds(290, 60, 100, 50);
		box23.setBounds(290, 100, 100, 50);

		panel6.add(label31);
		panel6.add(box22);
		panel6.add(box23);

		JLabel label32 = new JLabel("다리가 저리다");
		JCheckBox box24 = new JCheckBox("Yes");
		box24.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JCheckBox box25 = new JCheckBox("NO");
		label32.setBounds(250, 280, 200, 100);
		box24.setBounds(290, 340, 100, 50);
		box25.setBounds(290, 380, 100, 50);

		panel6.add(label32);
		panel6.add(box24);
		panel6.add(box25);

		JLabel label33 = new JLabel("손에 땀이 찬다");
		JCheckBox box26 = new JCheckBox("YES");
		box26.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JCheckBox box27 = new JCheckBox("NO");
		label33.setBounds(20, 280, 200, 100);
		box26.setBounds(60, 340, 100, 50);
		box27.setBounds(60, 380, 100, 50);

		panel6.add(label33);
		panel6.add(box26);
		panel6.add(box27);

		JButton btn30 = new JButton("취소");
		JButton btn31 = new JButton("다음");

		btn30.setBounds(140, 610, 80, 50);
		btn31.setBounds(240, 610, 80, 50);

		btn30.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel4.setVisible(false);
				panel1.setVisible(true);

			}

		});

		btn31.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String coment = "";
				if (count < 21) {
					coment = "건강하시네요!!!!";
				} else if (count < 41) {
					coment = "정상범위 이내입니다 좀더 노력하세요!";
				} else if (count < 61) {
					coment = "건강 좀 챙기셔야해요!!!!";
				} else if (count < 81) {
					coment = "당신 위험해!!!!!";
				} else {
					coment = "어떻게 살아있지???";
				}
				// 라벨값 재설정
				counts = Integer.toString(count) + "점" + "\t" + coment;
				count = 0;
				label15.setText(counts);
				label15.repaint();
				// 체크 박스 초기화
				box1.setSelected(false);
				box2.setSelected(false);
				box3.setSelected(false);
				box4.setSelected(false);
				box5.setSelected(false);
				box6.setSelected(false);
				box7.setSelected(false);
				box8.setSelected(false);
				box9.setSelected(false);
				box10.setSelected(false);
				box11.setSelected(false);
				box12.setSelected(false);
				box20.setSelected(false);
				box21.setSelected(false);
				box22.setSelected(false);
				box23.setSelected(false);
				box24.setSelected(false);
				box25.setSelected(false);
				box26.setSelected(false);
				box27.setSelected(false);

				panel6.setVisible(false);
				panel5.setVisible(true);

			}

		});
		panel6.add(btn30);
		panel6.add(btn31);

		panel4.add(label10);
		panel4.add(label11);
		panel4.add(box1);
		panel4.add(box2);
		panel4.add(box3);
		panel4.add(box4);
		panel4.add(box5);
		panel4.add(box6);
		panel4.add(box7);
		panel4.add(box8);
		panel4.add(btn10);
		panel4.add(btn11);

////////////////////////게시판 구현 예정//TEST중////////////////////
		panel3.setBounds(0, 0, 500, 700);
		panel3.setLayout(null);

		// 별명, 영양제, 제목
		String[] header = { "별명", "영양제", "제목", "내용" };
		String[][] con = { { "쭈니", "고려은단", "이거짱", " " }, { "말랑이", "오메가99", "이거별루", " " } };

		DefaultTableModel model = new DefaultTableModel(con, header);
		JTable table = new JTable(model);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(80, 200, 300, 200);
		panel3.add(scroll);

		JButton btn40 = new JButton("추가");
		btn40.setBounds(100, 500, 60, 60);
		btn40.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(false);
				panel7.setVisible(true);

			}

		});
		panel3.add(btn40);
		
		JButton btn41 = new JButton("삭제");
		btn41.setBounds(200, 500, 60, 60);
		panel3.add(btn41);
		
		btn41.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			if(table.getSelectedRow() == -1) {
				return;
			}else {
				model.removeRow(table.getSelectedRow());
			}
				
				
			}
			
		});


		//////////// table 추가//////////////
		panel7.setBounds(0, 0, 500, 700);
		panel7.setLayout(null);
		JLabel label50 = new JLabel("별명");
		JLabel label51 = new JLabel("영양제");
		JLabel label52 = new JLabel("제목");
		JLabel label53 = new JLabel("내용");

		label50.setBounds(50, 10, 50, 150);
		label51.setBounds(250, 10, 50, 150);
		label52.setBounds(50, 100, 50, 150);
		label53.setBounds(50, 250, 50, 150);

		panel7.add(label50);
		panel7.add(label51);
		panel7.add(label52);
		panel7.add(label53);

		JTextField namef = new JTextField();
		JTextField eat = new JTextField();
		JTextField title = new JTextField();
		JTextField content = new JTextField();

		namef.setBounds(50, 120, 150, 50);
		eat.setBounds(250, 120, 150, 50);
		title.setBounds(50, 200, 150, 50);
		content.setBounds(50, 340, 350, 200);

		panel7.add(namef);
		panel7.add(eat);
		panel7.add(title);
		panel7.add(content);

		
		
		JButton btn60 = new JButton("추가");
		btn60.setBounds(100, 550, 60, 60);
		panel7.add(btn60);
		btn60.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = new String[4];

				input[0] = namef.getText();
				input[1] = eat.getText();
				input[2] = title.getText();
				input[3] = content.getText();
				model.addRow(input);

				namef.setText("");
				eat.setText("");
				title.setText("");
				content.setText("");

				panel7.setVisible(false);
				panel3.setVisible(true);

			}

		});
		
	
				
		
		
		
		
		
		
		
		// 컨테이너에 메인 페이지 panel 추가
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);
		this.add(panel7);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new Main();
	}

}
