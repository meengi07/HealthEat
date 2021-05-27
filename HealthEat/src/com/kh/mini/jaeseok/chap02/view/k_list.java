package jaeseok.chap02.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class k_list extends JFrame {
	int count =0;	
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	
	public k_list() {
		panel.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
	}
	
	
	
	public JPanel klist() {
		
		
		JLabel title = new JLabel("오늘의 영양제 추천", JLabel.LEFT);
		JLabel gender = new JLabel("남성");					
		panel.setLayout(null);
		String title2[] = { "주영양소", "제조사", "가격" };
		JButton btn1 = new JButton("돌아가기");
		JButton btn2 = new JButton("Next");	
		String[] mok = {"조회순","랜덤순"};
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
				gender.setText("여성");
				++count;
				}else if(count ==1) {
					gender.setText("종합");
					++count;
				}else if (count ==2){
					gender.setText("남성");
					count =0;
				}
			}
			
		});
		panel.add(btn10);
		
		String data[][] = { 
				{ "마그네슘", "Doctor's Best", "10700" }, 
				{ "프로폴리스", "Y.S. Eco Bee Farms", "12800" },
				{ "LactoBif 프로바이오틱", "California Gold Nutrition", "22000" },
				{ "분리유청단백질", "EVLution Nutrition", "31000" },
				{ "CoQ10", "California Gold Nutrition", "20000" },
				{ "비타민D3", "Now Foods", "6500" }, };

		JTable table = new JTable(data, title2);
		String data2[][] = { 			
				{ "분리유청단백질", "EVLution Nutrition", "31000" },
				{ "마그네슘", "Doctor's Best", "10700" }, 
				{ "CoQ10", "California Gold Nutrition", "20000" },
				{ "프로폴리스", "Y.S. Eco Bee Farms", "12800" },
				{ "비타민D3", "Now Foods", "6500" }, 
		        { "LactoBif 프로바이오틱", "California Gold Nutrition", "22000" },};
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
		
		
		JLabel title = new JLabel("오늘의 영양제 추천", JLabel.LEFT);
		JLabel gender = new JLabel("여성");					
		panel2.setLayout(null);
		String title2[] = { "주영양소", "제조사", "가격" };
		JButton btn1 = new JButton("돌아가기");
		JButton btn2 = new JButton("Next");		
		JButton btn4 = new JButton("Prev");
		String[] mok = {"조회순","랜덤순"};
		JComboBox strCombo = new JComboBox(mok);
		btn1.setBounds(350, 390, 100, 50);
		btn2.setBounds(600, 310, 100, 50);		
		btn4.setBounds(100, 310, 100, 50);
		strCombo.setBounds(600, 140, 100, 50);
		
		String data[][] = { 
				{ "마그네슘", "Doctor's Best", "10700" }, 
				{ "프로폴리스", "Y.S. Eco Bee Farms", "12800" },
				{ "LactoBif 프로바이오틱", "California Gold Nutrition", "22000" },
				{ "분리유청단백질", "EVLution Nutrition", "31000" },
				{ "CoQ10", "California Gold Nutrition", "20000" },
				{ "비타민D3", "Now Foods", "6500" }, };

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
	
	
	JLabel title = new JLabel("오늘의 영양제 추천", JLabel.LEFT);
	JLabel gender = new JLabel("종합");					
	panel3.setLayout(null);
	String title2[] = { "주영양소", "제조사", "가격" };
	JButton btn1 = new JButton("돌아가기");
	JButton btn2 = new JButton("Prev");

	String[] mok = {"조회순","랜덤순"};
	JComboBox strCombo = new JComboBox(mok);
	btn1.setBounds(350, 390, 100, 50);
	btn2.setBounds(100, 310, 100, 50);
	
	strCombo.setBounds(600, 140, 100, 50);
	
	String data[][] = { 
			{ "마그네슘", "Doctor's Best", "10700" }, 
			{ "프로폴리스", "Y.S. Eco Bee Farms", "12800" },
			{ "LactoBif 프로바이오틱", "California Gold Nutrition", "22000" },
			{ "분리유청단백질", "EVLution Nutrition", "31000" },
			{ "CoQ10", "California Gold Nutrition", "20000" },
			{ "비타민D3", "Now Foods", "6500" }, };

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
			k_list ui = new k_list();
		
		}

	});
	return panel3;
}
}
