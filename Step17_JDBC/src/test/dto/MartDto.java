package test.dto;

public class MartDto {
	private int code;
	private String name;
	private int price;
	private String loc;
	
	public MartDto() {}

	public MartDto(int code, String name, int price, String loc) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.loc = loc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
