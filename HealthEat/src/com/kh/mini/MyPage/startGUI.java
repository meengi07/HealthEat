package src.com.kh.mini.MyPage;

import javax.swing.JFrame;

import Project.vo.Panel;
import Project.vo.Panel2;

public class startGUI extends JFrame {
	//
	private Panel p = new Panel();
	private Panel2 p2 = new Panel2();
	



	public startGUI() {
		this.setLayout(null); // ���̾ƿ� �̼���
		this.setTitle("����������"); // Ÿ��Ʋ ����
		this.setBounds(0, 0, 500, 700); // ������ ��ġ ����
		this.setResizable(false); // ������ ���� �Ұ�

		this.add(p.mainpanelM());
		this.add(p.heatlhmainM());
		this.add(p.heatlhcheck1M());
		this.add(p.heatlhcheck2M());
		this.add(p.heatlhendM());
		this.add(p.reviewAddPenalM());
		this.add(p.reviewplusPenalM());
		this.add(p.reviewMainPenalM());
		this.add(p.reviewcheckPenalM());

		this.setVisible(true); // â ���̰� ǥ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���α׷� ����

	}

	public static void main(String[] args) {
		new startGUI();
	}

}