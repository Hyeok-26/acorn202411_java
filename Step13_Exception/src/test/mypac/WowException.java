package test.mypac;
//WowExcepption 을 발생시켜야 하는 시점에
//throw new WowExcepption("예외 메세지")
//RuntimeException 이 아니라 Exception 을 상속 받으면
//try-catch 반드시 사용해야 한다 
public class WowException extends RuntimeException {
	//생성자의 매개 변수로 예외 메세지를 전달 받아서
	public WowException(String msg) {
		//부모 생성자에 전달해준다
		super(msg);
	}
}
