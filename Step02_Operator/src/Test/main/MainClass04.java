package Test.main;
/*
 * 4. 논리 연산자 테스트
 * && , || , !
 */
public class MainClass04 {
	public static void main(String[] args) {
		/* or 연산
		 *  또는 이라고 일긍면 된다
		 *  
		 *   어느 하나라만 true 면 결과도 참
		 *    모두 다 false일 때 만 결과 거짓
		 */
		boolean result1 = false || false;//false
		boolean result2 = false || true;//true
		boolean result3 = true || false;//true
		boolean result4 = true || true;//true
		
		/* and 연산자
		 * 그리고 라고 읽으면 된다
		 * 
		 * 모두 다 true 일 떄만 결과 true
		 * 어느 하나만 false면 결과는 false
		 */
		boolean result5 = true && true;//true
		boolean result6 = false && true;//false
		boolean result7 = true && false;//false
		boolean result8 = false && false;//false
		
		/* not 연산자
		 * ~가 아니면 이라고 읽으면 된다
		 * 
		 * boolean값을 반전시킨다
		 * */
		boolean result9 = !true;//false
		boolean result10 = !false;//true
	}
}
