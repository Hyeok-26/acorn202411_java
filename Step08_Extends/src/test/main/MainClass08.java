package test.main;

import test.mypac.IosPhone;
import test.mypac.Phone;

public class MainClass08 {
	public static void main(String[] args) {
		//여기서 아래의 usePhone()메소드를 호출하는 code를 작성하고 run 해서 결과를 확인해보세요!
		
		//메소드 호출과 동시에 객체를 생성햏서 전달
		MainClass08.usePhone(new Phone());
		System.out.println("--static 메소드로 클래스 레벨에서 호출--");
		//같은 클래스 안에서 호출하는건 클래스면 생략 가능
		usePhone(new Phone());
		System.out.println("--같은 클래스 내에 존재하여 클래스명 생략 가능--");
		
		//미리 생성된 객체의 참조값을
		Phone p1 = new Phone();
		//참조해서 전달
		MainClass08.usePhone(p1);
		System.out.println("");
		usePhone(p1);
		System.out.println("");
		//자식 type 객체를 전달해도 된다.
		usePhone(new IosPhone());
		System.out.println("");
	}
	//static 메소드 추가(이 메소드를 호출하기 위해서는 Phone type 의 참조값이 필요하다)
	public static void usePhone(Phone p) {
		//매개변수에 전달된 값을 이용햐서 메소드를 호출하는 code
		p.call();
	}
}
