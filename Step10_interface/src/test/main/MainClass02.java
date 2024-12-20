package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		//객체 생성 불가 
		//Remocon r1 =new Remocon();
		
		//자식 클래스로 대신 객체 생성
		Remocon r1 =new MyRemocon();
		Object r2 = r1;
		
		MyRemocon r3 = new MyRemocon();
		Remocon r4 = new MyRemocon();
		
		useRemocon(r1);
		//Object 부모라 자식이 부모를 참조할 수는 없음,설계도가 안됨
		//casting 해서 전달하면 메소드 호출 가능
		useRemocon((Remocon)r2);
		useRemocon(r3);
	}
	public static void useRemocon(Remocon r) {
		r.down();
		r.up();
	}
}
