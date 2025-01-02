package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnector;
/*
 *  회원정보를 insert, update, delete, select 할 수 있는 기능을 가진 객체를 생성할 클래스 설계
 *  
 *  - 이런 기능을 가진 객체를 Data Aaccess Object 라고 한다 DAO*/
public class MemberDao {
	Connection conn =null;
	PreparedStatement pstmt = null;
	int rowCount = 0;
	ResultSet rs = null;
	//매개변수에 전달된 객체에 담긴 회원 한명의 정보를 DB에 저장
	public boolean insert(MemberDto dto) {
		try {
			conn = new DBConnector().getConn();
			String sql="""
					INSERT INTO member
					(num, name, addr)
					values(member_seq.NEXTVAL, ?, ?)
			""";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			
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
	//매개변수에 전달된 객체에 담긴 회원 한명의 정보를 수정
	public boolean update(MemberDto dto) {
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
	//매개변수에 전달된 번호에 해당하는 회원 한명의 정보 삭제
	public boolean delete(int num) {
		try {
			conn = new DBConnector().getConn();
			String sql="""
					delete from member
					where num =?
			""";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
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
	//전체 회원목록을 리턴하는 메소드
	public List<MemberDto>getList(){
		List<MemberDto> list = new ArrayList<>();
		try {
			conn = new DBConnector().getConn();
			String sql="""
					select num, name, addr
					from member
					order by num asc
			""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//MemberDto 객체를 생성해서
				var mem = new MemberDto();
				//ResultSet 에 담긴 정보를 추출해서 MemberDto 객체에 담은 다음
		        mem.setNum(rs.getInt("num"));
		        mem.setName(rs.getString("name"));
		        mem.setAddr(rs.getString("addr"));
				//MemeberDto 값은 list 에 넣는다
		        list.add(mem);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}//회원 정보가 누적된 ArrayList 객체 리턴
		 //select 된 row가 하나도 없다면 list.size()는 0이다
		 return list;
	}
	//매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		MemberDto dto = null;
		try {
			conn = new DBConnector().getConn();
			String sql="""
					select name, addr
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
		//select 된 정보가 없으면 dto 는 null 이다
		return dto;
	}
}