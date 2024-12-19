package test.mypac;

public class MyArrow extends MyWeapon {
	public void Arrow(){
		System.out.println("화살이 필요해!");
	}
	@Override
	public void attack() {
		System.out.println("화살로 쏴버려잇!!!");
	}
	
}
