package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		//1.MemberDto 객체를 담을 수 있는 ArrayList 객체를 생성해서 members 라는 지역변수 담기
		List<MemberDto> members = new ArrayList<>();
		
		//2. 3명의 회원정보를 MemberDto객체에 각각 담기
		MemberDto m1 = new MemberDto();
		m1.setNum(1);
		m1.setName("김구라");
		m1.setAddr("행신동");
		
		MemberDto m2 = new MemberDto(2, "해골", "노량진");
		MemberDto m3 = new MemberDto(3, "원숭이", "봉담");
		
		//3. 윙서 생성된 MemberDto객체의 참조값으로 ArrayList객체에 모두 담아보세요
		members.add(m1);
		members.add(m2);
		members.add(m3);
		
		//4.반복문을 이용해서 members 에 들어있는 회원정보를 출력해 본세요
		for(MemberDto mem:members) {
			String info = String.format("번호: %d, 이름: %s, 주소: %s", 
					mem.getNum(), mem.getName(),mem.getAddr());
					System.out.println(info);
		}
		
		System.out.println("----------------");
		//테스트 메소드 호출(매개 변수에 전달할 String type 의 갯수는 유동적이다)
		test();
		test("kim");
		test("kim","lee","park");
		
	}
	
	//...테스트
	
	public static void test(String...msgs) {
		//String... 은 String[] type 이다
		String[] a=msgs;
	}
}
