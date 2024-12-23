package test.main;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		//인사말을 담을 ArrayList 객체를 생성해서 참조값을 greets 라는 지역변수에 대입하기
		ArrayList<String> greets = new ArrayList<>();
		//greets 에 들어있는 참조값을 이용해서 인사망 3개를 임의로 담아보세요
		greets.add("안녕하세요!");
		greets.add("반갑습니다");
		greets.add("내가 왕이 될 상인가...");
		
		//확장 for문을 이용해서 모든 인사망을 콘솔창에 순서대로 출력시키세요!
		System.out.println("----확장 for 문을 사용했을 때-----");
		for(String tmp : greets) {
			System.out.println(tmp);
		}
		System.out.println("----1consumer type---");
		
		Consumer<String> con = new Consumer<>() {
			//item에 전달된 배열을 순서대로 호출해준다
			//매개변수 t에 아이템들이 전달된다
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		/*
		 * ArrayList 객체의 forEach() 메소드를 호출하면서 Consumer type 객체를 전달하면
		 * 전달된 객체의 accept() 메소드를 호출하면서
		 * ArrayList 객체에 저장된 item 을 순서대로 매개 변수에 전달해준다*/
		greets.forEach(con);
		
		System.out.println("-------2-------");
		
		Consumer<String> con2 = (t)->{
			System.out.println(t);
		};
		greets.forEach(con2);
		
		System.out.println("-----3--------");
		
		greets.forEach((t)->{
			System.out.println(t);
		});
		
	}
}
