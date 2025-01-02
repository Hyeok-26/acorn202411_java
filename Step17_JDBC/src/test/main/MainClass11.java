package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass11 {
	public static void main(String[] args) {
		String name = "해골";
		String addr = "강남역";
		int num = 2;
		
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setNum(num);
		
		boolean isSuccess=update(dto);
		
		if(isSuccess) {
			System.out.println("회원 정보를 저장했습니다.");
		}else {
			System.out.println("저장 실패!");
		}
	}
	/*
	 * 수정할 회웑의 정보(번호, 이름, 주소) 가 MemberDto 객체의 담겨서 전달되는 메소드
	 * 성공여부가 리턴되는 메소드
	 * */
	public static boolean update(MemberDto dto) {
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		try {
			conn = new DBConnector().getConn();
			String sql="""
					update member
					set name = ?, addr = ?
					where num = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			
			rowCount = pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}
	}
}
