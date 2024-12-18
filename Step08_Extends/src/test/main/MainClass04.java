package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		//HandPhone type 객체를 생성해서 나온 참조값을 Object type 지역변수에 담기
		Object o1 = new HandPhone();
		//casting 연산자를 이용해서 대입 연산자의 우측을 Phone type으로 인식되도록
		Phone p1 = (Phone) o1;
		//casting 연산자를 이용해서 대입 연산자의 우측을  HandPhone type 으로 인식
		HandPhone h1 = (HandPhone) p1; 
	}
}
