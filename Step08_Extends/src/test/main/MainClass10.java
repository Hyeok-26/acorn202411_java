package test.main;

 import static test.util.MyUtil.*;
//test.util.MyUtil 클래스 안에 있는 모든 static 자원을 import 하기
public class MainClass10 {
	public static void main(String[] args) {
		//static import 를 하면 마치 자신(MianClass10)의 멤버 static 메소드처럼 사용할 수 있다
		clear();
		light();
		send();
	}
}
