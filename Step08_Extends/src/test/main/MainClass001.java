package test.main;

import test.auto2.MyCar;
import test.auto.Engine;
import test.mypac.AndroidPhone;
import test.mypac.HandPhone;
import test.mypac.IosPhone;
import test.mypac.Phone;

public class MainClass001 {
	public static void main(String[] args) {
		Phone p = new Phone();
		Phone p1 = new HandPhone();
		Object o = new Phone();
		HandPhone ip1 = (HandPhone)p1;
		
		Engine e = new Engine();
		MyCar car1 = new MyCar(new Engine());
		car1.drive();
		car1.myDrive();
		
	}
	
	
}
