package jaeseok.chap01_container.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class list extends JFrame {
	int count =0;	
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	
	public list() {
		panel.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
	}
	
	
	
	public JPanel klist() {
		
		
		JLabel title = new JLabel("�α⿵���� ��õ", JLabel.LEFT);
		JLabel gender = new JLabel("����");					
		panel.setLayout(null);
		String title2[] = { "�ֿ����", "������", "����" };
		JButton btn1 = new JButton("���ư���");
		JButton btn2 = new JButton("Next");	
		String[] mok = {"��ȸ��","������"};
		JComboBox strCombo = new JComboBox(mok);
		btn1.setBounds(350, 390, 100, 50);
		//btn2.setBounds(600, 310, 100, 50);
		strCombo.setBounds(600, 140, 100, 50);
	
		
		JButton btn10 = new JButton("Next");
		btn10.setBounds(600, 310, 100, 50);
		btn10.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count == 0) {
				gender.setText("����");
				++count;
				}else if(count ==1) {
					gender.setText("����");
					++count;
				}else if (count ==2){
					gender.setText("����");
					count =0;
				}
			}
			
		});
		panel.add(btn10);
		
		String data[][] = { 
				{ "���׳׽�", "Doctor's Best", "10700" }, 
				{ "����������", "Y.S. Eco Bee Farms", "12800" },
				{ "LactoBif ���ι��̿�ƽ", "California Gold Nutrition", "22000" },
				{ "�и���û�ܹ���", "EVLution Nutrition", "31000" },
				{ "CoQ10", "California Gold Nutrition", "20000" },
				{ "��Ÿ��D3", "Now Foods", "6500" }, };

		JTable table = new JTable(data, title2);
		String data2[][] = { 			
				{ "�и���û�ܹ���", "EVLution Nutrition", "31000" },
				{ "���׳׽�", "Doctor's Best", "10700" }, 
				{ "CoQ10", "California Gold Nutrition", "20000" },
				{ "����������", "Y.S. Eco Bee Farms", "12800" },
				{ "��Ÿ��D3", "Now Foods", "6500" }, 
		        { "LactoBif ���ι��̿�ƽ", "California Gold Nutrition", "22000" },};
		JTable table2 = new JTable(data2, title2);
		table.setBounds(100, 200, 600, 100);
		table2.setBounds(100, 200, 600, 100);
	    title.setBounds(360, 50, 150, 100);
		gender.setBounds(390, 150, 50, 50);
		panel.add(title);
		panel.add(gender);
		panel.add(table);
		panel.add(table2);
		panel.add(btn1);
		//panel.add(btn2);
		panel.add(strCombo);
      
		strCombo.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count == 0) {
					table.setVisible(false);
					table2.setVisible(true);
				++count;
				}else if(count ==1) {
					table.setVisible(true);
					table2.setVisible(false);
					count =0;
				}
			}
			
		});
		
		return panel;
	}

	public JPanel klist2() {
		
		
		JLabel title = new JLabel("�α⿵���� ��õ", JLabel.LEFT);
		JLabel gender = new JLabel("����");					
		panel2.setLayout(null);
		String title2[] = { "�ֿ����", "������", "����" };
		JButton btn1 = new JButton("���ư���");
		JButton btn2 = new JButton("Next");		
		JButton btn4 = new JButton("Prev");
		String[] mok = {"��ȸ��","������"};
		JComboBox strCombo = new JComboBox(mok);
		btn1.setBounds(350, 390, 100, 50);
		btn2.setBounds(600, 310, 100, 50);		
		btn4.setBounds(100, 310, 100, 50);
		strCombo.setBounds(600, 140, 100, 50);
		
		String data[][] = { 
				{ "���׳׽�", "Doctor's Best", "10700" }, 
				{ "����������", "Y.S. Eco Bee Farms", "12800" },
				{ "LactoBif ���ι��̿�ƽ", "California Gold Nutrition", "22000" },
				{ "�и���û�ܹ���", "EVLution Nutrition", "31000" },
				{ "CoQ10", "California Gold Nutrition", "20000" },
				{ "��Ÿ��D3", "Now Foods", "6500" }, };

		JTable table = new JTable(data, title2);
		table.setBounds(100, 200, 600, 100);
	    title.setBounds(360, 50, 150, 100);
		gender.setBounds(390, 150, 50, 50);
		panel2.add(title);
		panel2.add(gender);
		panel2.add(table);
		panel2.add(btn1);
		panel2.add(btn2);
	
		panel2.add(btn4);
		panel2.add(strCombo);
       
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(true);
				panel2.setVisible(false);			
			}

		});
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel2.setVisible(false);			
			}

		});
		
		return panel2;
	}


public JPanel klist3() {
	
	
	JLabel title = new JLabel("�α⿵���� ��õ", JLabel.LEFT);
	JLabel gender = new JLabel("����");					
	panel3.setLayout(null);
	String title2[] = { "�ֿ����", "������", "����" };
	JButton btn1 = new JButton("���ư���");
	JButton btn2 = new JButton("Prev");

	String[] mok = {"��ȸ��","������"};
	JComboBox strCombo = new JComboBox(mok);
	btn1.setBounds(350, 390, 100, 50);
	btn2.setBounds(100, 310, 100, 50);
	
	strCombo.setBounds(600, 140, 100, 50);
	
	String data[][] = { 
			{ "���׳׽�", "Doctor's Best", "10700" }, 
			{ "����������", "Y.S. Eco Bee Farms", "12800" },
			{ "LactoBif ���ι��̿�ƽ", "California Gold Nutrition", "22000" },
			{ "�и���û�ܹ���", "EVLution Nutrition", "31000" },
			{ "CoQ10", "California Gold Nutrition", "20000" },
			{ "��Ÿ��D3", "Now Foods", "6500" }, };

	JTable table = new JTable(data, title2);
	table.setBounds(100, 200, 600, 100);
    title.setBounds(360, 50, 150, 100);
	gender.setBounds(390, 150, 50, 50);
	panel3.add(title);
	panel3.add(gender);
	panel3.add(table);
	panel3.add(btn1);
	panel3.add(btn2);
	
	panel3.add(strCombo);

	btn2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			list ui = new list();
		
		}

	});
	return panel3;
}
}
