package test.main;

import java.util.List;
import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass17 {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 불러올 회원의 번호를 입력받은 다음
		 * 
		 * 입력한 번호에 해당하는 회원의 정보를 MemberDto 객체를 이용해서 얻어온 다음
		 * 
		 * 해당 회원이 존재하면 해당 회원의 정보를 콘솔에 출력하고
		 * 
		 * 존재하지 않으면 "x 번 회원은 존재하지 않습니다" 를 콘솔차에에 출력하세요
		 * hint) MemberDao 객체의 .getData() 메소드를 활용하세요
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("회원 번호: ");
		int num = scan.nextInt();
		
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.getData(num);
		
		if(dto != null) {
			System.out.printf("번호: %d 이름: %s 주소: %s",dto.getNum(), dto.getName(), dto.getAddr());
		}else {
			System.out.printf("%d 번 회원은 존재하지 않습니다",num);
		}
		
		
		
	}
}
