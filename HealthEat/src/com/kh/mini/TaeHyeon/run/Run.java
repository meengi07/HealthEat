package com.kh.mini.TaeHyeon.run;

import javax.swing.JFrame;

import com.kh.mini.TaeHyeon.view.mainPanel;
import com.sun.java.swing.plaf.windows.resources.windows;

public class Run extends JFrame{
	
	mainPanel mp = new mainPanel();
	
	
	public Run() {
		//실행 코드입니다.
		this.setLayout(null);
		this.setTitle("복용 일기 메인메뉴");
		this.setBounds(600, 100, 600, 900);
		// this.setSize(600, 800);
		this.setResizable(false); // 사이즈 수정 불가
		
		this.add(mp.seeJPanel());
		this.add(mp.mainPanelUI());
		this.add(mp.writeJPanelUI());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		new Run();

	}

}
