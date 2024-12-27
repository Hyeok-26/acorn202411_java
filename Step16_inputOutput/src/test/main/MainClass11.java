package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass11 {
	public static void main(String[] args) {
		try {
			//파일로부터 byte 알갱이를 읽어들맇 객체 생성
			var fis = new FileInputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\1.jpg");
			//byte 알갱이를 파일에 출력할 객체 생성
			var fos = 
					new FileOutputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\copied.jpg");
			while(true) {
				//1byte 읽어들여서
				int readedByte = fis.read();
				System.out.println(readedByte);
				if(readedByte == -1)break;//실행할 코드가 한 줄이면 이런 식으로 쓰기도 한다
				//읽어들인 1byte 출력
				fos.write(readedByte);
				fos.flush();
			}
			System.out.println("파일을 copy 했습니다");
			//메모리 누수를 방지하기 위해 항상 마무리 작업 해야 한다
			fos.close();
			fis.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
