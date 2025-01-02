package test.main;

import java.util.Scanner;

import test.dao.PostDao;
import test.dto.PostDto;

public class QuizMain05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("책 번호: ");
		int id = scan.nextInt();
		
		
		PostDao dao = new PostDao();
		PostDto dto = dao.getData(id);
		
		if(dto != null) {
			System.out.printf("번호: %d 제목: %s 내용: %s",dto.getId(), dto.getTitle(), dto.getContent());
		}else {
			System.out.printf("%d 번 책은 존재하지 않습니다",id);
		}
	}
}
