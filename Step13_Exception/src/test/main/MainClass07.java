package test.main;

import java.util.Random;

import test.mypac.WowException;

public class MainClass07 {
	public static void main(String[] args) {
		Random ran = new Random();
		//0~9 사이의 숫자 얻어내기
		int ranNum = ran.nextInt(10);
		
		if(ranNum == 7) {
			//여기서 발생하는 Exception 은 JVM 이 적접 처리 한다
			throw new WowException("우와 행운의 7번이다!!");
		}
		System.out.println(ranNum+" 숫자가 나왔습니다");
	}
}
