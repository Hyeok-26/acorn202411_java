package test.mypac;

//미완성된 추상메소드를 멤버로 가지고 예약어는 클래스는 abstract 예약어를 붙여서 정의 해야 한다
public abstract class Weapon {
	//무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비 합니다.");
	}
	//상황에 따라서 메소드를 미완성인 상태로 두는 경우도 있다
	//public void attack();
	//공격을 하는 메소드의 모양만 정의하고 실제 구현은 하지 않기 == 추상클래스
	//미완성된 추상메소드를 만들 때는 abstract 예약어가 필요
	//변수 데이터 타입 역할은 가능하다
	public abstract void attack();
}
