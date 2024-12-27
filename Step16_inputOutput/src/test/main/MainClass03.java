package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 실행되었습니다");
		//1byte 처리 스트림
		InputStream kdb = System.in;
		//2byte 처리 스트림(65536 가지를 표현할 수 있다)한글 처리 가는한 객체
		var isr = new InputStreamReader(kdb);
		//문자열에 한해서만
		//BufferredReader 의 생성자로 InputStreamReader 객체를 전달해서 객체 생성
		var br = new BufferedReader(isr);
		System.out.println("입력: ");
		try {
			String line = br.readLine();
			System.out.println("line: "+line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
