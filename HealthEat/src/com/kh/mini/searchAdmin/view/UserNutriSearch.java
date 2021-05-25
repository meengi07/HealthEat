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
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.sy.mvc.controller.NutriManager2;
import com.sy.mvc.model.vo.Nutri;

public class UserNutriSearch extends JFrame {

	//사용자 영양제 조회 및 검색 페이지
	String[] headings = new String[] {"주영양소", "제조사", "용량", "가격", "기타영양소", "효능효과", "인기도"};
	DefaultTableModel model = new DefaultTableModel(headings, 0) {
		public boolean isCellEditable(int headings, int data) {
			//테이블 내용 수정 방지
			return false;
		}
	};
	
	JTextField text;
	JTable table;
	JTextArea txtInfo;
	
	int row = 0;

	
	public UserNutriSearch() {
		//------------------------------------------Main panel
		//---------------------------------------영양제 검색 첫 화면
		//창 이름
		JFrame frame = new JFrame("영양제 검색");
		
		//메인 패널
		JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 0, 840, 840/12*9);
		panelMain.setLayout(null);
		panelMain.setBackground(new Color(232, 217, 255)); //연보라색 배경

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
		
		table = new JTable(model);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 400)); //뷰포트 기본 크기
		//table.setFillsViewportHeight(true); //테이블이 뷰포트(정보창)를 둘러싸는 높이를 채울지
		table.setRowHeight(25); //행 높이 25로 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(100); //0번째 열너비 100으로 조정
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(80, 200, 500, 200);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum()); //테이블 최하단 자동스크롤
		showAllList(); //nutriList 정보 출력 메소드
		
		//영양제 추천 버튼
		JButton recommMain = new JButton("영양제 추천받기");
		recommMain.setBounds(200, 440, 200, 50);
		
		//돌아가기 버튼
		JButton exitMain = new JButton("돌아가기");
		exitMain.setBounds(200, 500, 200, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panelMain.add(search);
		panelMain.add(text);
		panelMain.add(btn);
		panelMain.add(reload);
		panelMain.add(scroll);
		panelMain.add(recommMain);
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
		txtInfo = new JTextArea(); //nutriList 넣기
		txtInfo.setEditable(false); //텍스트상자 읽기 전용(not editable)
		JScrollPane txtScroll = new JScrollPane(txtInfo); //txtInfo에 스크롤 넣기
		txtScroll.setBounds(80, 200, 500, 200);
		txtScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//txtInfo.setText(printDetail());
		
		//영양제 추천 버튼
		JButton recommSltd = new JButton("영양제 추천받기");
		recommSltd.setBounds(200, 440, 200, 50);
		
		//돌아가기 버튼
		JButton exitSltd = new JButton("돌아가기");
		exitSltd.setBounds(200, 500, 200, 50);
		
		//패널에 레이블, 버튼 등 붙이기
		panelSelected.add(txtScroll);
		panelSelected.add(titleSltd);
		panelSelected.add(recommSltd);
		panelSelected.add(exitSltd);
		
		//기본 패널뷰 조정
		panelMain.setVisible(true);
		panelSelected.setVisible(false);
		
		//-------------------------------------------------이벤트 추가
		//테이블 목록에서 선택하여 더블클릭시 상세 조회로 이동
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					showDetail();
				
				/*	
					//---------------------------------조회수 증가 구현하기
					//조회수 1씩 증가시키기
					BufferedWriter bw = null;
					BufferedWriter bw2 = null;
					BufferedWriter bw3 = null;
					
					try {
						//선택 행 이전 데이터 입력
						bw = new BufferedWriter(new FileWriter("nutriList.txt"));
						
						for (int i = 0; i < table.getSelectedRow(); i++) {
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
					
					
					//선택 행 데이터 텍스트필드값 입력받아 수정
					try {
						bw2 = new BufferedWriter(new FileWriter("nutriList.txt", true));
						
						TableModel m = table.getModel(); //테이블의 모델 객체 얻어오기
						int rowSltd = table.getSelectedRow(); //선택한 셀의 행번호
						
						String basicNutri = (String)m.getValueAt(rowSltd, 0);
						String manufac = (String)m.getValueAt(rowSltd, 1);
						String quantity = (String)m.getValueAt(rowSltd, 2);
						String price = (String)m.getValueAt(rowSltd, 3);
						String otherNutri = (String)m.getValueAt(rowSltd, 4);
						String effect = (String)m.getValueAt(rowSltd, 5);
						String count = (String)m.getValueAt(rowSltd, 6);
						
						//조회수 형변환 후 1씩 증가
						int countInt = Integer.parseInt(count);
						countInt++;
						String countStr = String.valueOf(countInt);
						
						bw2.write(basicNutri + "/");
						bw2.write(manufac + "/");
						bw2.write(quantity + "/");
						bw2.write(price + "/");
						bw2.write(otherNutri + "/");
						bw2.write(effect + "/");
						bw2.write(countStr + "/\n"); //인기도(조회수)
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							bw2.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
					//선택 행 이후 데이터 입력
					try {
						bw3 = new BufferedWriter(new FileWriter("nutriList.txt", true));
						for (int i = table.getSelectedRow() + 1; i < table.getRowCount(); i++) {
							for (int j = 0; j < table.getColumnCount(); j++) {
								bw3.write(table.getValueAt(i, j).toString() + "/");
							}
							bw3.newLine();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							bw3.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				*/	
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
				
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
			}
		});
		
		//전체목록조회 버튼 - 키워드 검색 후 다시 전체목록 조회하고 싶을 때 사용
		reload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reloadTable();
				
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
			}
		});
		
		//메인 패널 돌아가기 버튼 - 로그인 후 메인페이지로 이동
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
		
		//메인 패널 영양제 추천 받기 버튼 - 추천 패널로 이동
		recommMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				panelSelected.setVisible(false);
				//영양제 추천 클래스 화면 전환
				//영양제추천클래스명 flip = new 영양제추천클래스명();
				//flip.setVisible(true);
				//frame.dispose();
			}
		});
		
		//상세정보 패널 돌아가기 버튼 - 메인 패널로 이동
		exitSltd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelSelected.setVisible(false);
			}
		});
		
		//상세정보 패널 영양제 추천 받기 버튼 - 추천 패널로 이동
		recommSltd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelSelected.setVisible(false);
				panelMain.setVisible(false);
				//영양제 추천 클래스 화면 전환
				//영양제추천클래스명 flip = new 영양제추천클래스명();
				//flip.setVisible(true);
				//frame.dispose();
			}
		});
		
		
		//프레임에 패널 넣기
		frame.add(panelMain);
		frame.add(panelSelected);
		
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
	
	
	//상세정보조회 텍스트 상자에 데이터 넣어 출력하기
	public void showDetail() {
		
		int rowSltd = table.getSelectedRow(); //선택한 셀의 행번호
		TableModel m = table.getModel(); //테이블의 모델 객체 얻어오기
		
		String basicNutri = (String)m.getValueAt(rowSltd, 0);
		String manufac = (String)m.getValueAt(rowSltd, 1);
		String quantity = (String)m.getValueAt(rowSltd, 2);
		String price = (String)m.getValueAt(rowSltd, 3);
		String otherNutri = (String)m.getValueAt(rowSltd, 4);
		String effect = (String)m.getValueAt(rowSltd, 5);
		String viewCount = (String)m.getValueAt(rowSltd, 6);
		//viewCount++;
	
		txtInfo.setText("");
		txtInfo.append("주영양소 : ");
		txtInfo.append(basicNutri + "\n");
		txtInfo.append("제조사 : ");
		txtInfo.append(manufac + "\n");
		txtInfo.append("용량 : ");
		txtInfo.append(quantity + "\n");
		txtInfo.append("가격 : ");
		txtInfo.append(price + "원\n");
		txtInfo.append("부가영양소 : ");
		txtInfo.append(otherNutri + "\n");
		txtInfo.append("효능효과 : ");
		txtInfo.append(effect + "\n");
		txtInfo.append("인기도(조회수) : ");
		txtInfo.append(viewCount + "\n");

	}
	
}
