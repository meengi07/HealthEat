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

		this.setTitle("���������� UI TEST");
		this.setSize(500, 700);
		// BorderLayout layout = new BorderLayout();
		this.setLayout(null);

		JPanel panel1 = new JPanel(); // ���� ������
		JPanel panel2 = new JPanel(); // �ǰ� üũ ������
		JPanel panel3 = new JPanel(); // �Խ��� ������

		JPanel panel4 = new JPanel(); // �ǰ� üũ ������
		JPanel panel5 = new JPanel(); // �ǰ� Ȯ�� ������
		JPanel panel6 = new JPanel(); // �ǰ� üũ ������2

		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);
		panel6.setVisible(false);

		//

		// ����üũ
		// ���� üũ �޴�
		JButton btn20 = new JButton("Ȯ��");
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
		JLabel label15 = new JLabel("�ǰ� ���� �� �ڸ�Ʈ : " + counts);
		label15.setLocation(100, 100);
		label15.setSize(500, 100);
		panel5.add(label15);
		panel5.add(btn20);

		// ���� ������ ����

		JButton btn1 = new JButton("�ǰ� üũ");
		JButton btn2 = new JButton("���� �Խ���");
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

		// �ǰ� ���� ������ ����

		panel2.setLayout(null);
		panel2.setBounds(0, 0, 500, 700);
		JLabel label1 = new JLabel("�ǰ� üũ�� �����ϽÁٽ��ϱ�?");
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

		// �ǰ����� ������1 _ ���� START

		panel4.setLayout(null);
		panel4.setBounds(0, 0, 500, 700);
		JLabel label10 = new JLabel("�� ���� Ƚ��");
		JCheckBox box1 = new JCheckBox("�� 1ȸ");

		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
				System.out.println(count);

			}

		});

		JCheckBox box2 = new JCheckBox("�� 2~3ȸ");
		box2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;
				System.out.println(count);

			}

		});
		JCheckBox box3 = new JCheckBox("�� 4~5ȸ");
		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;
				System.out.println(count);

			}

		});
		JCheckBox box4 = new JCheckBox("����");
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

		JLabel label11 = new JLabel("�Ϸ� ��� Ƚ��");
		JCheckBox box5 = new JCheckBox("1~5����");
		box5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 1;
				System.out.println(count);
			}

		});
		JCheckBox box6 = new JCheckBox("5~10����");
		box6.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 2;
				System.out.println(count);

			}

		});
		JCheckBox box7 = new JCheckBox("10~15����");
		box7.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count += 3;
				System.out.println(count);

			}

		});
		JCheckBox box8 = new JCheckBox("�� ��");
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

		JLabel label12 = new JLabel("��ħ�� �Ͼ�°� �ǰ��ϰ� �����");
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

		JLabel label13 = new JLabel("�Ǻΰ� ���ƴ�");
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

		JButton btn10 = new JButton("���");
		JButton btn11 = new JButton("����");

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

		JLabel label30 = new JLabel("������ �Ͼ�ų� �������� �����");
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

		JLabel label31 = new JLabel("��ü�� ���� ������ �Ͼ��");
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
		
		
		JLabel label32 = new JLabel("�ٸ��� ������");
		JCheckBox box24 = new JCheckBox("Yes");
		box24.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count +=10;
			}
			
		});
		
		JCheckBox box25 = new JCheckBox("NO");
		label32.setBounds(250, 280, 200, 100);
		box24.setBounds(290, 340, 100, 50);
		box25.setBounds(290, 380, 100, 50);
		
		panel6.add(label32);
		panel6.add(box24);
		panel6.add(box25);

		
		
		JLabel label33 = new JLabel("�տ� ���� ����");
		JCheckBox box26 = new JCheckBox("YES");
		box26.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				count +=10;
			}
			
		});
		
		JCheckBox box27 = new JCheckBox("NO");
		label33.setBounds(20, 280, 200, 100);
		box26.setBounds(60, 340, 100, 50);
		box27.setBounds(60, 380, 100, 50);
		
		panel6.add(label33);
		panel6.add(box26);
		panel6.add(box27);
		
		
		
		
		
		JButton btn30 = new JButton("���");
		JButton btn31 = new JButton("����");

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
					coment = "�ǰ��Ͻó׿�!!!!";
				} else if (count < 41) {
					coment = "������� �̳��Դϴ� ���� ����ϼ���!";
				} else if (count < 61) {
					coment = "�ǰ� �� ì��ž��ؿ�!!!!";
				} else if (count < 81) {
					coment = "��� ������!!!!!";
				} else {
					coment = "��� �������???";
				}
				// �󺧰� �缳��
				counts = Integer.toString(count) + "��" + "\t" + coment;
				count = 0;
				label15.setText(counts);
				label15.repaint();
				// üũ �ڽ� �ʱ�ȭ
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

		// �����̳ʿ� ���� ������ panel �߰�
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new Main();
	}

}
