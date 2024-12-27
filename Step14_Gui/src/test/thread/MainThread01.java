package test.thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainThread01 extends JFrame{
	
	JTextArea ta;
	
	public MainThread01(){
		//프레임의 제목 설정
		this.setTitle("나의 타이틀");
		
		//프레임의 위치와 크기 설정   x, y, width, height
		setBounds(100, 100, 500, 500);
		
		//종료 버튼을 눌렀을 때 프로세스 전체가 종료 되도록 한다
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		//에이아웃 매리저 객체 생성
		BorderLayout layout = new BorderLayout();
			
		//프레임의 레이아웃 매니져 설정
		setLayout(layout);
			
		//TextField 와 Button 을 배치할 Panel 객체 ui를 추가할 수 있느 객체
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.YELLOW);
		
		//TextField 와 Button 을 생성해서
		JTextField inputMsg = new JTextField(10);
		JButton sendBtn = new JButton("전송");
		
		//Panel 에 추가
		topPanel.add(inputMsg);
		topPanel.add(sendBtn);
		//프레임의 위쪽에 Panel 추가
		add(topPanel,BorderLayout.NORTH);
		
		ta = new JTextArea();
		//프레임의 가운데에 TextArea 추가
		add(ta, BorderLayout.CENTER);
		// 스크롤을 추가하기 위해 JScrollPane 생성
        JScrollPane scrollPane = new JScrollPane(ta);
        // 프레임의 가운데에 JScrollPane 추가
        add(scrollPane, BorderLayout.CENTER);
        
		Font font = new Font("Serif",Font.BOLD, 20);
		ta.setFont(font);
		
		sendBtn.addActionListener((event)->{
			String msg = inputMsg.getText();
			new Thread(()->request(msg)).start();
		});
		
		//화면상에 보이도록 한다
		setVisible(true);
}	
	
	// 매개 변수에 전달되는 주소로 요청을 하는 메소드
    public void request(String requestUrl) {
        try {
            // 요청 보낼 URL 설정
            URL url = new URL(requestUrl); // 예제 URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // HTTP 요청 메서드 설정
            connection.setRequestMethod("GET");

            // 헤더 설정 (필요에 따라 추가)
            connection.setRequestProperty("Accept", "application/json");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            // 응답한 문자열을 누적시킬 객체
            StringBuilder response = new StringBuilder();
            // 만일 정상적인 응답이라면
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 응답하는 내용을 읽어들일 객체
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                // 반복문 돌면서
                while (true) {
                    // 한줄씩 읽어들이고
                    String line = br.readLine();
                    // 만일 다 읽었다면
                    if (line == null) {
                        break; // 반복문 탈출
                    }
                    // 읽은 문자열 한줄을 누적시킨다.
                    response.append(line).append("\r\n");
                }
            } else {
                ta.setText("Request failed. Response Code: " + responseCode);
            }
            // 누적된 문자열을 TextArea 에 출력하기
            ta.setText(response.toString());

            // 연결 해제
            connection.disconnect();

        } catch (Exception e) {
            // 에러 메시지 출력
            e.printStackTrace();
            ta.setText("에러 발생: " + e.getMessage());
        }
    }

	public static void main(String[] args) {
		new MainThread01();
	}
}
