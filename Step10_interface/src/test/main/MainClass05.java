package test.main;

import test.mypac.Calc;
//			람다 함수!!!
public class MainClass05 {
	public static void main(String[] args) {
		//interface 객체를 불러 이름이 없는 inner class ? extends Calc 자식클래스
		//를 생성하고 double type의 매개변수 2개를 생성한다  
		Calc c1 = new Calc() {
			@Override
			public double execute(double num1, double num2) {

				return 0;
			}
		};
		// 매개변수는 실제 메소드를 실행할 호출값 인수 라고 한다
		//execute(double num1) => 	double 타입 num1 = doutype 값
		//객체를 만들면 Calc c1 = new Calc();
		//
		
		
		//인터페이스 메소드가 1개인기 때문에 람다 함수를 사용할 수 있다
		//Calc class의 메서드를 오버라이딩을 통해
		//매개변수 2개를 생성해 재정의 시킨다
		Calc c2 = (double a, double b)->{
			return 0;
		};
		
		//매개변수의 type 은 생략 가능
		Calc c3 = (a, b)->{
			//return 에약어 이전에 coding된 내용이 없음
			return 0;
		};
		
		//return 예약어 이전에 coding된 내용이 없으면 {} 생략 가능
		Calc c4 = (a, b)-> 0;//리턴 값만 명시하면 되기 때문에 return 예약어도 생략
		
		//매개변수에 전달된 두 숫자를 더한 값을 리턴하는 동작
		Calc plus = (a, b) -> a + b;
		System.out.println("a 와 b 를 더하면: "+plus.execute(10.2, 10.4));
		
		Calc minus = (a, b) -> a - b;
		System.out.println("a 에서 b 를 빼면: "+minus.execute(20.4, 8.2));
		
		Calc multiple = (a, b) -> a * b;
		System.out.println("a 와 b 를 곱하면: "+multiple.execute(123.5, 1234.2));
		
		Calc divide = (a, b)->a/b;
		System.out.println("a 와 b 를 나누면: "+divide.execute(10.1, 20.21));
		
	}
}
