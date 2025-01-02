package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.EmpDeptDto;
import test.util.DBConnector;

public class MainClass09 {
	public static void main(String[] args) {
		//부서목록을 아주 쉽게 얻어낼 수 있다(날로 먹을 수 있다)
		List<EmpDeptDto> list = getList();
		for (EmpDeptDto tmp : list) {
			System.out.printf("사원번호:%d 사원이름 :%s 부서번호 :%d 부서이름: %s",
					tmp.getEmpno(),tmp.getEname(),tmp.getDeptno(),tmp.getDname());
	        System.out.println();
		}
	}
	public static List<EmpDeptDto>getList(){
		//여기에 어떻게 코딩하면 회원 목록응 리턴해줄 수 있을까? 코딩해보세요
		List<EmpDeptDto> list = new ArrayList<>();
		//필요한객체를 담을 지역변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			//우리가 설계한 클래스로 객체생성 후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql="""
					select empno, ename, deptno, dname as deptName
					from emp
					join dept using(deptno)
					order by deptno asc
					""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//추출한 부서 정보를 DeptDto객체에 담고 바로set 에 담가준다
				EmpDeptDto mem = new EmpDeptDto();
				mem.setEmpno(rs.getInt("empno"));
				mem.setEname(rs.getString("ename"));
				mem.setDeptno(rs.getInt("deptno"));
				mem.setDname(rs.getString("deptName"));
		        //DeptDto 값은 list에 넣는다
		        list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
