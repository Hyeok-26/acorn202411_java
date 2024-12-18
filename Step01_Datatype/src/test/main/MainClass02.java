package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		
		System.out.println("main 메소드가 출력되었습니다.");
		
		int kor = 95;
		int eng = 100;
		double avg = (kor+eng)/2d;
		//정수끼리 연산하면 결과는 정수만 나오기 때문에 2 옆에 d 를 붙여서 실수로 만들어준다
		System.out.println(avg);
	}
}
