package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 *  File 객체와 Scanner 객체의 도움을 받으면
 *  파일로부터 문자열을 읽어 들일 수 있다
 *  System.out 에 있는 PrintStream 객체의
 *  도움을 받으면 콜솔창에 문자열을 출력할 수 있다
 */
public class MainClass05 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/test/mypac/memo.txt");
		Scanner scan = new Scanner(f);
		while(true) {
			String line = scan.nextLine();
			System.out.println(line);
		}
		
	}
}
