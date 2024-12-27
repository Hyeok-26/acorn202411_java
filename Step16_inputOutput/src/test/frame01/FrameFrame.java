package test.frame01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameFrame extends JFrame {
	
	JTextArea ta;
	
	public FrameFrame(String title) {
		super(title);
		
		
		
		//프레임의 위치와 크기 설정
		setBounds(100, 100, 500, 500);
		
		//TextField 와 Button 을 배치할 Panel 객체
		var toPanel = new JPanel();
		toPanel.setBackground(Color.green);
		
		//TextField 와 Button 을 생성
		var inputMsg = new JTextField(30);
		var saveBtn = new JButton("send");
		toPanel.add(inputMsg);
		toPanel.add(saveBtn);
		
		//프레임에 레이아웃 설정
		setLayout(new BorderLayout());
		//프레임 북쪽에 패널 설치
		add(toPanel, BorderLayout.NORTH);
		
        // 프레임의 가운데에 JScrollPane 추가
		ta=new JTextArea();
		Font font=new Font("Serif", Font.BOLD, 20);
		ta.setFont(font);
		
		var scrollPane = new JScrollPane(ta);
		add(scrollPane, BorderLayout.CENTER);
        
        saveBtn.addActionListener((event)->{
        	//문자열을 누적 시킨 다음 한번에 누적된 문자열을 얻어낼 수 있는 객체 생성
    		var sb = new StringBuilder();
    		
    		File f = new File("C:/Users/acorn/Desktop/playground/myFolder/memo.txt");
    		try {
    			//파일로 부터 문자열을 읽어들일 수 있는 객체 생성
    			var fr = new FileReader(f);
    			//ㅁ누자열을 줄 단위로 읽어들일 수 있는 객체
    			var br = new BufferedReader(fr);
    			//무한 루프 돌리면서
    			while(true) {
    				String line = br.readLine();
    				//만일 더 이상 읽을 게 없다면
    				if(line == null) {
    					break;//반복문 탈출
    				}
    				//반복문 읽어낸 문자열을 StringBuilder 객체에 누적 시키기
    				sb.append(line);
    				sb.append("\r\n");//개행기호
    			}
    			
    		}catch(IOException ie) {
    			ie.printStackTrace();
    		}
    		//객체에 누적된 문자열을 한번에 출력하기
    		String result = sb.toString();
    		ta.append(result);
        });
        
     
	}
	
	public static void main(String[] args) {
		var s = new FrameFrame("My Home...");
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
	}
}
