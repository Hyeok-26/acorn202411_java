package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnector;
//select 된 row 하나의 정보를 이 객체에 담고
//row가 여러개니까 dto객체도 여러개이다
//이 여러 객체를 list<Member> 객체에 순서대로 담는 연습
public class MainClass05 {
	public static void main(String[] args) {
		//회원목록을 불러와서 몬솔에 출력하기
		
		//필요한 객체를 담을 지역변수 미리 준비
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
				System.out.printf("번호:%d, 이름:%s, 주소:%s",num,name,addr);
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
