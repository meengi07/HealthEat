package jaeseok.chap02.view;

import java.awt.Choice;
import java.awt.Frame;

public class combo extends Frame {
	
	Choice ch;
	public combo(String str) 
	{
	    super(str);
       
        ch = new Choice();
        
        ch.addItem("ġŲ");
        ch.addItem("����");
        ch.addItem("�ܹ���");
        
        add(ch);
     
    }
 
	
	
}
