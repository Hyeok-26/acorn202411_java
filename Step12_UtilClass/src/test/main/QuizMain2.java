package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizMain2 {
	public static void main(String[] args) {
		//1.로또 번호를 담을 HashSet 객체를 생성해서 set1 ㅇ라는 지역 변수에 담아보기
		Set<Integer> set1 = new HashSet<>();
		//2.while 문을 이용해서 랜덤한 로또 번호를 set1에 반복적으로 담기
		//while 문 탈출 조건은 set1.size() 가 6이 되면 탈출해보도록
		Random ran = new Random();
		while(true) {
			//1~45 사이의 랜덤한 숫자 얻기
			int ranNum = ran.nextInt(45)+1;
			//Set 객체에 담기
			set1.add(ranNum);
			//스탑
			if(set1.size()==6) {
				break;
			}
			
		}
		//3.set1에 담긴 번호를 오름차순으로 정렬해서 콘솔창에 띄우세요
		List<Integer> list = new ArrayList<>(set1);
		Collections.sort(list);
		for(Integer nums:list) {
			System.out.println(nums);
		}
	}
}
