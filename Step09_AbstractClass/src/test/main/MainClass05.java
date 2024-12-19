package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		//
		Weapon w1 = new Weapon() {//class ? extends Weapon{   }
			//이름이 없는 Weapon class 를 상속받은 local inner 클래스를 만들어 
			//추상 클래스 타입(new Weapon())의 참조값을 가져온다
			@Override
			public void attack() {
				System.out.println("정수리 10연타");
			}
		};
		useWeapon(w1);
		useWeapon(new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("김구라를 공격하라!");
			}
		});
	}	
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
