package jaeseok.chap02.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class k_list3 extends JFrame {
	public k_list3()
    {
        
	    JFrame frame = new JFrame("������ ������ ��õ(����)");		
		JPanel panel = new JPanel();			
		JLabel title= new JLabel("������ ������ ��õ",JLabel.LEFT);
		JLabel gender= new JLabel("����");			
		panel.setBounds(200,200,200,200);
		panel.setLayout(null);
        panel.setVisible(true);			
		String title2[] = {"�ֿ����", "������" , "����"};
        JButton btn1 = new JButton("���ư���");
        JButton btn2 = new JButton("Prev");
        JButton btn3 = new JButton("����");
        String[] mok= {"��ȸ��","������"};
		JComboBox strCombo= new JComboBox(mok);	
        btn1.setBounds(350, 400, 100, 50);
        btn2.setBounds(110, 330, 100, 50);
        btn3.setBounds(110, 140, 100, 50);
        strCombo.setBounds(610, 140, 100, 50);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(btn3);
        getContentPane().add(strCombo);
        String data[][] = {
        		  {"��Ÿ��D3", "Now Foods", "6500"},
                  {"���׳׽�", "Doctor's Best", "10700"},
                  {"CoQ10", "California Gold Nutrition", "20000"},
                  {"LactoBif ���ι��̿�ƽ", "California Gold Nutrition", "22000"},
                  {"����������", "Y.S. Eco Bee Farms", "12800"},
                  {"�и���û�ܹ���", "EVLution Nutrition", "31000"}
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
        frame.add(panel);
        panel.add(strCombo);
        frame.setPreferredSize(new Dimension(840, 840/12*9));
        frame.setSize(840, 840/12*9);
        frame.setLocationRelativeTo(null); //ȭ�� ��� �߰�
        frame.setResizable(true); //false : ȭ��ũ�� ���� �ȵǵ���// true : ȭ��ũ�� �����ǵ���
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
