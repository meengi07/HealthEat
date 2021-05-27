package jaeseok.chap02.run;



import javax.swing.JFrame;

import jaeseok.chap02.view.k_list;
	

 
public class Run extends JFrame
{
	
	k_list u = new k_list();	
	
			
	public Run() {
		
		
		this.setSize(800, 600);
        this.setResizable(true);      
        this.add(u.klist());
       // this.add(u.klist2());     
      //  this.add(u.klist3());
        this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
	
		new Run();
	
	}
	
}
