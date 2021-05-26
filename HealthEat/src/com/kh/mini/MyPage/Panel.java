package src.com.kh.mini.MyPage;

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

import Project.ui.startGUI;

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
	Panel2 p2 = new Panel2();
	private JPanel mainpanel = new JPanel(); /// 硫붿씤�럹�씠吏�
	private JPanel heatlhmain = new JPanel(); // 寃��궗 硫붿씤 �럹�씠吏�
	private JPanel heatlhcheck1 = new JPanel(); // 寃��궗 臾명빆 泥댄겕
	private JPanel heatlhcheck2 = new JPanel(); // 寃��궗 臾명빆 泥댄겕2
	private JPanel heatlhend = new JPanel(); // 寃��궗 寃곌낵 �솗�씤
	private int count = 0; // 嫄닿컯 �젏�닔 泥댄겕�슜
	private String counts = " ";
	JLabel labelC = new JLabel("嫄닿컯 �젏�닔 諛� 肄붾㎤�듃 : " + counts); // �쟾泥댁슜 �씪踰�

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

		JButton btn1 = new JButton("嫄닿컯 泥댄겕");
		JButton btn2 = new JButton("由щ럭 寃뚯떆�뙋");
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

		JLabel label = new JLabel("嫄닿컯 泥댄겕瑜� �떆�옉�븯�떆혖寃잛뒿�땲源�?");
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
		JLabel label = new JLabel("二� �쓬二� �슏�닔");
		JCheckBox box1 = new JCheckBox("二� 1�쉶");

		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;

			}

		});

		JCheckBox box2 = new JCheckBox("二� 2~3�쉶");
		box2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;

			}

		});
		JCheckBox box3 = new JCheckBox("二� 4~5�쉶");
		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;

			}

		});
		JCheckBox box4 = new JCheckBox("留ㅼ씪");
		box4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 4;

			}

		});

		JLabel label2 = new JLabel("�븯猷� �떞諛� �슏�닔");
		JCheckBox box5 = new JCheckBox("1~5媛쒗뵾");
		box5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
			}

		});
		JCheckBox box6 = new JCheckBox("5~10媛쒗뵾");
		box6.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;

			}

		});
		JCheckBox box7 = new JCheckBox("10~15媛쒗뵾");
		box7.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;

			}

		});
		JCheckBox box8 = new JCheckBox("�븳 媛�");
		box8.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 4;

			}

		});

		JLabel label3 = new JLabel("�븘移⑥뿉 �씪�뼱�굹�뒗寃� �뵾怨ㅽ븯怨� �옒�뱾�떎");
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

		JLabel label4 = new JLabel("�뵾遺�媛� 媛��졄�떎");
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

		JButton btn1 = new JButton("痍⑥냼");
		JButton btn2 = new JButton("�떎�쓬");

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

		JLabel label = new JLabel("�넀�넲�씠 �븯�뼏嫄곕굹 �꽭濡쒖쨪�씠 �깮湲대떎");
		JCheckBox box1 = new JCheckBox("YES");
		JCheckBox box2 = new JCheckBox("NO");
		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;

			}

		});

		JLabel label2 = new JLabel("�떊泥댁뿉 遺됱� 諛섏젏�씠 �씪�뼱�궃�떎");
		JCheckBox box3 = new JCheckBox("YES");
		JCheckBox box4 = new JCheckBox("NO");

		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JLabel label3 = new JLabel("�떎由ш� ��由щ떎");
		JCheckBox box5 = new JCheckBox("Yes");
		JCheckBox box6 = new JCheckBox("NO");

		box5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JLabel label4 = new JLabel("�넀�뿉 ���씠 李щ떎");
		JCheckBox box7 = new JCheckBox("YES");
		JCheckBox box8 = new JCheckBox("NO");
		box7.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 10;
			}

		});

		JButton btn1 = new JButton("痍⑥냼");
		JButton btn2 = new JButton("�떎�쓬");

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
					coment = "嫄닿컯�븯�떆�꽕�슂!!!!";
				} else if (count < 41) {
					coment = "�젙�긽踰붿쐞 �씠�궡�엯�땲�떎 醫��뜑 �끂�젰�븯�꽭�슂!";
				} else if (count < 61) {
					coment = "嫄닿컯 醫� 梨숆린�뀛�빞�빐�슂!!!!";
				} else if (count < 81) {
					coment = "�떦�떊 �쐞�뿕�빐!!!!!";
				} else {
					coment = "�뼱�뼸寃� �궡�븘�엳吏�???";
				}
				// �씪踰④컪 �옱�꽕�젙
				counts = Integer.toString(count) + "�젏" + "  " + coment;
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

		JButton btn = new JButton("�솗�씤");
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

		JButton btn = new JButton("異붽�");
		JButton btn2 = new JButton("�닔�젙");
		JButton btn3 = new JButton("�궘�젣");
		JButton btn4 = new JButton("寃뚯떆湲� �솗�씤");
		JButton btn5 = new JButton("�씠�쟾");
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

		//// �뀒�씠釉� 異붽� ////

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

		JLabel label = new JLabel("蹂꾨챸");
		JLabel label2 = new JLabel("�쁺�뼇�젣");
		JLabel label3 = new JLabel("�젣紐�");
		JLabel label4 = new JLabel("�궡�슜");

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

		JLabel label = new JLabel("蹂꾨챸");
		JLabel label2 = new JLabel("�쁺�뼇�젣");
		JLabel label3 = new JLabel("�젣紐�");
		JLabel label4 = new JLabel("�궡�슜");

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

		JButton btn = new JButton("�씠�쟾");

		JLabel label = new JLabel("蹂꾨챸");
		JLabel label1 = new JLabel("�쁺�뼇�젣");
		JLabel label2 = new JLabel("�젣紐�");
		JLabel label3 = new JLabel("�궡�슜");

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