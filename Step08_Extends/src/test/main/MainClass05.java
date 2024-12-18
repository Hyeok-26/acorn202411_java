package test.main;

import test.mypac.AndroidPhone;
import test.mypac.HandPhone;
import test.mypac.IosPhone;

public class MainClass05 {
	public static void main(String[] args) {
		//AndroidPhone 객체를 생성해서 참조값을 AndroidPhone type p1 이라는 지역변수에 담기
		AndroidPhone p1 = new AndroidPhone();
		//상속을 받으면 부모 객체 먼저 생성됨
		p1.call();
		p1.mobileCall();
		p1.takePicture();
		p1.doInternet();
		
		System.out.println("--------");
		//AndroidPhone 객체를 생성해서 참조값을 HandPhone type p2 라는 지역변수에 담기
		HandPhone p2 = new AndroidPhone();
		p2.takePicture();//@Override 된 메소드 호출
		
		System.out.println("---------");
		HandPhone p3 = new HandPhone();
		p3.takePicture();//HandPhone 객체 메소드 호출
		
		System.out.println("---------");
		IosPhone iphone = new IosPhone();
		HandPhone hp = iphone;
		hp.takePicture();
		iphone.appleWatch();
		
		
		
		
	}
}
