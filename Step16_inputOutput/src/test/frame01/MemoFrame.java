package test.frame01;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemoFrame extends JFrame {
	
	
	public MemoFrame(String title) {
		super(title);
		
		var toPanel = new JPanel();
		var inputMsg = new JTextField(30);
		var saveBtn = new JButton("메모 입력");
		
		//패널에 ui2 개 추가
		toPanel.add(inputMsg);
		toPanel.add(saveBtn);
		//프레임에 레이아웃 설정
		setLayout(new BorderLayout());
		//프레임 북쪽에 패널 설치
		add(toPanel, BorderLayout.NORTH);
		//저장 버튼에 리스너 함수 추가
		saveBtn.addActionListener((event)->{
			//입력한 문자열 읽어오기
			String msg = inputMsg.getText();
			File f = new File("C:/Users/acorn/Desktop/playground/myFolder/memo.txt");
			try {
				if(!f.exists()) {
					//새로 만들어라
					f.createNewFile();
					System.out.println("memo.txt 파일을 만들었습니다");
				}
				//new FileWriter 객체, append mode 여부(디폴트값 false) 
				var fw = new FileWriter(f, true);
				fw.append(msg);
				fw.append("\r\n");
				fw.flush();
				fw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			  }
		});
		
	}
	
	public static void main(String[] args) {
		var f = new MemoFrame("메모 프레임");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
