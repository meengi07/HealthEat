package com.kh.mini.searchAdmin.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

import com.kh.mini.MemberLogin.view.front.Login;

public class AdminMode extends JFrame {
	
	//관리자 모드 - 영양제 등록, 수정, 삭제 메뉴
	String[] headings = new String[] {"주영양소", "제조사", "용량", "가격", "기타영양소", "효능효과", "인기도"};
	DefaultTableModel model = new DefaultTableModel(headings, 0) {
		public boolean isCellEditable(int headings, int data) {
			//테이블 내용 수정 방지
			return false;
		}
	};
	int row = 0;
	
	JTextField text;
	JTable table;
	JTextArea txtInfo;
	JScrollPane scroll;
 
	
	public AdminMode() {
		//창 이름
		JFrame frame = new JFrame("관리자 모드");

		//----------------------------------------------Main panel
		//메인 패널
		JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 0, 840, 840/12*9);
		panelMain.setLayout(null);
		panelMain.setBackground(Color.LIGHT_GRAY);
				
		//검색어 설명
		JLabel search = new JLabel("검색할 키워드 : ");
		search.setLocation(100, 100);
		search.setSize(100, 50);
		
		//검색어 입력창
		text = new JTextField();
		text.setLocation(200, 100);
		text.setSize(200, 50);
		
		//검색 버튼
		JButton btn = new JButton("검  색");
		btn.setLocation(400, 100);
		btn.setSize(100, 50);
		
		//전체목록조회 버튼
		JButton reload = new JButton("전체조회");
		reload.setLocation(500, 100);
		reload.setSize(100, 50);	
		
