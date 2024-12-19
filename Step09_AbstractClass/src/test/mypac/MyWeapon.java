package test.mypac;

public class MyWeapon extends Weapon {
	//미리 만들어져 있는 Weapon 클래스를 통해 특별한 기능을 상속받아
	@Override
	//우리의 프로젝트상황에 맞게 구현한다.
	public void attack() {
		//어디를 공격할지는 프로젝트 상황에 맞게 마음대로 공격하면 된다.
		System.out.println("다 때려부숴!!!!!");
		
	}
	//그러면 우리가 만든 클래스로 생성된 객체가 아주 특별한 기능을 수행 할 수 있다
	//추상 메소드에서 자재를 전달하고 자재를 입맛에 맞게 가공한다 
}
