package test.main;

import test.mypac.Remocon;
//   	Remocon 인터페이스도 이미 만들어져 있고 그 type 을
//		사용하는 메소드도 이미 만들어져 있는 상황
//		개발자는 Remocon 인터페이스를 구현한 클래스를 만들고 메소드를 재정의해서
//		우리가 하고 싶은 동작을 메소드 안에서 coding한다
public class MainClass03 {
	public static void main(String[] args) {
		Remocon r1 = new Remocon() {
			//Remocon type 객체는 2개의 동작을 가지고 있고
			@Override
			public void up() {
				System.out.println("채널 올려잇!!!!");
			}
			@Override
			public void down() {
			 System.out.println("채널 내려잇!!!!");
			}
		};
		//2개의 동작을 객체에 담아서 전달하고 포장
		//메소드 호출하면서 지역변수에 담겨져 있는 Remocon type 의 참조값을 전달
		useRemocon(r1);
		
		//메소드 호출하면서 즉석에서 Remocon type 참조값을 얻어내서 전달
		useRemocon(new Remocon() {
			@Override
			public void up() {
				System.out.println("밝기를 올려요");
			}
			@Override
			public void down() {
				System.out.println("밝기를 내려요");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		//메소드 안에서는 해당 동작을 사용
		r.down();
		r.up();
	}
}
