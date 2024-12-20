package test.mypac;
//추상다중부모영역전개
//@로 시작하는 표시(어노텡션이라고 부른다)
@FunctionalInterface
//추상메소드를 1개만 만들도록 강제하는 역할( ()->{} 형태로 사용할 수 있도록 보장)
public interface Calc {
	//어떤 연산을 할 지 개발자 알아서 정하기
	public double execute(double num1, double num2);
	//invalid '@FunctionalInterface' annotation; Calc is not a functional interface
	//public void test();
}
