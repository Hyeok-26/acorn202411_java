package test.mypac;

//상품 하나의 정보를 담을 객체를 생성할 클래스 정의
//java 에서는 공개된 필드를 잘 사용하지 않는다
public class Product {
	//외부에서 필드를 직접 참조하지 못하도록 접근 지정자를 private로 설정
	//product 객체 내부에서만 참조 가능
	private int id;
	private String name;
	private int price;
	//기본 생성자
	public Product() {}
	//매개변수 3개 선언된 생성자
	//필드에 저장할 값을 모두 전달 받는 생성자
	public Product(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
