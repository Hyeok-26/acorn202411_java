package test.mypac;

public class Member {
	
	public int num;
	public String name;
	public String addr;
	
	//기본생성자
	public Member() {
		
	}
	//return type 명시가 안됨 = > method 아님
	//값을 3개 전달 받은 생성자(Constructor)
	
	public Member(int num,String name,String addr) {
		//매개 변수에 전달된 값을 필드에 저장
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	//필드에 저장된 정보를 콘솔창에 풀력하는 메소드
	public void showInfo() {
		//필드에 저장된 정보를 1줄로 이쁘게 콘솔창에 출력하는 코드 작성
		System.out.println("번호: "+this.num+" 이름: "+this.name+" 주소: "+addr);
	}
	//매개변수에 전달된 번호를 필드에 저장하고 자신의 참조값을 리턴하는 메소드
	public Member num(int num) {
		this.num = num;
		return this;
	}
	//매개변수에 전달된 이름을 필드에 저장하고 자신의 참조값을 리턴하는 메소드
	public Member name(String name) {
		this.name = name;
		return this;
	}
	//매개변수에 전달된 이름을 필드에 저장하고 자신의 참조값을 리턴하는 메소드
	public Member addr(String addr) {
		this.addr = addr;
		return this;
	}

}
