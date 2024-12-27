package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  C:/Users/acorn/Desktop/playground/myFoler/memo.txt  파일에 저장된 문자열을 읽어와서
 *  콘솔창에 출력하는 예제 
 */
public class MainClass07 {
	public static void main(String[] args) {
		System.out.println("main() 메소드가 \"시작\" 되었습니다");
		System.out.println("main() 메소드가 \\시작\\ 되었습니다.");
		
		//파일에  msg 변수 안에 들어있는 문자열을 출력하기 
		//파일에 저장할 문자열
		String msg = "나는 java 의 신이다!";
		
		//memo.txt 파일을 만들기 위한 File 객체
		//File f = new File("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\memo.txt");
		//슬래시는 하나만 서도 인식한다
		File f = new File("C:/Users/acorn/Desktop/playground/myFolder/memo.txt");
		try {
			if(!f.exists()) {
				//새로 만들어라
				f.createNewFile();
				System.out.println("memo.txt 파일을 만들었습니다");
			}
			//new FileWriter 객체, append mode 여부(디폴트값 false) 
			var fw = new FileWriter(f, true);
			fw.append(msg);
			fw.append("\r\n");
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
