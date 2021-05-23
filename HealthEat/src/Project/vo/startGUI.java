package Project.vo;

import javax.swing.JFrame;

public class startGUI extends JFrame {

	Panel p = new Panel();
	Panel2 p2 = new Panel2();
	public startGUI() {
		this.setLayout(null); // 레이아웃 미설정
		this.setTitle("마이페이지"); // 타이틀 설정
		this.setBounds(0, 0, 500, 700); // 사이즈 위치 설정
		this.setResizable(false); // 사이즈 수정 불가

		this.add(p.mainpanelM());
		this.add(p.heatlhmainM());
		this.add(p.heatlhcheck1M());
		this.add(p.heatlhcheck2M());
		this.add(p.heatlhendM());
		this.add(p2.reviewAddPenalM());
		this.add(p2.reviewplusPenalM());
		this.add(p2.reviewMainPenalM());
		this.add(p2.reviewcheckPenalM());
		
		this.setVisible(true); // 창 보이게 표시
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료

	}
	
	
	

	public static void main(String[] args) {
		new startGUI();
	}

}
