package test.auto;

public class SportsCar extends Car{
	//Engine type 을 매개 변수에 전달받는 생성자
	public SportsCar(Engine engine) {
		/*
		 * super()는 부모 생성자 (Car 클래스의 생성자)
		 * 부모 생성자에 필요한 값을 자식 생성자에서 받아서 전달해야 한다
		 * super()코드 실행 전에 다른 코드가 있으면 안된다
		*/
		super(engine);
	}
	//메서드
	public void openDrive() {
		if(this.engine==null) {
			System.out.println("Engine이 없어서 달릴 수가 없어요");
			return;//메서드를 여기서 리턴시키기(종료시키기)
		}
		System.out.println("뚜껑을 열고 달려요");
	}
	
}
