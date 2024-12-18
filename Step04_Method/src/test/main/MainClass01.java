package test.main;

import test.mypac.Test;
import test.mypac.AirPlane;

public class MainClass01 {
	public static void main(String[] args) {
		Test t = new Test();
		//return type 이 void 인 메소드 호출
		t.walk();
		//return type 이 int 인 메소드를 호출하고 리턴되는 값을 a 라는 int type 지역변수에 담기
		int a = t.getNumber();
		//return type 이 String 인 메소드를 호출하고 리턴되는 값을 b라는 String type 지역변수에 담기
		String b = t.getGreeting();
		
		AirPlane c = t.getPlane();
		
		t.setPlane(new AirPlane());
		t.doSomething(10,"xxx",new AirPlane());
	}
}
