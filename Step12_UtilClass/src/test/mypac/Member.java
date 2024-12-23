package test.mypac;

public class Member {
	//필드
	public int num;
	public String name;
	public String addr;
	
	//디폴트 생성자
	public Member() {}
	
	//필드에 저장할 값을 한번에 전달 받는 생성자
	public Member(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
}
