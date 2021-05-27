package chat.controller;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.Socket;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Client extends JFrame implements ActionListener, Runnable{
	
	
			
	private JTextArea area = new JTextArea();
	private JTextField field = new JTextField();

	
	//클라이언트는 소캣만
	private Socket socket = null;
	private int port = 1234; //포트번호
	private String IP = "172.30.51.18"; // 바뀔때마다 바꿔야함(네트워크 주소)
	
	public Client() {
		// TODO Auto-generated constructor stub
		
		
		setTitle("1대1 문의(방문자)");//채팅창 이름
		setSize(300,400);// 채팅창 사이즈
		setVisible(true); //화면 보이게
		
	
		this.addWindowListener(new WindowAdapter() { // 종료할때 대화내용 택스트파일로 저장
			
			  public void windowClosing(WindowEvent e) { 
				  
				BufferedWriter bw1;
				
				try {
					bw1 = new BufferedWriter(new FileWriter("채팅내용 저장.txt"));
					bw1.write(area.getText()); //area 내용을 파일로
					System.out.println(area.getText()); // 입력되는지 확인용임
					bw1.close(); // 사용후 꼭 닫아줘야함
	                  dispose(); // 닫으면 전으로 ( 메뉴바 안꺼지고 채팅만 끔)
	                  
	          
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
			  }
			  
		});	
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 화면꺼지게
		area.setEditable(false); // 대화내용 수정 불가
		
		
		add(area, BorderLayout.CENTER); //채팅화면
		add(field, BorderLayout.SOUTH);	//대화 입력칸

		
		//택스트 입력창에 입력할수있게
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
	public void actionPerformed(ActionEvent e) { //메세지 전송용
		
		String msg = field.getText();
		
		if(msg.equals("")) //  입력받은 내용이 없으면  안보내짐
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
			area.append("\n서버와 연결 종료.");
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
			area.append("\n서버와 연결 종료.");
			socket = null;
			
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


		new Client().connect();
	
	}

	
	
}
