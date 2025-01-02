package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass10 {
	public static void main(String[] args) {
		//추가힐 회원 정보라고 가정
		String name = "김구라";
		String addr = "노량진";
		
		//추가할 회원정보를 MemberDto 객체에 담고
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//미리 준비된 메소드를 이용해서 DB에 저장하고 성공여부를 리턴 받는다
		boolean isSuccess=insert(dto);
		
		if(isSuccess) {
			System.out.println("회원 정보를 저장했습니다.");
		}else {
			System.out.println("저장 실패!");
		}
	}
	//매개변수에 전달한 MemberDto 객체에 담긴 naem 과 addr 을  DB 에 저장하고
	//작업의 성공 여부를 리턴하는 메소드
	public static boolean insert(MemberDto dto) {
		//필요한 객체에 담을 지역 변수 리 만들기
		Connection conn= null;
		PreparedStatement pstmt = null;
		//변화된 row 갯수를 저장할 변수를 0 을 대입해서 미리 만들어 둔다.
		int rowCount = 0;
		try {
			//Connection 객체의 참조값 얻어내기
			conn = new DBConnector().getConn();
			//실행할 미완성의 sql문
			String sql="""
					INSERT INTO member
					(num, name, addr)
					values(member_seq.NEXTVAL, ?, ?)
					""";
			//미완성의 SQL문을 전달하면서 PreparedStatement 객체의 참조값 얻어내시
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 하기
			pstmt.setNString(1, dto.getName());
			pstmt.setNString(2, dto.getAddr());
			//sql 문 실행하고 추가되거나, 변경되거나, 삭제(insert, update, delete)된 row 의 갯수리턴 받기
			//pstmt.executeUpdate();//int 값이 리턴(리턴 값이 0보다 커야 작업이 성공함)
			//pstmt.executeQuery();//select 문
			rowCount = pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//rowCount 변수에 들어있는 값을 확인해서 작업의 성공여부를 리턴
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}
	}
}
