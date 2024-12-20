package test.main;

import test.mypac.Apple;
import test.mypac.FruitBox;
import test.mypac.Melon;
import test.mypac.Orange;

public class MainClass01 {
	public static void main(String[] args) {
		//클래스 정의 시 고정하지 않고 이것저것 포괄
		//포괄 클래스(Generic 클래스)
		FruitBox<Apple> box1 = new FruitBox<Apple>();
		box1.pack(new Apple());
		FruitBox<Orange> box2 = new FruitBox<Orange>();
		Orange o1 = box2.unpack();
		
		//Generic 클래스를 Melon 으로 지정해서 객체 사용
		//객체 생성 시에 Generic 은 생략 가능
		FruitBox<Melon> box3 = new FruitBox<>();
		box3.pack(new Melon());
		Melon m1 = box3.unpack();
		
	}
}	
