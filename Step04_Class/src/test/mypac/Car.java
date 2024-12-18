package test.mypac;
/*
 *  class의 역할
 *  
 *  1.객체의 설계도 역할
 *   - 객체는 heap 영역(사물함) 에 들어 있는 물건이라고 생각하면 된다
 *   - class 를 이용해서 객체를 원하는 시점에 원하는 갯수만큼 만들어 낼 수 있다.
 *   - 만들어진 객체는 어떤 저장소의 어떤 기능을 가지게 할지 class 로 성계할 수 있다.
 *
 *  2.data type 역할
 * 
 *  3.static 필드와  메소드를 포함하는 역할
 **/
public class Car {
	//데이터의 저장소(field)
	public String name;//선언만 하고 값을 넣지 않으면 객체 생성시 null 로 초기화된다.
	public int price;//선언만 하고 값을 넣지 않으면 객체 생성 시 0 으로 초기화 된다.
	//논리 데이터의 기본 값 false
	
	//기능(method)
	public void drive() {
		System.out.println(this.name+ " 이(가) 달려요!");
		Car a = this;//바로 이클래스로 생성된 객체의 참조값
	}
	
	 
}
