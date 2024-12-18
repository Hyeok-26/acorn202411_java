package test.main;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 참조값을 얻어낸 다음
		Car car1 = new Car();
		car1.name = "소나타";
		Car car2 = new Car();
		car2.name = "그랜저";
		
		//참조값에 . 찍어서 메소드를 호출할 수있다
		
		car1.drive();
		car2.drive();
		//기본 참조 데이터 타입
		String name = "kim";
		String name2 = new String("park");
		
	}
}
