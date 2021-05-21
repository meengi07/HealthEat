package com.kh.mini.searchAdmin.mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.kh.mini.searchAdmin.mvc.controller.NutriManager2;
import com.kh.mini.searchAdmin.mvc.model.vo.Nutri;

public class AdminMode2 extends JFrame implements MouseListener, ActionListener {
	
	//관리자 모드 - 영양제 등록, 수정, 삭제 메뉴
	NutriManager2 nm = new NutriManager2();
	String[] headings = new String[] {"주영양소", "제조사", "용량", "가격", "기타영양소", "효능효과", "인기도"};
	DefaultTableModel model = new DefaultTableModel(headings, 0) {
		public boolean isCellEditable(int headings, int data) {
			//테이블 내용 수정 방지
			return false;
		}
	};
	int row = 0;
	
	JFrame frame;
	JPanel panelMain, panelSelected;
	JLabel search, titleSltd;
	JTextField text;
	JButton btn, newNutriMain, exitMain, editNutriSltd, delNutriSltd, exitSltd;
	JTable table;
	
	//nList 전체 출력하는 메소드
	public void showAllList() {
		for (int i = 0; i < nm.nList.size(); i++) {
			Object[] data = {nm.nList.get(i).getBasicNutri(), nm.nList.get(i).getManufac(), 
					nm.nList.get(i).getQuantity(), nm.nList.get(i).getPrice(), nm.nList.get(i).getOtherNutri(),
					nm.nList.get(i).getEffect(), 0};
			model.addRow(data);
		}
	}

	public void keywordSearch() {
		model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(text.getText().trim()));
	}
	
	public AdminMode2() {
		
		//----------------------------------------------Main panel
		//창 이름
		frame = new JFrame("관리자 모드");

		//메인 패널
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 840, 840/12*9);
		panelMain.setLayout(null);
		panelMain.setBackground(Color.LIGHT_GRAY);
		
		//패널뷰 조정
		panelMain.setVisible(true);
				
		//검색어 설명
		search = new JLabel("검색할 키워드 : ");
		search.setLocation(100, 100);
		search.setSize(100, 50);
		
		//검색어 입력창
		text = new JTextField();
		text.setLocation(200, 100);
		text.setSize(200, 50);
		
		//검색 버튼
		btn = new JButton("검  색");
		btn.setLocation(400, 100);
		btn.setSize(100, 50);
		
		//영양제 목록 출력
		table = new JTable(model);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 400)); //뷰포트 기본 크기
		//table.setFillsViewportHeight(true); //테이블이 뷰포트(정보창)를 둘러싸는 높이를 채울지
		//table.setLocation(100, 400);
		//table.setSize(200, 100);
		table.setRowHeight(25); //행 높이 20으로 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(100); //0번째 열너비 100으로 조정
		table.setModel(model);
		showAllList();
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(80, 200, 500, 200);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//영양제 추가 버튼
		newNutriMain = new JButton("영양제 추가하기");
		newNutriMain.setBounds(200, 440, 200, 50);
		
		//나가기 버튼
		exitMain = new JButton("나가기");
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
		panelSelected = new JPanel();
		panelSelected.setBounds(0, 0, 840, 840/12*9);
		panelSelected.setLayout(null);
		panelSelected.setBackground(Color.LIGHT_GRAY);
		
		//상세정보조회 제목
		titleSltd = new JLabel("영양제 상세 정보 조회");
		titleSltd.setBounds(200, 100, 250, 50);
		titleSltd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		//상세정보조회 텍스트 상자
		JTextArea txtInfo = new JTextArea(nm.nList.toString()); //nList 넣기
		txtInfo.setEditable(false); //텍스트상자 읽기 전용(not editable)
		JScrollPane txtScroll = new JScrollPane(txtInfo); //txtInfo에 스크롤 넣기
		txtScroll.setBounds(80, 200, 500, 200);
		txtScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//수정 버튼
		editNutriSltd = new JButton("수정하기");
		editNutriSltd.setBounds(150, 440, 200, 50);
		
		//삭제 버튼
		delNutriSltd = new JButton("삭제하기");
		delNutriSltd.setBounds(350, 440, 200, 50);
		
		//돌아가기 버튼
		exitSltd = new JButton("돌아가기");
		exitSltd.setBounds(200, 500, 200, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panelSelected.add(titleSltd);
		panelSelected.add(txtScroll);
		panelSelected.add(editNutriSltd);
		panelSelected.add(delNutriSltd);
		panelSelected.add(exitSltd);

		
		//------------------------------------------------이벤트 추가
		//마우스 클릭시 row 객체 선택하기
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
			}
		});
		
		//테이블 목록에서 선택하여 더블클릭시 상세 조회로 이동
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
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
				keywordSearch();
				//---------------------------------------검색 필터 오류 해결하기
				
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
			}
		});
		
		//영양제 추가버튼 - 추가 페이지로 이동(AdminNew)
		newNutriMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);
				
				AdminNew2 n = new AdminNew2();
				n.setVisible(true);
				frame.dispose();
			}
		});
		
		//나가기 버튼 - 메인 페이지로 이동(프로그램 실행시 맨 처음 페이지)
		exitMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);
				
				//메인페이지 클래스 화면 전환
				//메인페이지클래스명 flip = new 메인페이지클래스명();
				//flip.setVisible(true);
				//frame.dispose();
			}
		});
		
		//상세페이지 영양제 수정 버튼 - 수정 페이지로 이동(AdminEdit)
		editNutriSltd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);

				AdminEdit2 n = new AdminEdit2();
				n.setVisible(true);
				frame.dispose();
			}
		});
		
		//상세페이지 영양제 삭제 버튼 - 영양제 삭제하기(삭제확인 팝업, 해당 데이터 지우기)
		delNutriSltd.addActionListener(new ActionListener() {
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
		
		//상세페이지 돌아가기 버튼 - AdminMode 메인 패널로 이동
		exitSltd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelSelected.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		
		//프레임에 패널 넣기
		frame.add(panelMain);
		frame.add(panelSelected);
		
		//프레임 기본 설정
		//frame.setBounds(300,300,500,700);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null); //화면 가운데 뜨게
		frame.setResizable(true); //false : 화면크기 조정 안되도록// true : 화면크기 조정되도록
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
