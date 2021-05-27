package chat.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener,Runnable{

	
	private JTextArea area = new JTextArea();
	private JTextField field = new JTextField();
	
	
	
	//서버는 서버소켓, 소캣 둘다 있어야함
	private ServerSocket serversocket = null;
	private Socket socket = null;
	
	
	public Server() {
		// TODO Auto-generated constructor stub
		
		setTitle("1대1 문의(관리자)");
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		area.setEditable(false); //수정 못함
		
		
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		
		//택스트창 입력
		field.addActionListener(this);

		
		
		this.addWindowListener(new WindowAdapter() {
			
			 public void windowClosing(WindowEvent e) {
				 
				 
				 dispose(); //창 닫으면  열려있던 채팅창만 닫히ㅔ게
			 }
			
		});
		
		
	}
	
	public void serverStart() {
		try {
			serversocket = new ServerSocket(1234);
			area.setText("방문자 대기중...");
			
			socket = serversocket.accept(); //accept() => 서버소켓과 소켓 연결,  클라이언트 실행할때까지 대기
			
			Thread th = new Thread(this); //스레드 지정 (여려개 실행하기우해)
			th.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() { //채팅창 데이터 수신
		// TODO Auto-generated method stub
		
		String msg;
		
		try {
			if(socket==null) { // null이면 클라이언트가 아직 접속을 안한 상태
				return;
			}
			
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			area.append("\r\n 방문자 접속");
			
			while((msg=br.readLine()) != null) {
			area.append("\r\n" + msg);
			
			}
		} catch (IOException e) {
			
			area.append("\r\n 방문자와 연결 종료.");
			
			
			//다른값이 들어있음.. 비워줘야함
			socket = null;
			serversocket = null;
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String msg = field.getText();
		
		if(msg.trim().equals("")) { //공백 없애고  null이면 안보냄
			return;
		}
		
		if(socket==null) {
			return;
		}
		
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			
			pw.println("healtheat : "+msg);
			area.append("\r\n healtheat : "+ msg);
			field.setText("");
			field.requestFocus();
			
			
		} catch (IOException e1) {
			//채팅중 에러 발생하면 
			
			area.append("\r\n 방문자와 연결 종료.");
			socket = null;
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server se = new Server();
		se.serverStart();
		
	}
	
}
