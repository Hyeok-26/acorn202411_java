package test.main;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		Car car1 = new Car();
		//객체를 car1에 담아놓고 계속 사용한다
		car1.drive();
		//Car 객체를 생성해서 메소드 호출하고 참조값은 더이상 사용 x
		new Car().drive();
		
		car1.drive();
		car1.drive();
	}
}
