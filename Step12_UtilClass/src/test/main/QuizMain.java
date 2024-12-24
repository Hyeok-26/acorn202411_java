package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizMain {
	public static void main(String[] args) {
		//1. 정수를 담을 수 있는 ArrayList 객체를 생성하여 nums 라는 지역 변수 담기
		
		List<Integer> nums = new ArrayList<>();
		
		
		//2. 반복문 10번 돌면서 1~100 사이의 랜덤한 정수를 각각 얻어내서
		//위에서 생성한 nums 객체에 순서대로 담기
		
		//랜덤 정수를 얻어낼 객체
		Random r = new Random();
		//반복문을 10번 돌도록 구성
		for(int i=0; i<10; i++) {
			//1~100 사이의 랜덤한 정수 얻어내기
			int ranNum = r.nextInt(100)+1;
			nums.add(ranNum);
		}
		
		//3.nums 에 저장한 숫자에서 중복된 숫자가 제거된 새로운 ArrayList 객체 얻기
		
		Set<Integer> numbers = new HashSet<>(nums);
		List<Integer> list = new ArrayList<>(numbers);
		
		/* 		Set 객체에 숫자를 넣으면 중복이 제거된다
		 * nums.forEach((item)->{
		 *		set.add(item);
		 * });
		 */
		//4. 새로운 배열에 숫자를 오름 차순으로 정렬하기
		
		Collections.sort(list);
		//5.새로운 배열에 저장된 숫자를 순서대로 콘솔창 출력
		
		System.out.println(list);
		/* result.forEach((item)->{
		 * 		System.out.println(item);
		 * });
		 */
		
	}
}
