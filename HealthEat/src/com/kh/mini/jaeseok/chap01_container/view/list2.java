package jaeseok.chap01_container.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class list2 extends JFrame{
	
	public list2()
    {
        
	    JFrame frame = new JFrame("�α⿵���� ��õ(����)");		
		JPanel panel = new JPanel();			
		JLabel title= new JLabel("�α⿵���� ��õ",JLabel.LEFT);
		JLabel gender= new JLabel("����");			
		panel.setBounds(200,200,200,200);
		panel.setLayout(null);
        panel.setVisible(true);			
		String title2[] = {"����", "�̸�", "�����" , "����"};
        JButton btn1 = new JButton("���ư���");
        JButton btn2 = new JButton("Next");
        JButton btn3 = new JButton("����");
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
                {"����", "�̸�", "�����", "����"},
                {"1", "B��", "A����", "1000"},
                {"2", "C��", "A����", "1000"},
                {"3", "C��", "A����", "1000"},
                {"4", "C��", "A����", "1000"},
                {"5", "C��", "A����", "1000"},
                {"6", "C��", "A����", "1000"},
                {"7", "D��", "A����", "1000"}
        };
        
        JTable table = new JTable(data, title2);
        table.setBounds(110,200,600,400);	        
        title.setBounds(360,50,100,100);
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
        frame.setLocationRelativeTo(null); //ȭ�� ��� �߰�
        frame.setResizable(true); //false : ȭ��ũ�� ���� �ȵǵ���// true : ȭ��ũ�� �����ǵ���
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list3 ui = new list3();
			}
			
			
		});
        btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list ui = new list();
			}
			
			
		});

    	    
    }
}
