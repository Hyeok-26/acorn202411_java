package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass04 {
	public static void main(String[] args) throws FileNotFoundException {
	 //디렉토리 or 파일을 이용하고자 할 때 사용
		 File f = new File("src/test/mypac/memo.txt");
		 
		 Scanner scan = new Scanner(f);
		 /*
		  * public class Scanner{
		  * 	public Scanner(File file){
		  * 		해당 file 객체에서 문자열을 읽어들일 준비를 함
		  * 	}
		  * }
		  * 우리가 필요한 객체와 클래스들을 import 해서 적절하게 사용할 수 있어야 된다
		  * 
		  * 컴퓨터 입장에선 개행기호 \n 를 기준으로 줄을 읽어옴 
		  * */
		 
		 String line = scan.nextLine();
		 System.out.println("memo.txt 파일의 첫번째 줄: "+line);
	}
}
