package test.mypac;

public class PostDto {
	//필드
	private int num;
	private String name;
	private String title;
	
	//디폴트 생성자
	public PostDto() {};
	
	public PostDto(int num, String name, String title) {
		this.num = num;
		this.name = name;
		this.title = title;
	}

	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
}
