package jaeseok.chap01_container.run;

import javax.swing.JFrame;

import jaeseok.chap01_container.view.list;
	

 
public class Run extends JFrame
{
	
	list u = new list();	
	
			
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
