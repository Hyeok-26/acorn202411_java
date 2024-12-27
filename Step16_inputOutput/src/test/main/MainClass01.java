package test.main;

import java.io.IOException;
import java.io.InputStream;

/*
 *  입역,출력(input,output)
 *  
 *  - 어떤 대상으로 부터 데이터를 메모리로 읽어 들이는 것을 입력이라고 한다
 *  - 프로그래민 언어의 관점에서 메모리라는 것은 변수 or 필드 or 객체로 생각하면 된다
 *  - 데이터는 2진수로 이루어져 있지만 2진수 8개의 묶음인 1byte 단위로 생각하면 편하다
 *  - 1byte는 총 256 가지의 값을 표현할 수 있다
 *  - 1byte 를 10진수로 확산하면 0~ 255 사이의 숫자중의 하나이다
 *  - 입력과 출력을 통해서 이동하는 데이터는 byte  하나 하나가 이동한다고 생각하면 된다
 */
public class MainClass01 {
	public static void main(String[] args) {
		
		System.out.println("main 메소드가 시작되었습니다");
		
		//키보드와 연결된 InputStream type의 참조값을 kdb라는 지역변수에 담기
		//InputStream 객체는 1byte 단위 처리 시스템이다
		//영문자,대소문자, 숫자, 특수문자만 처리할 수 있다
		//한글 처리 불가
		
		InputStream kbd = System.in;
		try {
			//입력한 키의 code 값 일어오기
			int code = kbd.read();
			System.out.println("code:"+code);
			//코드 값에 대응되는 문자 얻어내기
			char ch =(char)code;
			System.out.println("ch: "+ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
