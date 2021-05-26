package jaeseok.chap02.view;

import java.awt.Choice;
import java.awt.Frame;

public class combo extends Frame {
	
	Choice ch;
	public combo(String str) 
	{
	    super(str);
       
        ch = new Choice();
        
        ch.addItem("치킨");
        ch.addItem("피자");
        ch.addItem("햄버거");
        
        add(ch);
     
    }
 
	
	
}
