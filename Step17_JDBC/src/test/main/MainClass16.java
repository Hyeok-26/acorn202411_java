package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass16 {
	public static void main(String[] args) {
		// 객체를 이용해서 1번 회원의 정보를 삭제해 보세요
		//단) 성공여부는 콘솔창에
		
		var dao = new MemberDao();
		var isSuccess = dao.delete(1);
		if(isSuccess) {
			System.out.println("삭제 성공했습니다");
		}else {
			System.out.println("삭제 실패...ㅠㅠ");
		}
	}
}
