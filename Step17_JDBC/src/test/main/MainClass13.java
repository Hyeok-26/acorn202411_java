package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass13 {
	public static void main(String[] args) {
		int num = 2;//select 해야 할 회원의 정보라 가정하면
		
		MemberDto dto = getData(num);
		//미리 준비한 메소드를 호출하면서 회원번호를 전달하고 해당하는 회원정보를 리턴받는다
		if(dto != null) {
			System.out.printf("번호: %d 이름: %s 주소: %s",dto.getNum(),dto.getName(),dto.getAddr());
        } else {
            System.out.println("해당 회원 정보를 찾을 수 없습니다.");
        }
	}
	/*
	 * 매개 변수를 전달되는 번호에 해당하는 회원 정보를 Select 해서
	 * MemberDto 객체에 담아서 리턴해주는 메소드
	 * */
	public static MemberDto getData(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto dto = null;
		
		try {
			conn = new DBConnector().getConn();
			String sql="""
					select num, name, addr
					from member
					where num = ?
					""";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			//만일 select 된 로우가 있다면 
			if(rs.next()) {
				//객체 생성하여
				dto = new MemberDto();
				//select 된 정보 담는다
                dto.setNum(num);
                dto.setName(rs.getString("name"));
                dto.setAddr(rs.getString("addr"));
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return dto;
	}
}
