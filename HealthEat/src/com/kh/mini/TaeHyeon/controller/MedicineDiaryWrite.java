package com.kh.mini.TaeHyeon.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MedicineDiaryWrite extends JFrame implements ActionListener{
	
	JLabel todayDate = new JLabel("현재 날짜", JLabel.CENTER);
	JLabel textDate = new JLabel();
	JTextArea textAreaWriteUp = new JTextArea();
	JButton svaeButton = new JButton("등록하기");
	JButton cancelButton = new JButton("취소하기");
	
	public MedicineDiaryWrite() {
		
		// 이 텍스트 저장 파일이 현재 복용 일기 작성 란과 연동되어야 함
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
