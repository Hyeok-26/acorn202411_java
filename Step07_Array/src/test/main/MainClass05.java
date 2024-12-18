package test.main;

import test.mypac.Bike;

public class MainClass05 {
	public static void main(String[] args) {
		//1.bike 객체를 담을 수 있는 방 3개짜리 배열 객체를 생성해서 참조값을
		//bikes 라는 지역 변수에 담기
		Bike[] bikes = new Bike[3];
		
		//2. 배열의 각각의 방에 Bike 객체를 생성해서 담기
		//배열의 방의 사이즈 만큼 반복문 돌기
		for(int i = 0; i<bikes.length; i++) {
			bikes[i] = new Bike();
			//bikes[i].ride();
		}
		//3. 반복문 for을 이용해서 순서대로 배열의 각각의 방에 있는 Bike객체의 ride()호출
		
		  for(int i = 0; i<bikes.length; i++){
		   //i번재 방에 있는 Bike 객체의 참조값 얻어오기
		   Bike tmp = bikes[i];
		   //tmp에 있는 Bike 객체의 .ride() 메소드 호출하기
		   tmp.ride();
		  }
		  System.out.println();
		  //오른 쪽의 배열의 참조값을  외쪽에 변수 순차적으로 넣는다
		  for(Bike tmp:bikes) {
			  tmp.ride();
		  }
	}
}
