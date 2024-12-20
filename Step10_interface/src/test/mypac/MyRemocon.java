package test.mypac;

public class MyRemocon implements Remocon{
	//Remocon type 을 부르기 위한 매개체
	@Override
	public void up() {
		System.out.println("볼륨을 올려요!");		
	}

	@Override
	public void down() {
		System.out.println("볼륨을 내려요!");
	}//인터페이스는 implements 해야 한다

}
