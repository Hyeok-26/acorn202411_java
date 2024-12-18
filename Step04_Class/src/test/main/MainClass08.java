package test.main;

import java.io.PrintStream;

import test.mypac.MyJava;

public class MainClass08 {
	
	public static String myName = "김구라";
	
	public String yourName = "에이콘";
	
	public static void main(String[] args) {
		//System 클래스의 out 이라는 필드에는 콘솔창에 출력하는 기능을 가지고 있는
		// PrintStream type 의 참조값이 들어있다
		
	
		PrintStream a = System.out;
		a.println("오잉?");
		//yourName은 static필드가 아니라 참조가 안된다
		System.out.println(MainClass08.myName);
		System.out.println(myName);
		//녀기는 static 메소드 안족이기 때문에 this. 을 사용할 수 없다
		MainClass08 obj = new MainClass08();
		System.out.println(obj.yourName);
		
		long time = System.currentTimeMillis();
		/*long type 을 리턴해주는 static 메소드
		 *  1970년 1월 1일 0시 기준 현재까지 경과한 시간 1/1000초 단위 계산해서 리턴해주는 메소드*/
		System.out.println("경과시간: "+time);
		
		
	}
}