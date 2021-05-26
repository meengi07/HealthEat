package model.vo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class Panel extends JFrame {

	////////// review /////////////////////////////////////////////////////////

	private JTable table;
	private String[] header = new String[] { "별명", "영양제", "제목", "내용" };

	DefaultTableModel model = new DefaultTableModel(header, 0) {
		public boolean isCellEditable(int header, int data) {
			// �뀒�씠釉� �궡�슜 �닔�젙 諛⑹�
			return false;
		}
	};

	private BufferedReader br;
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JTextArea area = new JTextArea();
	JTextField namef1 = new JTextField();
	JTextField eat1 = new JTextField();
	JTextField title1 = new JTextField();
	JTextArea content1 = new JTextArea();
	private String a1 = "";
	private String a2 = "";
	private String a3 = "";
	private String a4 = "";
	private int a = 0;
	private String n;
	private String n2;
	private String n3;
	private String n4;
	private JPanel reviewMainPenal = new JPanel();
	private JPanel reviewAddPenal = new JPanel();
	private JPanel reviewplusPenal = new JPanel();
	private JPanel reviewDelPenal = new JPanel();
	private JPanel reviewcheckPenal = new JPanel();

////////////////////////////////////////////////////////
	
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
		reviewMainPenal.setVisible(false);
		reviewAddPenal.setVisible(false);
		reviewDelPenal.setVisible(false);
		reviewplusPenal.setVisible(false);
		reviewcheckPenal.setVisible(false);
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

				reviewMainPenal.setVisible(true);

			}

		});

		mainpanel.add(btn1);
		mainpanel.add(btn2);

		return mainpanel;

	}

	public JPanel heatlhmainM() {

		heatlhmain.setLayout(null);
		heatlhmain.setBounds(0, 0, 500, 700);

		JLabel label = new JLabel("건강 체크를 시작하시母윱歐?");
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

	///////////////////////////////////////////////////// 由щ럭 寃뚯떆�뙋
	///////////////////////////////////////////////////////

	public JPanel reviewMainPenalM() {

		reviewMainPenal.setLayout(null);
		reviewMainPenal.setBounds(0, 0, 500, 700);

		JScrollPane scroll = new JScrollPane(init());
		scroll.setBounds(80, 200, 300, 200);
		reviewMainPenal.add(scroll);

		JButton btn = new JButton("추가");
		JButton btn2 = new JButton("수정");
		JButton btn3 = new JButton("삭제");
		JButton btn4 = new JButton("게시글 확인");
		JButton btn5 = new JButton("이전");
		btn.setBounds(100, 100, 80, 80);
		btn2.setBounds(200, 100, 80, 80);
		btn3.setBounds(300, 100, 80, 80);
		btn4.setBounds(260, 500, 150, 60);
		btn5.setBounds(140, 500, 150, 60);
		reviewMainPenal.add(btn);
		reviewMainPenal.add(btn2);
		reviewMainPenal.add(btn3);
		reviewMainPenal.add(btn4);
		reviewMainPenal.add(btn5);

		////추가 ////

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reviewAddPenal.setVisible(true);
				reviewMainPenal.setVisible(false);
			}

		});

		/// �뀒�씠釉� �닔�젙///
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				a = table.getSelectedRow();
				n = (String) model.getValueAt(a, 0);
				n2 = (String) model.getValueAt(a, 1);
				n3 = (String) model.getValueAt(a, 2);
				n4 = (String) model.getValueAt(a, 3);

				namef1.setText(n);
				eat1.setText(n2);
				title1.setText(n3);
				content1.setText(n4);
				reviewplusPenalM().revalidate();
				reviewplusPenalM().repaint();

				reviewplusPenal.setVisible(true);
				reviewMainPenal.setVisible(false);

			}

		});

		/// �뀒�씠釉� �궘�젣///
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					return;
				} else {
					model.removeRow(table.getSelectedRow());
				}

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("newList.txt"));
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getValueAt(i, j).toString() + ",");
						}
						bw.newLine();
					}

					bw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		// 寃뚯떆�뙋�솗�씤
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					return;
				} else {
					a1 = (model.getValueAt(table.getSelectedRow(), 0)).toString();
					label4.setText(a1);
					a2 = (model.getValueAt(table.getSelectedRow(), 1)).toString();
					label5.setText(a2);
					a3 = (model.getValueAt(table.getSelectedRow(), 2)).toString();
					label6.setText(a3);
					a4 = (model.getValueAt(table.getSelectedRow(), 3)).toString();
					area.setText(a4);
					reviewcheckPenal.revalidate();
					reviewcheckPenal.repaint();
					reviewMainPenal.setVisible(false);
					reviewcheckPenal.setVisible(true);

				}
			}
		});
		
		//�씠�쟾
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainpanel.setVisible(true);
				reviewMainPenal.setVisible(false);
			}
		});
		return reviewMainPenal;
	}

	public JTable init() {

		try {
			br = new BufferedReader(new FileReader("newList.txt"));
			String str = null;
			while ((str = br.readLine()) != null) {
				String[] arr = str.split(",");
				model.addRow(arr);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table = new JTable(model);
		table.setModel(model);

		return table;
	}

	public JPanel reviewAddPenalM() {

		reviewAddPenal.setLayout(null);
		reviewAddPenal.setBounds(0, 0, 500, 700);
		JLabel label = new JLabel("별명");
		JLabel label2 = new JLabel("영양제");
		JLabel label3 = new JLabel("제목");
		JLabel label4 = new JLabel("내용");

		JTextField namef = new JTextField();
		JTextField eat = new JTextField();
		JTextField title = new JTextField();
		JTextArea content = new JTextArea();

		JButton btn = new JButton("異붽�");

		btn.addActionListener(new ActionListener() {

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

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("newList.txt"));
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getValueAt(i, j).toString() + ",");
						}
						bw.newLine();
					}

					bw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				reviewAddPenal.setVisible(false);
				reviewMainPenal.setVisible(true);

			}

		});

		btn.setBounds(100, 550, 60, 60);
		label.setBounds(50, 10, 50, 150);
		label2.setBounds(250, 10, 50, 150);
		label3.setBounds(50, 100, 50, 150);
		label4.setBounds(50, 250, 50, 150);
		namef.setBounds(50, 120, 150, 50);
		eat.setBounds(250, 120, 150, 50);
		title.setBounds(50, 200, 150, 50);
		content.setBounds(50, 340, 350, 200);

		reviewAddPenal.add(btn);
		reviewAddPenal.add(label);
		reviewAddPenal.add(label2);
		reviewAddPenal.add(label3);
		reviewAddPenal.add(label4);
		reviewAddPenal.add(namef);
		reviewAddPenal.add(eat);
		reviewAddPenal.add(title);
		reviewAddPenal.add(content);

		return reviewAddPenal;
	}

	public JPanel reviewplusPenalM() {

		reviewplusPenal.setLayout(null);
		reviewplusPenal.setBounds(0, 0, 500, 700);
		JLabel label = new JLabel("별명");
		JLabel label2 = new JLabel("영양제");
		JLabel label3 = new JLabel("제목");
		JLabel label4 = new JLabel("내용");
		namef1.repaint();
		eat1.repaint();
		title1.repaint();
		content1.repaint();

		JButton btn = new JButton("�닔�젙");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = new String[4];

				// input[0] = namef.getText();
				// input[1] = eat.getText();
				// input[2] = title.getText();
				// input[3] = content.getText();
				model.setValueAt(namef1.getText(), a, 0);
				model.setValueAt(eat1.getText(), a, 1);
				model.setValueAt(title1.getText(), a, 2);
				model.setValueAt(content1.getText(), a, 3);

				namef1.setText("");
				eat1.setText("");
				title1.setText("");
				content1.setText("");

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("newList.txt"));
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getValueAt(i, j).toString() + ",");
						}
						bw.newLine();
					}

					bw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				reviewplusPenal.setVisible(false);
				reviewMainPenal.setVisible(true);

			}

		});

		label.setBounds(50, 10, 50, 150);
		label2.setBounds(250, 10, 50, 150);
		label3.setBounds(50, 100, 50, 150);
		label4.setBounds(50, 250, 50, 150);
		namef1.setBounds(50, 120, 150, 50);
		eat1.setBounds(250, 120, 150, 50);
		title1.setBounds(50, 200, 150, 50);
		content1.setBounds(50, 340, 350, 200);
		btn.setBounds(100, 550, 60, 60);

		reviewplusPenal.add(btn);
		reviewplusPenal.add(label);
		reviewplusPenal.add(label2);
		reviewplusPenal.add(label3);
		reviewplusPenal.add(label4);
		reviewplusPenal.add(namef1);
		reviewplusPenal.add(eat1);
		reviewplusPenal.add(title1);
		reviewplusPenal.add(content1);

		return reviewplusPenal;
	}

	public JPanel reviewcheckPenalM() {
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);

		reviewcheckPenal.setLayout(null);
		reviewcheckPenal.setBounds(0, 0, 500, 700);


		JButton btn = new JButton("이전");

		JLabel label = new JLabel("별명");
		JLabel label1 = new JLabel("영양제");
		JLabel label2 = new JLabel("제목");
		JLabel label3 = new JLabel("내용");
		label.setBounds(50, 10, 50, 150);
		label1.setBounds(250, 10, 50, 150);
		label2.setBounds(50, 100, 50, 150);
		label3.setBounds(50, 250, 50, 150);

		area.setEditable(false);

		btn.setBounds(150, 550, 60, 60);
		label4.setBounds(50, 120, 150, 50);
		label5.setBounds(250, 120, 150, 50);
		label6.setBounds(50, 200, 150, 50);
		area.setBounds(50, 340, 350, 200);

		label4.setBorder(border);
		label5.setBorder(border);
		label6.setBorder(border);
		area.setBorder(border);

		reviewcheckPenal.add(btn);
		reviewcheckPenal.add(area);
		reviewcheckPenal.add(label);
		reviewcheckPenal.add(label1);
		reviewcheckPenal.add(label2);
		reviewcheckPenal.add(label3);
		reviewcheckPenal.add(label4);
		reviewcheckPenal.add(label5);
		reviewcheckPenal.add(label6);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reviewcheckPenal.setVisible(false);
				reviewMainPenal.setVisible(true);

			}

		});
		return reviewcheckPenal;
	}

}