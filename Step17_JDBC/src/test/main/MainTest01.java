package test.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainTest01 {
	public static void main(String[] args) {
		/*
		 * java 로 oracle 에 scott/TIGER 계정으로 접속해서
		 * 
		 *  모든 사원의 번호, 이름, 직업 , 급여를 사원 이름으로 내림차순으로 정렬해서 select 한다음
		 *  콘솔창에 출력하기
		 */
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
		
		//select 작업을 위해서 필요한 객체의 참조값을 담을 지역 변수 미리 만들기
		PreparedStatement pstmt = null;
		//결과를 저장하는 객체
		ResultSet rs= null;
				
		try{
			//실행할 sql 문을 미리 준비하기(java10부터 추가된 새로운 문자열 만드는 문법)
			String sql = """
					select deptno, dname, loc
					from dept
			""";
			//prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//select 문 실행하고 결과 값을 ResultSet 으로 얻어내기
			rs = pstmt.executeQuery();
			//반복문 돌면서
			//next()는 로우를 확인하고 로우가 있으면 true를 반환
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno+" | "+dname+" | "+loc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------");
		try{
			//실행할 sql 문을 미리 준비하기(java10부터 추가된 새로운 문자열 만드는 문법)
			String sql = """
					select empno, ename, deptno, dname 
					from emp 
					join dept using(deptno) 
					order by empno desc
			""";
			//prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//select 문 실행하고 결과 값을 ResultSet 으로 얻어내기
			rs = pstmt.executeQuery();
			//반복문 돌면서
			//next()는 로우를 확인하고 로우가 있으면 true를 반환
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");;
				System.out.println(empno+" | "+ename+" | "+deptno+" | "+dname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
