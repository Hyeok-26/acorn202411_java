package test.mypac;

public class IosPhone extends HandPhone {
	public IosPhone() {
		System.out.println("IosPhone 생성자 호출됨");
	}
	public void appleWatch() {
		System.out.println("심장박동수가 높습니다!!");
	}
	@Override
	public void call() {
		System.out.println("시계로 전화를 걸어요");
	}
	public void takePicture() {
		System.out.println("아이폰 갬성");
	}
	
}
