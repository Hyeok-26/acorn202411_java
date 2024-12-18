package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass03 {
	public static void main(String[] args) {
		//아래의 3줄을 실행하면 참조값이 몇 개가 너올까?(객체가 몇개가 생성될까?)
		HandPhone p1 = new HandPhone();
		
		//부모 타입
		//UP캐스팅
		//HandPhone type 안에 있는 값을 Phone type 변수에 대입 가능!
		Phone p2 = p1; 
		//HandPhone type 안에 있는 값을 Object type 변수에 대입 가능!
		Object p3 = p1;
		
		//casting 후에 담을 수 있다.
		HandPhone p4 =(HandPhone)p3;//다운 캐스팅
		
		p4.mobileCall();
		
		//참조값이 없는 HandPhone type 변수를 실행하면 키가 없어 NullException
		//HandPhone p4 = null;
		//p4.mobileCall();
		
		
	}
}
