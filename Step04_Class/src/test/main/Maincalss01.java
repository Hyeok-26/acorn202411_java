package test.main;
//ctrl + space를 이용해서 원하는 클래스를 자동으로 import 할 수있다
import test.mypac.Car;

public class Maincalss01 {
	//rub 했을 때 실행의 흐름이 시작되는 main()메소드
	public static void main(String[] args) {
		//Car 믈래스로 객체를 생성해보고 그 객체의 참조값을 c1 이라는 지역변수에 담디
		Car c1 = new Car();
		c1.name = "Tesla";
		c1.price = 400;
		//car클래스를 객체로 생성하고 그 객체의 참조값을 c2라는 지역변수에 담기
		Car c2 = new Car();
		
		//car클래스를 객체로 생성하고 그 객체의 참조값을 c2라는 지역변수에 담기
		Car c3 = new Car();
	}
}
