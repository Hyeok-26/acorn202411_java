package test.main;

import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 *  System 클래스의 in 이라는 필드에는 콘솔창으로부터 입력 받을 수 잇는
		 *  객체의 참조값이 들어있다
		 *  in 의 type 은  InputStream이다.
		 *  이 type 객체의 참조값을 Scanner 클래스의 생성자에 전달해서 객체 생성
		 * 	Scanner 믈래스의 생성자는 아래와 같은 모영의 생성자가 있다
		 * Scanner (InputStream is)
		 * 따라서 아래의 코드는 콘솔창으로부터 입력 받을 수 있는 Scanner 객체가 생성된 것이다
		 *  */
		System.out.println("문자열 입력: ");
		Scanner scan = new Scanner(System.in);
		/*	생성자의 모양
		 * public class Scanner {
		 * 		public Scanner(InputStream is){
		 * 		
		 * 		}
		 * }
		 * */
		//입력한 문자열을 읽어오는 객체
		String line = scan.nextLine();
		
		System.out.println("입력한 문자열: "+line);
		
	}
}