		//영양제 목록 출력
		table = new JTable(model);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 400)); //뷰포트 기본 크기
		//table.setFillsViewportHeight(true); //테이블이 뷰포트(정보창)를 둘러싸는 높이를 채울지
		table.setRowHeight(25); //행 높이 25로 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(100); //0번째 열너비 100으로 조정
		table.setModel(model);
		
		scroll = new JScrollPane(table);
		scroll.setBounds(80, 200, 500, 200);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		showAllList(); //nutriList 정보 출력 메소드
		//scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum()); //테이블 최하단 자동스크롤
		
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
		panelMain.add(reload);
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
		txtInfo = new JTextArea(); 
		txtInfo.setEditable(false); //텍스트상자 읽기 전용(not editable)
		JScrollPane txtScroll = new JScrollPane(txtInfo); //txtInfo에 스크롤 넣기
		txtScroll.setBounds(80, 200, 500, 200);
		txtScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		

		//수정 버튼
		JButton editNutriSltd = new JButton("수정하기");
		editNutriSltd.setBounds(150, 440, 200, 50);
		
		//삭제 버튼
		JButton delNutriSltd = new JButton("삭제하기");
		delNutriSltd.setBounds(350, 440, 200, 50);
		
		//돌아가기 버튼
		JButton exitSltd = new JButton("돌아가기");
		exitSltd.setBounds(200, 500, 200, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panelSelected.add(titleSltd);
		panelSelected.add(txtScroll);
		panelSelected.add(editNutriSltd);
		panelSelected.add(delNutriSltd);
		panelSelected.add(exitSltd);

		
		//---------------------------------------------Edit panel
		//-------------------------------------------영양제 수정 화면
		//패널
		JPanel panelEdit = new JPanel();
		panelEdit.setBounds(0, 0, 840, 840 / 12 * 9);
		panelEdit.setLayout(null);
		panelEdit.setBackground(Color.LIGHT_GRAY);

		// 정보 입력창
		JLabel title = new JLabel("영양제 수정");
		title.setBounds(200, 30, 200, 50);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JLabel lab1 = new JLabel("주영양소 : ");
		lab1.setLocation(40, 100);
		lab1.setSize(200, 30);

		JTextField text1 = new JTextField();
		text1.setLocation(150, 100);
		text1.setSize(300, 30);

		JLabel lab2 = new JLabel("제조사 : ");
		lab2.setLocation(40, 150);
		lab2.setSize(200, 30);

		JTextField text2 = new JTextField();
		text2.setLocation(150, 150);
		text2.setSize(300, 30);

		JLabel lab3 = new JLabel("용량 : ");
		lab3.setLocation(40, 200);
		lab3.setSize(200, 30);

		JTextField text3 = new JTextField();
		text3.setLocation(150, 200);
		text3.setSize(300, 30);

		JLabel lab4 = new JLabel("가격 : ");
		lab4.setLocation(40, 250);
		lab4.setSize(200, 30);

		JTextField text4 = new JTextField();
		text4.setLocation(150, 250);
		text4.setSize(300, 30);

		JLabel lab5 = new JLabel("부가영양소 : ");
		lab5.setLocation(40, 300);
		lab5.setSize(200, 30);

		JTextField text5 = new JTextField();
		text5.setLocation(150, 300);
		text5.setSize(300, 30);

		JLabel lab6 = new JLabel("효능효과 : ");
		lab6.setLocation(40, 350);
		lab6.setSize(200, 30);

		JTextField text6 = new JTextField();
		text6.setLocation(150, 350);
		text6.setSize(300, 30);

		// 버튼
		JButton btnEdit = new JButton("수  정");
		btnEdit.setBounds(200, 440, 200, 50);

		JButton exitEdit = new JButton("돌아가기");
		exitEdit.setBounds(200, 500, 200, 50);

		// 패널에 레이블, 버튼 등 붙이기
		panelEdit.add(title);
		panelEdit.add(lab1);
		panelEdit.add(lab2);
		panelEdit.add(lab3);
		panelEdit.add(lab4);
		panelEdit.add(lab5);
		panelEdit.add(lab6);
		panelEdit.add(text1);
		panelEdit.add(text2);
		panelEdit.add(text3);
		panelEdit.add(text4);
		panelEdit.add(text5);
		panelEdit.add(text6);
		panelEdit.add(btnEdit);
		panelEdit.add(exitEdit);
		
		//기본 패널뷰 조정
		panelMain.setVisible(true);
		panelSelected.setVisible(false);
		panelEdit.setVisible(false);
		
		
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
					showDetail();
					
					panelMain.setVisible(false);
					panelSelected.setVisible(true);
					panelEdit.setVisible(false);
					
				}
			}
		});
		
		//검색 버튼 - 키워드 검색 결과 출력
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				keywordSearch();
				
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
				panelEdit.setVisible(false);
			}
		});
		
		//전체목록조회 버튼 - 키워드 검색 후 다시 전체목록 조회하고 싶을 때 사용
		reload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reloadTable();
				
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
				panelEdit.setVisible(false);
			}
		});
		
		//영양제 추가버튼 - 추가 페이지로 이동(AdminNew)
		newNutriMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);
				panelEdit.setVisible(false);
				
				AdminNew flip = new AdminNew();
				flip.setVisible(true);
				frame.dispose();
			}
		});
		
		//나가기 버튼 - 메인 페이지로 이동(프로그램 실행시 맨 처음 페이지)
		exitMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);
				panelEdit.setVisible(false);
				
				//------------------------------------------------------------------메인페이지 클래스 화면 전환
				Login flip = new Login();
				flip.setVisible(true);
				frame.dispose();
			}
		});
		
		//상세페이지 영양제 수정 버튼 - 수정 페이지로 이동(AdminEdit)
		editNutriSltd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);
				panelEdit.setVisible(true);
				
				//텍스트필드에 기존 값 출력해서 보여주기
				int rowSltd = table.getSelectedRow(); //선택한 셀의 행번호

				text1.setText((String) table.getValueAt(rowSltd, 0));
				text2.setText((String) table.getValueAt(rowSltd, 1));
				text3.setText((String) table.getValueAt(rowSltd, 2));
				text4.setText((String) table.getValueAt(rowSltd, 3));
				text5.setText((String) table.getValueAt(rowSltd, 4));
				text6.setText((String) table.getValueAt(rowSltd, 5));
			}
		});
		
		//상세페이지 영양제 삭제 버튼 - 영양제 삭제하기(삭제확인 팝업, 해당 데이터 지우기)
		delNutriSltd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//팝업창
				int answer = JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					fileDelete();
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					
				}
			}
		});
		
		//상세페이지 돌아가기 버튼 - AdminMode 메인 패널로 이동
		exitSltd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
				panelEdit.setVisible(false);
			}
		});
		
		//수정 버튼 - nutriList 수정
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//팝업창 확인 후 수정
				int answer = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION) {
					BufferedWriter bw = null;
					try {
						bw = new BufferedWriter(new FileWriter("nutriList.txt"));

						//선택 행 이전 데이터 입력
						for (int i = 0; i < table.getSelectedRow(); i++) {
							for (int j = 0; j < table.getColumnCount(); j++) {
								bw.write(table.getValueAt(i, j).toString() + "/");
							}
							bw.newLine();
						}
						
						//txt파일의 조회수 데이터 가져오기
						TableModel m = table.getModel(); //테이블의 모델 객체 얻어오기
						int rowSltd = table.getSelectedRow(); //선택한 셀의 행번호
						String count = (String)m.getValueAt(rowSltd, 6);
						
						//선택 행 데이터 텍스트필드값 입력받아 수정
						bw.write(text1.getText() + "/");
						bw.write(text2.getText() + "/");
						bw.write(text3.getText() + "/");
						bw.write(text4.getText() + "/");
						bw.write(text5.getText() + "/");
						bw.write(text6.getText() + "/");
						bw.write(count + "\n"); // 인기도(조회수) - 기본 0으로 셋팅

						//선택 행 이후 데이터 입력
						for (int i = table.getSelectedRow() + 1; i < table.getRowCount(); i++) {
							for (int j = 0; j < table.getColumnCount(); j++) {
								bw.write(table.getValueAt(i, j).toString() + "/");
							}
							bw.newLine();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							bw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
					JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
					
					//수정 후 목록 재출력
					showAllList();
					
					//table.revalidate();
					//table.repaint();
					//panelMain.revalidate();
					//panelMain.repaint();
					panelMain.setVisible(true);
					panelSelected.setVisible(false);
					panelEdit.setVisible(false);
				} else if (answer == JOptionPane.CANCEL_OPTION) {

				}
			}
		});
		
		//돌아가기 버튼 - AdminMode 클래스 메인으로 돌아가기
		exitEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
				panelEdit.setVisible(false);
			}
		});
		
		//프레임에 패널 넣기
		frame.add(panelMain);
		frame.add(panelSelected);
		frame.add(panelEdit);
		
		//프레임 기본 설정
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null); //화면 가운데 뜨게
		frame.setResizable(false); //false : 화면크기 조정 안되도록// true : 화면크기 조정되도록
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	
	
	
	//테이블에 전체 nutriList 출력 메소드
	public void showAllList() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("nutriList.txt")); //txt 데이터 읽어오기
			String str = null;
			while ((str = br.readLine()) != null) { //한 줄씩 읽어오기
				String[] arr = str.split("/"); //,를 기준으로 str나눠서 arr만들기.
				model.addRow(arr); //model에 arr추가.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//키워드 검색 메소드
	public void keywordSearch() {
		model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(text.getText().trim()));
	}
	
	//키워드 검색 후 전체목록 재조회 메소드
	public void reloadTable() {
		model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
	}
	
	//파일 데이터 삭제 메소드
	public void fileDelete() {
		//테이블에서 행 지우기
		if (table.getSelectedRow() == -1) {
			return;
		} else {  //테이블에서 행이 선택되면,
			model.removeRow(table.getSelectedRow()); //model에서 선택된 테이블 행 지우기
		}
		
		//txt파일에서 데이터 지우기
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("nutriList.txt")); //default가 false이므로 새로 데이터 파일 생성
			for (int i = 0; i < table.getRowCount(); i++) {
				for (int j = 0; j < table.getColumnCount(); j++) {
					bw.write(table.getValueAt(i, j).toString() + "/"); //table의 행열 기준 각각 값 얻어와서 /로 구분하며 파일에 데이터 입력
				}
				bw.newLine(); //행 바뀔 때 라인 바꿔주기
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//영양제 정보 상세조회 메소드
	public void showDetail() {
		
		int rowSltd = table.getSelectedRow(); //선택한 셀의 행번호
		
		//선택한 행의 데이터 가져오기
		String basicNutri = (String)table.getValueAt(rowSltd, 0);
		String manufac = (String)table.getValueAt(rowSltd, 1);
		String quantity = (String)table.getValueAt(rowSltd, 2);
		String price = (String)table.getValueAt(rowSltd, 3);
		String otherNutri = (String)table.getValueAt(rowSltd, 4);
		String effect = (String)table.getValueAt(rowSltd, 5);
		String viewCount = (String)table.getValueAt(rowSltd, 6);
		
		//textArea에 데이터 작성
		txtInfo.setText("\n");
		txtInfo.append(" ▶ 주영양소 : ");
		txtInfo.append(basicNutri + "\n");
		txtInfo.append(" ▶ 제조사 : ");
		txtInfo.append(manufac + "\n");
		txtInfo.append(" ▶ 용량 : ");
		txtInfo.append(quantity + "\n");
		txtInfo.append(" ▶ 가격 : ");
		txtInfo.append(price + "원\n");
		txtInfo.append(" ▶ 부가영양소 : ");
		txtInfo.append(otherNutri + "\n");
		txtInfo.append(" ▶ 효능효과 : ");
		txtInfo.append(effect + "\n");
		txtInfo.append(" ▶ 인기도(조회수) : ");
		txtInfo.append(viewCount + "\n");
	}
	

}
