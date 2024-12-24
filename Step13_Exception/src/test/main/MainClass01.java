package test.main;

import java.util.Scanner;
//Exception(예외)를 처리하는 방법
public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 입력: ");
		//숫자 형식의 문자열을 입력 받는다 "10", "20", "10.1" 등등
		String inputNum = scan.nextLine();
		//try 블억에서 NumberFormatException type 에러가 뜨면 맨 아래로 이동
		try {
			//입력한 숫자(문자열)를 실제 숫자로 바꾼다
			//숫자가 아닌 글자 입력하면 오류발생하는 곳
			double num = Double.parseDouble(inputNum);
			//입력한 숫자에 100 을 더한다
			double result = num + 100;
			System.out.println("입력한 숫자 + 100 : " +result);
		}catch(NumberFormatException nfe){
			/*
			 *  실행 스택에서 일어난 일을 콘솔탕에 출력하기
			 *  (자세한 예외 정보를 예외객체기 콘솔창에 출력하게 하기)
			 */
			nfe.printStackTrace();
		}
		System.out.println("무언가 중요한 마무리 작업을 하고 main 메소드가 종료 됩니다");
	}
}
