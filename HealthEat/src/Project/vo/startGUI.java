package Project.vo;

import javax.swing.JFrame;

public class startGUI extends JFrame {

	Panel p = new Panel();
	Panel2 p2 = new Panel2();
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
		this.add(p2.reviewAddPenalM());
		this.add(p2.reviewplusPenalM());
		this.add(p2.reviewMainPenalM());
		this.add(p2.reviewcheckPenalM());
		
		this.setVisible(true); // â ���̰� ǥ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���α׷� ����

	}
	
	
	

	public static void main(String[] args) {
		new startGUI();
	}

}
