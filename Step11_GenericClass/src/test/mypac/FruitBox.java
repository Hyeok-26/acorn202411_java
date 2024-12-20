package test.mypac;

public class FruitBox<T> {
	//클래스 정의 시에 특정 type 은 전달 받아서 사용하는 주고로 정의할 수 있다
	//그러한 클래스를 Generic 클래스라고 한다.
	private T item;
	
	public void pack(T item) {
		this.item = item;
	}
	
	public T unpack() {
		return item;
	}
}
