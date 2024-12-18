package Test.main;
/*
 * [증감 연산자 테스트]
 *   변수에 있는 숫자 값을  1씯 증가 혹은 1씩 감소 시킬 때 사용한다*/
public class MainClass02 {
	public static void main(String[] args) {
		int num = 0;
		num++;
		num++;
		num++;//num 이 최종적으로 3이 된다
		
		int num2 = 0;
		num2--;
		num2--;
		num2--;//num2가 최종적으로 -3 이 된다
		
		int num3 = 0;
		int reuslt = num3++;//result 에 0 이 대입되고 num3 가 1 증가
		
		int num4 = 0;
		int result2 = ++num4;//num4 가 1증가하고 result2 에 1 이 대입
	}
}
