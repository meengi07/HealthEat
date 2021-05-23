package model.vo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JFrame {

	Panel2 p2 = new Panel2();

	private JPanel mainpanel = new JPanel(); /// 메인페이지
	private JPanel heatlhmain = new JPanel(); // 검사 메인 페이지
	private JPanel heatlhcheck1 = new JPanel(); // 검사 문항 체크
	private JPanel heatlhcheck2 = new JPanel(); // 검사 문항 체크2
	private JPanel heatlhend = new JPanel(); // 검사 결과 확인
	private int count = 0; // 건강 점수 체크용
	private String counts = " ";
	JLabel labelC = new JLabel("건강 점수 및 코맨트 : " + counts); // 전체용 라벨

	public Panel() {
		mainpanel.setVisible(true);
		heatlhmain.setVisible(false);
		heatlhcheck1.setVisible(false);
		heatlhcheck2.setVisible(false);
		heatlhend.setVisible(false);
	}

	public JPanel mainpanelM() {

		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, 500, 700);

		JButton btn1 = new JButton("건강 체크");
		JButton btn2 = new JButton("리뷰 게시판");
		btn1.setBounds(70, 200, 150, 100);
		btn2.setBounds(230, 200, 150, 100);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.setVisible(false);
				heatlhmain.setVisible(true);
			}

		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.setVisible(false);
				p2.reviewMainPenalM().setVisible(true);
			}

		});

		mainpanel.add(btn1);
		mainpanel.add(btn2);

		return mainpanel;

	}

	public JPanel heatlhmainM() {

		heatlhmain.setLayout(null);
		heatlhmain.setBounds(0, 0, 500, 700);

		JLabel label = new JLabel("건강 체크를 시작하시곘습니까?");
		label.setBounds(150, 200, 300, 100);

		JButton btn1 = new JButton("YES");
		JButton btn2 = new JButton("No");
		btn1.setBounds(120, 300, 100, 100);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				heatlhcheck1.setVisible(true);
				heatlhmain.setVisible(false);

			}

		});
		btn2.setBounds(270, 300, 100, 100);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.setVisible(true);
				heatlhmain.setVisible(false);
			}

		});

		heatlhmain.add(btn1);
		heatlhmain.add(btn2);
		heatlhmain.add(label);

		return heatlhmain;
	}

	public JPanel heatlhcheck1M() {

		heatlhcheck1.setLayout(null);
		heatlhcheck1.setBounds(0, 0, 500, 700);
		JLabel label = new JLabel("주 음주 횟수");
		JCheckBox box1 = new JCheckBox("주 1회");

		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;

			}

		});

		JCheckBox box2 = new JCheckBox("주 2~3회");
		box2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;

			}

		});
		JCheckBox box3 = new JCheckBox("주 4~5회");
		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;

			}

		});
		JCheckBox box4 = new JCheckBox("매일");
		box4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 4;

			}

		});

		JLabel label2 = new JLabel("하루 담배 횟수");
		JCheckBox box5 = new JCheckBox("1~5개피");
		box5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
			}

		});
		JCheckBox box6 = new JCheckBox("5~10개피");
		box6.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;

			}

		});
		JCheckBox box7 = new JCheckBox("10~15개피");
		box7.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;

			}

		});
		JCheckBox box8 = new JCheckBox("한 갑");
		box8.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 4;

			}

		});

		JLabel label3 = new JLabel("아침에 일어나는게 피곤하고 힘들다");
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

		JLabel label4 = new JLabel("피부가 가렵다");
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

		JButton btn1 = new JButton("취소");
		JButton btn2 = new JButton("다음");

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				heatlhcheck1.setVisible(false);
				mainpanel.setVisible(true);
			}

		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				heatlhcheck1.setVisible(false);
				heatlhcheck2.setVisible(true);

			}

		});

		label3.setBounds(20, 280, 200, 100);
		box9.setBounds(60, 340, 100, 50);
		box10.setBounds(60, 380, 100, 50);

		label4.setBounds(250, 280, 200, 100);
		box11.setBounds(290, 340, 100, 50);
		box12.setBounds(290, 380, 100, 50);

		label.setBounds(20, 5, 100, 100);
		box1.setBounds(60, 60, 100, 50);
		box2.setBounds(60, 100, 100, 50);
		box3.setBounds(60, 140, 100, 50);
		box4.setBounds(60, 180, 100, 50);

		label2.setBounds(250, 5, 100, 100);
		box5.setBounds(290, 60, 100, 50);
		box6.setBounds(290, 100, 100, 50);
		box7.setBounds(290, 140, 100, 50);
		box8.setBounds(290, 180, 100, 50);

		btn1.setBounds(140, 610, 80, 50);
		btn2.setBounds(240, 610, 80, 50);

		heatlhcheck1.add(box1);
		heatlhcheck1.add(box2);
		heatlhcheck1.add(box3);
		heatlhcheck1.add(box4);
		heatlhcheck1.add(label);
		heatlhcheck1.add(box5);
		heatlhcheck1.add(box6);
		heatlhcheck1.add(box7);
		heatlhcheck1.add(box8);
		heatlhcheck1.add(label2);
		heatlhcheck1.add(box9);
		heatlhcheck1.add(box10);
		heatlhcheck1.add(label3);
		heatlhcheck1.add(box11);
		heatlhcheck1.add(box12);
		heatlhcheck1.add(label4);
		heatlhcheck1.add(btn1);
		heatlhcheck1.add(btn2);

		return heatlhcheck1;
	}

	public JPanel heatlhcheck2M() {

		heatlhcheck2.setLayout(null);
		heatlhcheck2.setBounds(0, 0, 500, 700);

		JLabel label = new JLabel("손톱이 하얗거나 세로줄이 생긴다");
		JCheckBox box1 = new JCheckBox("YES");
		JCheckBox box2 = new JCheckBox("NO");
		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;

			}

		});

		JLabel label2 = new JLabel("신체에 붉은 반점이 일어난다");
		JCheckBox box3 = new JCheckBox("YES");
		JCheckBox box4 = new JCheckBox("NO");

		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JLabel label3 = new JLabel("다리가 저리다");
		JCheckBox box5 = new JCheckBox("Yes");
		JCheckBox box6 = new JCheckBox("NO");

		box5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JLabel label4 = new JLabel("손에 땀이 찬다");
		JCheckBox box7 = new JCheckBox("YES");
		JCheckBox box8 = new JCheckBox("NO");
		box7.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JButton btn1 = new JButton("취소");
		JButton btn2 = new JButton("다음");

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				heatlhcheck2.setVisible(false);
				mainpanel.setVisible(true);
			}

		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				heatlhcheck2.setVisible(false);
				heatlhend.setVisible(true);

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
				counts = Integer.toString(count) + "점" + "  " + coment;
				count = 0;
				labelC.setText(counts);

			}
		});
		label.setBounds(20, 5, 200, 100);
		box1.setBounds(60, 60, 100, 50);
		box2.setBounds(60, 100, 100, 50);
		label2.setBounds(250, 5, 200, 100);
		box3.setBounds(290, 60, 100, 50);
		box4.setBounds(290, 100, 100, 50);
		label3.setBounds(250, 280, 200, 100);
		box5.setBounds(290, 340, 100, 50);
		box6.setBounds(290, 380, 100, 50);
		label4.setBounds(20, 280, 200, 100);
		box7.setBounds(60, 340, 100, 50);
		box8.setBounds(60, 380, 100, 50);
		btn1.setBounds(140, 610, 80, 50);
		btn2.setBounds(240, 610, 80, 50);

		heatlhcheck2.add(label);
		heatlhcheck2.add(box1);
		heatlhcheck2.add(box2);
		heatlhcheck2.add(label2);
		heatlhcheck2.add(box3);
		heatlhcheck2.add(box4);
		heatlhcheck2.add(label3);
		heatlhcheck2.add(box5);
		heatlhcheck2.add(box6);
		heatlhcheck2.add(label4);
		heatlhcheck2.add(box7);
		heatlhcheck2.add(box8);
		heatlhcheck2.add(btn1);
		heatlhcheck2.add(btn2);

		return heatlhcheck2;

	}

	public JPanel heatlhendM() {

		heatlhend.setLayout(null);
		heatlhend.setBounds(0, 0, 500, 700);

		JButton btn = new JButton("확인");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.setVisible(true);
				heatlhend.setVisible(false);
			}
		});

		labelC.setBounds(100, 100, 500, 100);
		btn.setBounds(200, 400, 100, 50);

		heatlhend.add(labelC);
		heatlhend.add(btn);
		return heatlhend;
	}
}
