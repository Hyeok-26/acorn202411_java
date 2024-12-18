package test.main;

import test.mypac.Car;
import test.mypac.Food;

public class MainClass03 {
	public static void main(String[] args) {
	/*
	 *  Car 객체를 3개 만들어서
	 *   임의의 자동차 이름과 가격을 필드에 각각 대입하는 코드를 작성해보세여
	 */
		Car c1 = new Car();
		c1.name = "Tesla";
		c1.price = 10000;
		Car c2 = new Car();
		c2.name = "Martiz";
		c2.price = 1000;
		Car c3 = new Car();
		c3.name = "Duck";
		c3.price = 100;
		
		
	/*
	 * 다 하신 분은 자신만의 class를 test.mypac 패키지에 만들어 놓고 테스트하는 코드를 작성
	 */
		Food f1 = new Food();
		f1.name = "핫크리스피";
		f1.price = 3000;
		Food f2 = new Food();
		f2.name = "콰트로 맥시멈 미트 포커스드 어메이징 얼티밋 그릴드 패티 오브 더 비기스트 포 슈퍼 미트 프릭";
		f2.price = 5000;
		//객체의 동작 실행
		f1.foods();
		f2.foods();
		
		System.out.println(f1.name+" 의 가격이 변동되어: "+f1.price);
		System.out.println(f2.name+" 의 가격이 변동되어: "+f2.price);
		
	}
}
