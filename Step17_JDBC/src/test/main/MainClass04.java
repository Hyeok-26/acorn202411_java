package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass04 {
	public static void main(String[] args) {
		//member 테이블에 row 삭제하기
		int num = 1;
		
		//AUTO COMMIT
		//DB 연결객체를 담을 지역 변수 만들기
		Connection conn=null;
		try {
		//오라클 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//접속할 DB 의 정보 @아이피주소:port번호:db이름
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
		conn=DriverManager.getConnection(url, "scott", "TIGER");
		//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
		System.out.println("Oracle DB 접속 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
		//sql문을 대신할 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		try {
			//실행할 미완성의 sql문
			String sql = """
					delete from member
					where num = ?
					""";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻기
			pstmt = conn.prepareStatement(sql);
			//미완성의 sql 문 완성시키기(? 에 순서대로 값 바인딩하기)
			pstmt.setInt(1, num);
			//sql문 실행하기
			pstmt.executeUpdate();//insert, update, delete 는 모두 executeUpdate() 를 호출하면 된다
			System.out.println("회원정보를 저장했습니다");
		}catch(Exception sql) {
			sql.printStackTrace();
		}
	}
}