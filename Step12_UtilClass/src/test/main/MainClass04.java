package test.main;

import java.util.ArrayList;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1.Car type 을 저장할 수 있는 ArrayList 객체를 생성해서
		//참조값을 List 인터페이스 type 지역변수 cars 에 담아보에쇼
		ArrayList<Car> cars = new ArrayList<>(); 
		//2.Car 객체3개를 생성해서 ArrayList 객체에 저장해보세요
		Car car1 = new Car("Tesla");
		Car car2 = new Car("Martiz");
		//Car car3 = new Car("Borbo");
		cars.add(car1);
		cars.add(car2);
		cars.add( new Car("Borbo"));
		
		//3.일반 for 문을 이용해서 ArrayList 객체에 저장된 모든 Car 객체의 drive()메소드를
		//순서대로 호출핫요
		for(int i=0; i<cars.size(); i++) {
			Car cnt = cars.get(i);
			cnt.drive();
		}
		System.out.println("---------");
		//4.확장 for문을 사용해서 ArrayList  객체에 ㅈㅓ장된 모든 Car 객체의 drive()메소드를 호출
		for(Car cnt:cars) {
			cnt.drive();
		}
		System.out.println("---------");
		//ArrayList 객체의 forEach() 메소드를 이용해서 ArrayList 객체에 저장된 모든 CAr 객체의 drive()
		//메소드를 순서대로 호출해보세요
		cars.forEach((cnt)->{
			cnt.drive();
		});
	}
}
