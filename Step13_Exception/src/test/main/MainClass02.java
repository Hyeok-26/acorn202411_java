package test.main;

import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("나눌 수 입력: ");
		String inputNum1 = scan.nextLine();
		
		System.out.println("나누어지는 수 입력: ");
		String inputNum2 = scan.nextLine();
		try {
		//문자열 형태의 숫자를 실제 정수로 변경하기
		int num1 = Integer.parseInt(inputNum1);
		int num2 = Integer.parseInt(inputNum2);
		//계산하기
		int result1 = num2/num1;
		int result2 = num2%num1;
		
		System.out.println(num2+" 를 "+num1+" 으로 나눈 몫: "+result1);
		System.out.println(num2+" 를 "+num1+" 으로 나눈 나머지: "+result2);
		}catch(NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
			System.out.println("말좀 들어라!");
		}catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
			System.out.println("0으로 어떻게 나누냐~~~~~~~!");
		}
		System.out.println("main 메소드가 정상 종료 됩니다.");
	}
}
