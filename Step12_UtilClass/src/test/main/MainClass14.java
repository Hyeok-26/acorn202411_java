package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.mypac.PostDto;

public class MainClass14 {
	public static void main(String[] args) {
		/*  
		 * 1. test.mypac.PostDto 클래스를 만들어 보세요
		 *    PostDto 에는 글번호, 작성자, 제목을 담을수 있어야 합니다.
		 *    즉 3개의 필드를 만드세요
		 *    필드명은 마음데로, 필드의 data type 은 잘 생각해서 결정
		 *    dto 작성 규약에 맞게 만들어 주세요( eclipse generate 기능 활용)
		 *    test.mypac 페키지에 만들기 
		 * 
		 * 2. PostDto 객체에 임의의 글 3개의 정보를 담아 보세요. 
		 *    총 3개의 PostDto 객체가 생성이 되어야 합니다.
		 * 
		 * 3. PostDto 객체를 담을수 있는 ArrayList 객체를 생성해서 위에서 생성한 PostDto 
		 *    객체를 ArrayList 에 담아 보세요.
		 *    
		 * 4. 반복문 돌면서 ArrayList 에 담긴 글 목록을 콘솔창에 이쁘게 출력해 보세요.
		 *  
		 */
		//PosrDto 객체 3개 만들기
		PostDto num1 = new PostDto(1, "사자", "동물의 왕국");
		PostDto num2 = new PostDto(2, "뱁새", "미친듯한 귀여움");
		PostDto num3 = new PostDto(3, "도마뱀", "탈피의 과정");
		
		//ArrayList 객체 생성해서 PostDto객체 담기
		List<PostDto> list = new ArrayList<>();
		list.add(num1);
		list.add(num2);
		list.add(num3);
		
		
		for(PostDto tmp:list) {
			String info = String.format("번호: %d, 이름: %s, 제목: %s", 
					tmp.getNum(), tmp.getName(),tmp.getTitle());
					System.out.println(info);
		}
		System.out.println("------------------------");
		for(PostDto tmp:list) {
			System.out.println("번호: "+tmp.getNum()+" 이름: "+tmp.getName()+" 주소: "+tmp.getTitle());
		}
		
	
	}
}
