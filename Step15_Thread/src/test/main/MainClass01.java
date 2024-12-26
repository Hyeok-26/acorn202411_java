package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다");
		
		try {
			//5초도안 스레드가 진행되지 않음
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test();//메소드 안쪽으로 실행의 흐름이 넘어간다
		
		System.out.println("main 메소드가 종료되었습니다");
	}
	
	public static void test() {
		//test() 메소드 리턴
		System.out.println("test() 메소드 호출됨");
	}
}
