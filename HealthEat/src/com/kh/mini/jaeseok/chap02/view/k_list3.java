package jaeseok.chap02.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class k_list3 extends JFrame {
	public k_list3()
    {
        
	    JFrame frame = new JFrame("오늘의 영양제 추천(종합)");		
		JPanel panel = new JPanel();			
		JLabel title= new JLabel("오늘의 영양제 추천",JLabel.LEFT);
		JLabel gender= new JLabel("종합");			
		panel.setBounds(200,200,200,200);
		panel.setLayout(null);
        panel.setVisible(true);			
		String title2[] = {"순위", "이름", "제약사" , "가격"};
        JButton btn1 = new JButton("돌아가기");
        JButton btn2 = new JButton("Prev");
        JButton btn3 = new JButton("수정");
        btn1.setBounds(350, 400, 100, 50);
        btn2.setBounds(110, 330, 100, 50);
        btn3.setBounds(110, 140, 100, 50);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(btn3);
        String data[][] = {
                {"순위", "이름", "제약사", "가격"},
                {"1", "B약", "A제약", "1000"},
                {"2", "C약", "A제약", "1000"},
                {"3", "C약", "A제약", "1000"},
                {"4", "C약", "A제약", "1000"},
                {"5", "C약", "A제약", "1000"},
                {"6", "C약", "A제약", "1000"},
                {"7", "D약", "A제약", "1000"}
        };
        
        JTable table = new JTable(data, title2);
        table.setBounds(110,200,600,400);	        
        title.setBounds(360,50,150,100);
        gender.setBounds(390,150,50,50);	
        panel.add(title);
        panel.add(gender);
        panel.add(table);
  	    frame.add(btn1);
        frame.add(btn2);	              	        
        frame.add(btn3);
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
				k_list2 ui = new k_list2();
			}
			
		});
        

    	    
    }
}
