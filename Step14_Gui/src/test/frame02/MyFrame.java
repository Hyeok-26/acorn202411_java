package test.frame02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	//생성자
	public MyFrame() {
		//프레임의 제목 설정
		this.setTitle("나의 타이틀");
		//프레임의 위치와 크기 설정   x, y, width, height
		setBounds(100, 100, 500, 500);
		//종료 버튼을 눌렀을 때 프로세스 전체가 종료 되도록 한다
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}