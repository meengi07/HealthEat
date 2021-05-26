package jaeseok.chap02.view;

import java.awt.Choice;
import java.awt.Frame;

import javax.swing.JComboBox;

public class combo extends Frame {
	
        
	
	public void combo() {
		String[] mok= {"조회순","랜덤순"};
		JComboBox strCombo= new JComboBox(mok);
		add(strCombo);
	}
	
	
 
	
	
}
