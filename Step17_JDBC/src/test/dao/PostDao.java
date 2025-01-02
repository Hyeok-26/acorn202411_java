package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.PostDto;
import test.util.DBConnector;

public class PostDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	int rowCount = 0;
	ResultSet rs = null;
	public boolean insert(PostDto dto) {
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
					INSERT INTO posts
					(id, title, content)
					values(posts_seq.NEXTVAL, ?, ?)
			""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
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
			} catch (Exception e) {}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean update(PostDto dto) {
		try {
			conn = new DBConnector().getConn();
			String sql = """
					update posts
					set title = ?,content = ?
					where id = ?
			""";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getId());
			
			rowCount = pstmt.executeUpdate();
		}catch(SQLException sq) {
			sq.printStackTrace();
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
	public boolean delete(int id) {
		try {
			conn = new DBConnector().getConn();
			//실행할 sql 문
			String sql = """
					delete from posts
					where id = ?
			""";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩
			pstmt.setInt(1, id);
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
	public List<PostDto>getList(){
		List<PostDto>list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					select id, title, content
					from posts
					order by id asc
			""";
			pstmt = conn.prepareStatement(sql);
			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				var pd = new PostDto();
				pd.setId(rs.getInt("id"));
				pd.setTitle(rs.getString("title"));
				pd.setContent(rs.getString("content"));
				
				list.add(pd);
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
	public PostDto getData(int id) {
		PostDto dto = null;
		try {
			conn = new DBConnector().getConn();
			String sql = """
					select title, content
					from posts
					where id = ?
			""";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 할게 있으면 여기서 한다.
			pstmt.setInt(1, id);
			//select 문 실행하고 결과를 ResultSet 객체로 리턴받기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new PostDto();
				dto.setId(id);
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
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
