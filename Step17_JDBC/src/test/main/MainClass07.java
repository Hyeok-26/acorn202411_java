package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.EmpDto;
import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass07 {
	public static void main(String[] args) {
		//사원목록을 아주 쉽게 얻어낼 수 있다(날로 먹을 수 있다)
		List<EmpDto> list = getList();
		for (EmpDto tmp : list) {
            System.out.printf("사원번호:%d, 사원이름 : %s 직업 : %s, 급여: %f",
            		tmp.getEmpno(),tmp.getEname(),tmp.getJob(),tmp.getSal());
            System.out.println();
        }
	}
	//미리 준비된 메소드가 있다고 가정하면
	public static List<EmpDto> getList(){
		//여기에 어떻게 코딩하면 회원 목록응 리턴해줄 수 있을까? 코딩해보세요
		List<EmpDto> list = new ArrayList<>();
		//필요한객체를 담을 지역변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//우리가 설계한 클래스로 객체생성 후 Connection 객체 얻어내기
			conn = new DBConnector().getConn();
			String sql="""
					select empno, ename, job,sal
					from emp
					order by empno asc
					""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("empno");
				String name = rs.getString("ename");
				String job = rs.getString("job");
				Double sal = rs.getDouble("sal");
				
				//추출한 사원 한명의 정보를  EmpDto 객체에 담ㄷ는디
				EmpDto emp = new EmpDto();
				emp.setEmpno(num);
                emp.setEname(name);
                emp.setJob(job);
                emp.setSal(sal);
                //EmpDto 값은 list에 넣는다
                list.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
