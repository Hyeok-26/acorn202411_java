package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

/*
 *  [ 다형성 ]
 *  -java 에서 객체는 여러개의 type 을 가질 수 잇다
 */
public class MainClass02 {
	public static void main(String[] args) {
		HandPhone p1 = new HandPhone();
		//참치김밥은 김밥이다.핸드폰도 폰일 수 있다
		//HandPhone 객체를 생성해서 나온 참조값을 Phone type 지녁변수 p2에 담기
		Phone p2 = new HandPhone();
		//상속받은 부모 클래스의 타입도 사용할 수 있다,코딩의 유연함,선택의 다양성??
		//자식 클래스의 메소드는 사용 불가
		//안에 들어있는 값에 대한 사용 설명서 Typecasting으로 사용 설명서를 바꿀 수 있음
		//변수에 참조값이 담겨있는 형태
		//HandPhone 객체를 생성해서 나온 참조값을 Object type 지녁변수 p3에 담기
		Object p3 = new HandPhone();
		
		
	}
}
