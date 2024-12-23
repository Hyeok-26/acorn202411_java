package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		//1.Member객체를 담을 수 있는 ArrayList 객체를 생성해서 참조값은 members라는 List type 지역변수에 담시
		List<Member> members =new ArrayList<>();
		
		//2.3명의 회원정보를 Member 객체에 각각담기
		Member m1 = new Member(1, "김구라", "행신동");
		Member m2 = new Member(2, "해골", "노량진");
		Member m3 = new Member(3, "원숭이", "봉담");
		
		//3.Member 객체의 참족ㅄ을 List 객체에 모두 담아보세요
		members.add(m1);
		members.add(m2);
		members.add(m3);
		
		//4. 객체에 담긴 내용을 이용해서 회원 목록을 아래와 같은 형식으로 반목문 돌면서 출력해보세요
		for(Member mem:members) {
			System.out.println("번호: "+mem.num+" 이름: "+mem.name+" 주소: "+mem.addr);
		}
		
		/*
		 * 	for(Member tmp:members) {
				//String 클래스의 format() 이라는 static 메소드를 이용해서 원하는 문자열 형식을 만든다음
				String info = String.format("번호: %d, 이름: %s, 주소: %s", 
						tmp.num, tmp.name, tmp.addr);
				//콘솔창에 출력하기 
				System.out.println(info);
			}
		*/	
	}
}
