package test.main;

import javax.swing.JFrame;

//gui 을 만드는데 필요한 
public class MainClass06 {
	public static void main(String[] args) {
		JFrame f = new JFrame("나의 프레임");
		// .setBounds(x, y, width, height)
		f.setBounds(100, 100, 500, 500);
		// 창의 닫기 버튼을 눌렀을 때 프로세슷가 종료되도록(app이 종료되도록)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * 	public class JFrame{
		 * 		public static final int EXIT_ON_CLOSE = 3;
		 *  }
		 *  static final 상수(read only)는 대문자
		  */
		//화면에 보이도록 한다
		f.setVisible(true);
		
	}
}
