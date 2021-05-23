package com.kh.mini.searchAdmin.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

import com.kh.mini.searchAdmin.controller.NutriManager;

public class AdminEdit extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdminEdit();
	}
	
	private NutriManager nm = new NutriManager();
	
	//관리자 모드 - 영양제 정보 수정, 삭제
	public AdminEdit() {
		//창 이름
		JFrame frame = new JFrame("영양제 정보 수정");
		
		//정보 수정 패널
		JPanel panelEdit = new JPanel();
		panelEdit.setBounds(0, 0, 840, 840/12*9);
		panelEdit.setLayout(null);
		panelEdit.setBackground(Color.LIGHT_GRAY);
		
		JLabel search = new JLabel("검색된 결과");
		search.setLocation(40, 100);
		search.setSize(200, 50);
		search.setHorizontalAlignment(SwingConstants.CENTER);
		search.setFont(new Font("Tahoma", Font.PLAIN, 21));

		//---여기에 영양제 목록 출력(스크롤바)
	/*	
		DefaultTableModel model = new DefaultTableModel(data, headings) {
			//게시판 내용 편집 방지처리(셀 내용 수정 금지)
			public boolean isCellEditable(int data, int headings) {
				return false;
			}
		};
	*/	
		JTable table = new JTable((TableModel) nm.nList);
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
		
		
		/*
		JTextArea area = new JTextArea(nm.nList.toString()); //nList 넣기
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	//textarea에 스크롤 넣기
		area.setLocation(40, 200);
		area.setSize(500, 200);
		*/
		
		//---버튼 위치 수정하기
		JButton edit = new JButton("수정하기");
		edit.setLocation(150, 420);
		edit.setSize(200, 50);
		
		JButton delete = new JButton("삭제하기");
		delete.setLocation(350, 420);
		delete.setSize(200, 50);
		
		JButton exit = new JButton("돌아가기");
		exit.setLocation(200, 500);
		exit.setSize(200, 50);
		
		
		//event 넣기
		//영양제 수정 버튼 - 수정 페이지로 이동
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//영양제 삭제 버튼 - 영양제 삭제하기(삭제확인 팝업, 해당인덱스 데이터 지우기)
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//팝업창
				int answer = JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					
				}
			}
		});
		
		
		//돌아가기 버튼 - admin 메인 페이지로 이동
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		

		//프레임에 패널 넣기
		frame.add(panelEdit);
		
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
