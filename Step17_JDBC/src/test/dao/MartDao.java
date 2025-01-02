package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MartDto;
import test.util.DBConnector;

public class MartDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int rowCount = 0;
	public boolean insert(MartDto dto) {
		try {
			conn = new DBConnector().getConn();
			String sql = """
					INSERT INTO Mart
					(code, name, price, loc)
					values(mart_seq.nextval, ?, ?, ?)
			""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getLoc());
			
			rowCount = pstmt.executeUpdate();
		}catch(SQLException sq) {
			sq.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean update(MartDto dto) {
		try {
			conn = new DBConnector().getConn();
			String sql ="""
					UPDATE Mart
					SET name = ?,price = ?,loc= ?
					WHERE code = ?
			""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getLoc());
			pstmt.setInt(4, dto.getCode());
			
			rowCount = pstmt.executeUpdate();
		}catch(SQLException sq) {
			sq.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();	
			}catch (Exception e) {}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean delete(int code) {
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
					delete from Mart
					where code = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			//sql 문 실행
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	public List<MartDto>getList(){
		List<MartDto>list = new ArrayList<>();
		try {
			conn = new DBConnector().getConn();
			String sql = """
					select code, name, price, loc
					from Mart
					order by code asc
			""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.
			
			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				var fd = new MartDto();
				fd.setCode(rs.getInt("code"));
				fd.setName(rs.getString("name"));
				fd.setPrice(rs.getInt("price"));
				fd.setLoc(rs.getString("loc"));
				
				list.add(fd);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}return list;
	}
	public MartDto getData(int code) {
		MartDto dto = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					select name, price, loc
					from Mart
					where code = ?
					""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.
			pstmt.setInt(1, code);
			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new MartDto();
				dto.setCode(code);
                dto.setName(rs.getString("name"));
                dto.setPrice(rs.getInt("price"));
                dto.setLoc(rs.getString("loc"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}return dto;
	}
}
