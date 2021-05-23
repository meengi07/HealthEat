package com.kh.mini.searchAdmin.mvc.view;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.kh.mini.searchAdmin.mvc.controller.NutriManager2;
import com.kh.mini.searchAdmin.mvc.model.vo.Nutri;

public class AdminRead2 extends JFrame {
	
	//관리자 모드 - 영양제 정보 조회 후 수정, 삭제 선택
	NutriManager2 nm = new NutriManager2();
	String[] headings = new String[] {"주영양소", "제조사", "용량", "가격", "기타영양소", "효능효과", "인기도"};
	DefaultTableModel model = new DefaultTableModel(headings, 0) {
		public boolean isCellEditable(int headings, int data) {
			//테이블 내용 수정 방지
			return false;
		}
	};
	int row = 0;
	
	//nList 전체 출력하는 메소드
	public void showAllList() {
		for (int i = 0; i < nm.nList.size(); i++) {
			Object[] data = {nm.nList.get(i).getBasicNutri(), nm.nList.get(i).getManufac(), 
					nm.nList.get(i).getQuantity(), nm.nList.get(i).getPrice(), nm.nList.get(i).getOtherNutri(),
					nm.nList.get(i).getEffect(), 0};
			model.addRow(data);
		}
	}
	
	public AdminRead2() {
		//창 이름
		JFrame frame = new JFrame("관리자 모드");
		
		//정보 수정 패널
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 840, 840/12*9);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel search = new JLabel("검색된 결과");
		search.setBounds(200, 30, 200, 50);
		search.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		//영양제 목록 출력
		JTable table = new JTable(model);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 400)); //뷰포트 기본 크기
		//table.setFillsViewportHeight(true); //테이블이 뷰포트(정보창)를 둘러싸는 높이를 채울지
		table.setRowHeight(25); //행 높이 25로 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(100); //0번째 열너비 100으로 조정
		table.setModel(model);
		showAllList();
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(80, 200, 500, 200);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
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
		
		//패널에 레이블, 버튼 등 붙이기
		panel.add(search);
		panel.add(scroll);
		panel.add(edit);
		panel.add(delete);
		panel.add(exit);
		
		//event 넣기
		//마우스 클릭시 row 객체 선택하기
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
			}
		});
		
		//영양제 수정 버튼 - 수정 페이지로 이동
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//--------------------------------선택한 row의 정보 AdminEdit의 textfield에 넣기?
				int row = table.getSelectedRow(); //선택한 셀의 행번호
				
				TableModel m = table.getModel(); //테이블의 모델 객체 얻어오기
				
				String basicNutri = (String)m.getValueAt(row, 0);
				String manufac = (String)m.getValueAt(row, 1);
				String quantity = (String)m.getValueAt(row, 2);
				String price = (String)m.getValueAt(row, 3);
				String otherNutri = (String)m.getValueAt(row, 4);
				String effect = (String)m.getValueAt(row, 5);
				int viewCount = (int)m.getValueAt(row, 6);
				
				Nutri value = new Nutri(basicNutri, manufac, quantity, price, otherNutri, effect, viewCount);
				//----------------------------------------------------------------------
				
				AdminEdit2 flip = new AdminEdit2();
				flip.setVisible(true);
				frame.dispose();
			}
		});
		
		//영양제 삭제 버튼 - 영양제 삭제하기(삭제확인 팝업, 해당인덱스 데이터 지우기)
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//팝업창
				int answer = JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					//---------------------------데이터 삭제기능 추가하기
					model.removeRow(row);
					nm.nList.remove(row);
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					
				}
			}
		});
		
		
		//돌아가기 버튼 - AdminMode 메인 페이지로 이동
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminMode2 flip = new AdminMode2();
				flip.setVisible(true);
				frame.dispose();
			}
		});
		

		//프레임에 패널 넣기
		frame.add(panel);
		
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
