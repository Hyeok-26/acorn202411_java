package test.main;

public class QuizMain {
	/*
	 * 
	 * 1초
	 * 2초
	 * 3초
	 * 
	 * 
	 * 경과 시간이 출려되다가
	 * 
	 * 
	 * 10초
	 * 까지만 출력하고 종료되는 프로그래밍을 해보세요
	 * hint = > Thread.sleep(1000);
	 * */
	public static void main(String[] args) {
		System.out.println("10초 안에 그림을 그려보세요");
		/*for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}System.out.println(i+1+" 초");
		}
		System.out.println("다 그렸다~~~~");
		*/
		int count = 1;
		while(count <= 10) {
			try {
				//작업단위
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}System.out.println(count+" 초");
			count++;
		
		}
	}
}