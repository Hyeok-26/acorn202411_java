package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass11 {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		
		//read only 오 사용할거라면 위의 세줄을 아래와 같이 한줄로 작성할 수 있다.
		List<Integer> nums2 = List.of(10, 20, 30);
		
		//nums2.add(40);//read only 라 데이터를 추가하면 오류남
		//nums2.remove(0);//삭제 불가
		//nums2.set(0, 999);//수정 불가
	}
}