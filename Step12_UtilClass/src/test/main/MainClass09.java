package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		//3명의 회원정보(num, name, addr)를 HashMap 객체를 생성해서 담기
		//HashMap 객체 하나당 한명의 회원정보를 담으니깐 총 3개의 HashMap객체 생성\
		Map<String, Object> mem1 = new HashMap<>();
		Map<String, Object> mem2 = new HashMap<>();
		Map<String, Object> mem3 = new HashMap<>();
		
		mem1.put("num", 1);
		mem1.put("name", "김구라");
		mem1.put("addr", "노량진");
		
		mem2.put("num", 2);
		mem2.put("name", "해골");
		mem2.put("addr", "행신동");
		
		mem3.put("num", 3);
		mem3.put("name", "원숭이");
		mem3.put("addr", "봉담");
		
		//javascript 의 object 배열 구조와 비슷
		//위에서 생성한 HashMap객체를 담을 ArrayList 객체 생성
		List<Map<String, Object>> list = new ArrayList<>();
		//ArrayList 객체에 HashMap 객체 3개를 담기
		list.add(mem1);
		list.add(mem2);
		list.add(mem3);
		//반복문 돌려서 ArrayList  에 담긴 회워정보를 콘솔창에 이쁘게 출력
		for(Map<String, Object> tmp:list) {
			String info = String.format("번호: %d, 이름: %s, 주소: %s", 
					tmp.get("num"), tmp.get("name"),tmp.get("addr"));
					System.out.println(info);
		}
	}
}
