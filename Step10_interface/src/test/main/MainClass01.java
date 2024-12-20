package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 *  Remocon 인터페이스는 data type  의 역할을 할 수 있는데
		 *  해당 type의 참조값을 얻기 위해서 인터페이스를 구현한 클래스로
		 *  객체 생성을 하면 된다
		 */
		Remocon r1 = new MyRemocon();
		r1.down();
		r1.up();
	}
}
