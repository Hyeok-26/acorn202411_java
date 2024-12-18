package test.main;

import test.auto.Car;
import test.auto.Engine;
import test.auto.SportsCar;

public class MainClass06 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 참조값을 car1 이라는 지역 변수에 담아보세여
		Car car1 = new Car(new Engine());
		//car1 에 들어있는 참조값을 이용해서 .drive()메소드를 호출해보세요
		car1.drive();
		SportsCar car2 = new SportsCar(new Engine());
	}
}
