package com.kh.tm1.chat.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener, Runnable{

	private JTextArea area = new JTextArea();
	private JTextField field = new JTextField();
	
	
	private Socket socket = null;
	private int port = 1234;
	private String IP = "172.30.1.36";
	
	
	public Client() {
		// TODO Auto-generated constructor stub
		
		setTitle("1대1 문의(방문자)");
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(pane, BorderLayout.EAST);
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		
		field.addActionListener(this);
		
	}
	
	public void connect() {
		
		try {
			socket = new Socket(IP, port); //아이피주소와 포트번호로 소켓 생성
			
			Thread th = new Thread(this); // 채팅시 시작하라고 스레드 설정
			th.start();
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			area.append("연결 오류");
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//채팅창 기능
		String msg = field.getText();
		
		if(msg.equals(""))
			return;
					
		if(socket==null)
			return;
		
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true); // true = auto flush
			
			pw.println("방문자 : "+msg);
			area.append("방문자 : "+msg + "\n");
			field.setText(" "); // 비워주기
			field.requestFocus(); // 이벤트 받을 컴포넌트 설정
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			area.append("\n,서버와 연결 종료.");
			socket = null; // 소켓 초기화
		}
		
	}
	
	public void run() {
		
		String msg;
		
		
		InputStream is;
		try {
			
			
			if(socket==null) {
				return;
			}
			
			is = socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			area.append("접속완료\n" );
			
			
			while((msg=br.readLine())!= null) {
				area.append(msg+"\n");
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			area.append("\n, 서버와 연결 종료.");
			socket = null;
			
		}
		
		
	}
	
	
}
