package test.main;

import java.util.Scanner;

import test.dao.PostDao;
import test.dto.PostDto;

public class QuizMain02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("바꿀 책의 번호 입력: ");
		String id =  scan.nextLine();
		System.out.println("제목 입력: ");
		String title = scan.nextLine();
		System.out.println("내용 입력: ");
		String content = scan.nextLine();
		
		PostDto dto = new PostDto();
		dto.setId(Integer.valueOf(id));
		dto.setTitle(title);
		dto.setContent(content);
		
		PostDao dao = new PostDao();
		boolean isSuccess = dao.update(dto);
		if(isSuccess) {
			System.out.printf("책의 내용을 수정하였습니다");
		}else {
			System.out.println("너무 난잡해요");
		}
		
	}
}
