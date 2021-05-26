package jaeseok.chap02.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


public class k_list2 extends JFrame {
	public k_list2()
    {
        
	    JFrame frame = new JFrame("오늘의 영양제 추천(여성)");		
		JPanel panel = new JPanel();			
		JLabel title= new JLabel("오늘의 영양제 추천",JLabel.LEFT);
		JLabel gender= new JLabel("여성");			
		panel.setBounds(200,200,200,200);
		panel.setLayout(null);
        panel.setVisible(true);			
		String title2[] = {"주영양소", "제조사" , "가격"};
        JButton btn1 = new JButton("돌아가기");
        JButton btn2 = new JButton("Next");
        JButton btn3 = new JButton("수정");
        JButton btn4 = new JButton("Prev");
        btn1.setBounds(350, 400, 100, 50);
        btn2.setBounds(610, 330, 100, 50);
        btn3.setBounds(110, 140, 100, 50);
        btn4.setBounds(110, 330, 100, 50);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(btn3);
        getContentPane().add(btn4);
        String data[][] = {
        		  {"비타민D3", "Now Foods", "6500"},
                  {"마그네슘", "Doctor's Best", "10700"},
                  {"CoQ10", "California Gold Nutrition", "20000"},
                  {"LactoBif 프로바이오틱", "California Gold Nutrition", "22000"},
                  {"프로폴리스", "Y.S. Eco Bee Farms", "12800"},
                  {"분리유청단백질", "EVLution Nutrition", "31000"}
        };
        
        JTable table = new JTable(data, title2);
        table.setBounds(110,200,600,100);	        
        title.setBounds(360,50,150,100);
        gender.setBounds(390,150,50,50);	
        panel.add(title);
        panel.add(gender);
        panel.add(table);
  	    frame.add(btn1);
        frame.add(btn2);	              	        
        frame.add(btn3);
        frame.add(btn4);
        frame.add(panel);
        frame.setPreferredSize(new Dimension(840, 840/12*9));
        frame.setSize(840, 840/12*9);
        frame.setLocationRelativeTo(null); //화면 가운데 뜨게
        frame.setResizable(true); //false : 화면크기 조정 안되도록// true : 화면크기 조정되도록
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				k_list3 ui = new k_list3();
			}
			
			
		});
        btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				k_list ui = new k_list();
			}
			
			
		});

    	    
    }
}
