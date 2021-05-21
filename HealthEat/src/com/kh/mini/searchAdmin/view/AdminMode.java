package com.kh.mini.searchAdmin.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.kh.mini.searchAdmin.controller.NutriManager;
import com.kh.mini.searchAdmin.model.vo.Nutri;

public class AdminMode extends JFrame {

	public static void main(String[] args) {
		new AdminMode();
	}
	
	private NutriManager nm = new NutriManager();
	private AdminNew an = new AdminNew();
	
	//관리자 모드 - 영양제 등록, 수정, 삭제 메뉴
	public AdminMode() {
		
		//----------------------------------------------Main panel
		//창 이름
		JFrame frame = new JFrame("관리자 모드");

		//메인 패널
		JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 0, 840, 840/12*9);
		panelMain.setLayout(null);
		panelMain.setBackground(Color.LIGHT_GRAY);
		
		//패널뷰 조정
		panelMain.setVisible(true);
				
		//검색어 설명
		JLabel search = new JLabel("검색할 키워드 : ");
		search.setLocation(100, 100);
		search.setSize(100, 50);
		
		//검색어 입력창
		JTextField text = new JTextField();
		text.setLocation(200, 100);
		text.setSize(200, 50);
		
		//검색 버튼
		JButton btn = new JButton("검  색");
		btn.setLocation(400, 100);
		btn.setSize(100, 50);
		
		//영양제 목록 출력
		String[] headings = new String[] {"주영양소", "제조사", "용량", "가격", "기타영양소", "효능효과", "인기도"};
		Object[][] data = new Object[][] {
			{"비타민D3", "Now Foods", "120정", 6500, "", "튼튼한 뼈 유지, 면역계 강화", 0},
			{"마그네슘", "Doctor's Best", "120정", 10700, "", "뼈, 심장, 신경 및 근육 건강 지원", 0},
			{"CoQ10", "California Gold Nutrition", "150정", 20000, "", "심혈관계 건강 지원", 0},
			{"LactoBif 프로바이오틱", "California Gold Nutrition", "60정", 22000, "", "소화기관 건강 지원", 0},
			{"프로폴리스", "Y.S. Eco Bee Farms", "90정", 12800, "", "호흡기 건강 지원", 0},
			{"분리유청단백질", "EVLution Nutrition", "1.6파운드", 31000, "", "근육 생성, 근육 회복, 단백질 합성, 근육 강화", 0}
		};
		
		DefaultTableModel model = new DefaultTableModel(data, headings) {
			//게시판 내용 편집 방지처리(셀 내용 수정 금지)
			public boolean isCellEditable(int data, int headings) {
				return false;
			}
		};
		
