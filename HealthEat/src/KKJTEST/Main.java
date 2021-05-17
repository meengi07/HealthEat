package KKJTEST;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

		JPanel panel4 = new JPanel(); // 건강 관리 페이지
		JPanel panel5 = new JPanel(); // 건강 관리 페이지
		JPanel panel6 = new JPanel(); // 건강 관리 페이지

		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);

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
				count += 0;
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
				count += 0;
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
				panel5.setVisible(true);
				String coment ="";
				if(count > 0 || count < 21) {
					coment = "건강하시네요!!!!";
				}else if(count < 41){
					coment = "정상범위 이내입니다 좀더 노력하세요!";
				}else if(count < 61) {
					coment = "건강 좀 챙기셔야해요!!!!";
				}else if(count < 81) {
					coment = "당신 위험해!!!!!";
				}else {
					coment = "어떻게 살아있지???";
				}
				
				
				
				counts = Integer.toString(count)+"점" + "\t" +coment;

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

			}

		});

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

		// 컨테이너에 메인 페이지 panel 추가
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new Main();
	}

}
