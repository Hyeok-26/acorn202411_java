package test.dto;

public class MemberDto {
	//필드
	private int num;
	private String name;
	private String addr;
	//디폴트 생성자
	public MemberDto() {}
	//dto 복습
	//의무는 아닌 생성자에 필드를 참조해 매개변수를 넣는 dto
	public MemberDto(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	//setter, getter 메소드
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}	
