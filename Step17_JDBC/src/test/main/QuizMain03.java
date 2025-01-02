package test.main;

import java.util.Scanner;

import test.dao.PostDao;

public class QuizMain03 {
	public static void main(String[] args) {
		
		
		var dao = new PostDao();
		var isSuccess = dao.delete(6);
		if(isSuccess) {
			System.out.println("책을 삭제했습니다");
		}else {
			System.out.println("삭제 실패...ㅠㅠ");
		}
	}
}
