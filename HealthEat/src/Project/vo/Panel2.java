package Project.vo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;


public class Panel2 extends JFrame {

	private JTable table;
	private String[] header = new String[] { "별명", "영양제", "제목", "내용" };

	DefaultTableModel model = new DefaultTableModel(header, 0) {
		public boolean isCellEditable(int header, int data) {
			// 테이블 내용 수정 방지
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

	//tablecontroller tablecont = new tablecontroller();

	public Panel2() {
		reviewAddPenal.setVisible(false);
		reviewDelPenal.setVisible(false);
		reviewplusPenal.setVisible(false);

	}

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
		btn.setBounds(100, 100, 80, 80);
		btn2.setBounds(200, 100, 80, 80);
		btn3.setBounds(300, 100, 80, 80);
		btn4.setBounds(260, 500, 150, 60);
		reviewMainPenal.add(btn);
		reviewMainPenal.add(btn2);
		reviewMainPenal.add(btn3);
		reviewMainPenal.add(btn4);

		//// 테이블 추가 ////

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reviewAddPenal.setVisible(true);
				reviewMainPenal.setVisible(false);
			}

		});

		/// 테이블 수정///
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

		/// 테이블 삭제///
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

		JButton btn = new JButton("추가");

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

		JButton btn = new JButton("수정");
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
