package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창에 출력할 수 있는 객체의 참조값 얻어내기
		PrintStream ps = System.out;
		//PrintStream 객체의 참조값을 부모 type 변수에 담기
		//OutputStream 도 1byte 처리 스트림이다
		OutputStream os = ps;
		for(int i=0; i<100;i++) {
			for(int j=1;j<10;j++) {
				try {
					os.write(i);
					os.flush();//방출
				} catch (IOException e) {
					e.printStackTrace();
				}
			}System.out.println("");
		}
	}
}
