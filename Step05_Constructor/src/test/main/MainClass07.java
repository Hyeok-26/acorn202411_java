package test.main;

import test.mypac.Computer;
import test.mypac.Cpu;
import test.mypac.Memory;
import test.mypac.Ssd;

public class MainClass07 {
	public static void main(String[] args) {
		Computer com2 = new Computer(new Cpu(), new Memory(), new Ssd());
		
		Cpu c1 = new Cpu();
        Memory m1 = new Memory();
        Ssd s1 = new Ssd();;
		
		Computer com1 = new Computer(c1, m1, s1 );
		
	}
}
