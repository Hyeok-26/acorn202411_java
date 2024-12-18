package main;
/*
 * eclipse에서 진한 빨간색으로 표시되는 단어는 예약어이다
 *예약어는 아주 특별히 해석되기로 약속된 단어이기 때문에 식별자(클래스명, 메소드명, 변수명 등등)으로 사용 x
 */
public class MainClass {
	public static void main(String[] args) {
		System.out.println("Hello, world!");
		System.out.println("노혁천, 세상!!");
		
		int num = 10;
		String name = "김구라";
		boolean isMan = true;
		
		for(int i=0; i<10; i++) {
			System.out.println(i+1);
		}
		
	}
}