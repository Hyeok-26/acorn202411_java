package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass15 {
	public static void main(String[] args) {
		/*
		 * memberDao 객체를 이용해서
		 * 1번 회원의 이름을 "김구라" 주소를 "노량진"으로 수정해보세요
		 * 단)성공 여부를 콘솔창에 출력하시오
		 */
		
		MemberDto dto = new MemberDto();
		dto.setName("원숭이");
		dto.setAddr("동물원");
		dto.setNum(2);
		
		MemberDao dao = new MemberDao();
		boolean isSuccess = dao.update(dto);
		if(isSuccess) {
			System.out.printf("회원 정보를 수정 완료했습니다.");
		}else {
			System.out.println("수정 실패!");
		}

	}
}
