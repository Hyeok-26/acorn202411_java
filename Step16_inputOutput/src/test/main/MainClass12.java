package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//에전 실무에서 사용하던 코드 
//바깥 영역에 선언만 해서 여러 블럭ㅇ에서 사용할 수 있도록 해결
//exception 이 발샹하면 웹서버에선 메모리가 사라지지 않고 게속 축적된다
public class MainClass12 {
	public static void main(String[] args) {
		//필요한 객체의 참조값을 담을 변수를 미리 반들어 둔다
		FileInputStream fis = null;//선언
		FileOutputStream fos = null;
		
		try {
			//파일로부터 byte 알갱이를 읽어들맇 객체 생성
			fis = new FileInputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\1.jpg");
			//byte 알갱이를 파일에 출력할 객체 생성    //대입
			fos = new FileOutputStream("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\copied.jpg");
			//byte 알갱이 여러개를 한번에 담을 배열 미리 준비
			byte[] buffer = new byte[1024];
			
			while(true) {
				//byte[] 배열을 전달ㄹ해서 byte 알갱이를 한번에 1024 개씩 읽어온다
				int readedCount = fis.read(buffer);//읽어들인 갯수 리턴된다
				System.out.println(readedCount+" byte를 읽었습니다");
				if(readedCount == -1)break;//끝나면 반복문 탈출
				//byte[] 배열에 저장된 byte 알갱이를 0번 인덱스로 부터 읽은 갯수만큼 출력하기
				//배열 전채를 읽으면 끝부분에 이전 배열도 읽어올 수 있어 크기를 지정하고 출력한다
				// 읽을 객체, 인덱스 시작지점,읽을 끝지점까지
				fos.write(buffer, 0, readedCount);
			}
			System.out.println("파일을 copy 했습니다");
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			//메모리 누수를 방지하기 위해 항상 마무리 작업 해야 한다
			try {
				if(fos != null)fos.close();
				if(fis != null)fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
