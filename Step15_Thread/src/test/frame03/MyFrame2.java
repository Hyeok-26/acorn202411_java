package test.frame03;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {
	//생성자
	public MyFrame2(String title){
		super(title);
		
		//부모의 메소드를 this. 으로 사용
		//this.setBounds(100, 100, 300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		/*
		 *  type 추론이 가능하다면 지역변수의 type 선언 대신에 !!var!! 로 선언 할 수 있다
		 *	- java 10  에서 추가된 문법,  아직도 실무에서는 1.8 버전을 쓰는 곳이 많기 때문에 주의!
		 *  - 지역변수에만 사용가능, 필드는 안됨
		 *  - 인터페이스 type 추론 불가 
		 *  - null 로 초기화 불가
		 */
		var num = 10;
		var name = "kim";
		var isRun = true;
		
		var startBtn = new JButton("작업 시작");
		add(startBtn);
		
		var startBtn2 = new JButton("작업 시작2");
		add(startBtn2);
		
		startBtn.addActionListener((e)->{
			System.out.println("10 초 걸리는 작업을 시작합니다");
			try {
				Thread.sleep(1000*10);
			}catch(InterruptedException e1){
				e1.printStackTrace();
			}
			System.out.println("작업이 종료 되었습니다");
		});
		//3.Thread 객체 생성해서 객체 안에 있는 implements 익명 생성자를 활용해
		//작업을 분리 시킬 수 있다
		
		//지역변수 선언을 안하고 객체를 불러와 추상메소드를 이용한 함수 형태로 만들 수 잇따
		//Runnable interface type
		startBtn2.addActionListener((e)->{
			new Thread(()->{
				//새로운 스레드에서 해야할 작업을 run() 메소드 안에서 한다
				System.out.println("10 초 걸리는 작업을 시작합니다.");
				try {
					Thread.sleep(1000*10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("작업이 종료 되었습니다.");
			}).start();
		});
		
	}
	//run 했을 때 실행의 흐름이 시작되는 메인 메소드
	public static void main(String[] args) {
		var frame = new MyFrame2("나의 프레임");
		//참조값에 . 찍어서 메소드 호출
		//MyFrame 객체 안에서 this. 으로 호출했던 메소드를
		//객체 외부에서는 참조값에 . 찍어서 호출할 수있다.
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}