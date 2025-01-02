package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass06 {
	public static void main(String[] args) {
		//회원목록을 아주 쉽게 얻어낼 수 있다(날로 먹을 수 있다)
		List<MemberDto> list = getList();
		for(MemberDto tmp: list) {
			System.out.printf("번호: %d, 이름: %s, 주소: %s \r\n", 
					tmp.getNum(), tmp.getName(),tmp.getAddr());
					
		}
	}
	//미리 준비된 메소드가 있다고 가정하면
	public static List<MemberDto> getList(){
		//여기에 어떻게 코딩하면 회원 목록응 리턴해줄 수 있을까? 코딩해보세요
		List<MemberDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//우리가 설계한 클래스로 객체생성 후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql="""
					select num, name, addr
					from member
					order by num asc
					""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				
				MemberDto m= new MemberDto();
				m.setNum(num);
				m.setName(name);
				m.setAddr(addr);
				
				list.add(m);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
