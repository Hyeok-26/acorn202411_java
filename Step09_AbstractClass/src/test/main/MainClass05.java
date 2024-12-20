package test.main;

import test.mypac.MyArrow;
import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		//익명의 innerClass를 이용해서 Weapon type 의 참조값을 얻어내서 변수에 담은 다음
		Weapon w1 = new Weapon() {//class ? extends Weapon{   }
			//이름이 없는 Weapon class 를 상속받은 local inner 클래스를 만들어 
			//추상 클래스 타입(new Weapon())의 참조값을 가져온다
			@Override
			public void attack() {
				System.out.println("정수리 10연타");
			}
		};
		//메소드 호출하면서 전달하기
		useWeapon(w1);
		
		//메소드 호출하면서 즉석에서 Weapon type 의 참조값을 얻어내서 전달하기
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("김구라를 공격하라!");
			}
		});
		System.out.println("");
		Weapon w9 = new MyArrow();
		useWeapon(w9);
		
	}	
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
