package test.mypac;

public class AndroidPhone extends HandPhone {
	//생성자
	public AndroidPhone() {
		System.out.println("AndroidPhone 생성자 호출됨");
	}
	//메소드
	public void doInternet() {
		System.out.println("인터넷을 해요!");
	}
	@Override   //부모 메서드를 재정의 없어도 됨(생략가능)
	public void takePicture() {
		System.out.println("1000만 화소의 사진을 찍어요!");
		//super.takePicture();
	}
	
}