		JTable table = new JTable(model);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 400)); //뷰포트 기본 크기
		//table.setFillsViewportHeight(true); //테이블이 뷰포트(정보창)를 둘러싸는 높이를 채울지
		//table.setLocation(100, 400);
		//table.setSize(200, 100);
		table.setRowHeight(25); //행 높이 20으로 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(100); //0번째 열너비 100으로 조정
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(80, 200, 500, 200);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//영양제 추가 버튼
		JButton newNutriMain = new JButton("영양제 추가하기");
		newNutriMain.setBounds(200, 440, 200, 50);
		
		//나가기 버튼
		JButton exitMain = new JButton("나가기");
		exitMain.setBounds(200, 500, 200, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panelMain.add(search);
		panelMain.add(text);
		panelMain.add(btn);
		panelMain.add(scroll);
		panelMain.add(newNutriMain);
		panelMain.add(exitMain);
		
		//---------------------------------------------Selected panel
		//-----------------------------메인 영양제 목록에서 클릭해서 조회했을 때
		//전체조회에서 선택된 패널
		JPanel panelSelected = new JPanel();
		panelSelected.setBounds(0, 0, 840, 840/12*9);
		panelSelected.setLayout(null);
		panelSelected.setBackground(Color.LIGHT_GRAY);
		
		//상세정보조회 제목
		JLabel titleSltd = new JLabel("영양제 상세 정보 조회");
		titleSltd.setBounds(200, 100, 250, 50);
		titleSltd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		//상세정보조회 텍스트 상자
		JTextArea txtInfo = new JTextArea(nm.nList.toString()); //nList 넣기
		txtInfo.setEditable(false); //텍스트상자 읽기 전용(not editable)
		JScrollPane txtScroll = new JScrollPane(txtInfo); //txtInfo에 스크롤 넣기
		txtScroll.setBounds(80, 200, 500, 200);
		txtScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelSelected.add(txtScroll);

		//영양제 추가 버튼
		JButton newNutriSltd = new JButton("영양제 추가하기");
		newNutriSltd.setBounds(200, 440, 200, 50);
		
		//나가기 버튼
		JButton exitSltd = new JButton("나가기");
		exitSltd.setBounds(200, 500, 200, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panelSelected.add(titleSltd);
		panelSelected.add(newNutriSltd);
		panelSelected.add(exitSltd);
		
		
		
		//------------------------------------------------이벤트 추가
		//테이블 목록에서 선택하여 더블클릭시 상세 조회로 이동
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow(); //선택한 셀의 행번호
					
					TableModel m = table.getModel(); //테이블의 모델 객체 얻어오기
					
					String basicNutri = (String)m.getValueAt(row, 0);
					String manufac = (String)m.getValueAt(row, 1);
					String quantity = (String)m.getValueAt(row, 2);
					int price = (int)m.getValueAt(row, 3);
					String otherNutri = (String)m.getValueAt(row, 4);
					String effect = (String)m.getValueAt(row, 5);
					int viewCount = (int)m.getValueAt(row, 6);
					
					Nutri value = new Nutri(basicNutri, manufac, quantity, price, otherNutri, effect, viewCount);
					
					txtInfo.setText(value.toString()); //txtInfo 텍스트 상자에 선택한 셀의 내용 출력
					
					panelMain.setVisible(false);
					panelSelected.setVisible(true);
					
				}
			}
		});
		
		//검색 버튼 - 키워드 검색 결과 출력
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//area.append(nm.searchList2); //keyword nList 어떻게 넣지?
				
			}
		});
		
		//영양제 추가버튼 - 추가 페이지로 이동(AdminNew)
		newNutriMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);
				//an.getFrames(); ---> 페이지 이동 구현하기
			}
		});
		
		//나가기 버튼 - 메인 페이지로 이동(맨 처음 로그인 페이지)
		exitMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
	/*	
		JButton btn1 = new JButton("영양제 신규 등록");
		btn1.setLocation(200, 100);
		btn1.setSize(200, 50);
		
		JButton btn2 = new JButton("영양제 정보 수정");
		btn2.setLocation(200, 180);
		btn2.setSize(200, 50);
		
		JButton btn3 = new JButton("영양제 삭제");
		btn3.setLocation(200, 260);
		btn3.setSize(200, 50);
		
		//---나가기 버튼 색깔 다르게 표시하기
		JButton exit = new JButton("나가기");
		exit.setLocation(200, 400);
		exit.setSize(200, 50);
		//exit.setIcon(new ImageIcon("C:\\이미지경로.jpg"));
		//exit.selectedIcon(new ImageIcon("C:\\이미지경로.jpg"));
		//exit.setPressedIcon(new ImageIcon("C:\\이미지경로.jpg")); //버튼 눌렀을 때 이미지
		
		
		//event 넣기
		//영양제 신규 등록 버튼 - 신규 등록 페이지 이동
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//영양제 정보 수정 버튼 - 정보 수정 페이지 이동
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		//영양제 삭제 버튼 - 삭제 페이지 이동
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	*/	
		
		//프레임에 패널 넣기
		frame.add(panelMain);
		
		//프레임 기본 설정
		//frame.setBounds(300,300,500,700);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null); //화면 가운데 뜨게
		frame.setResizable(true); //false : 화면크기 조정 안되도록// true : 화면크기 조정되도록
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
