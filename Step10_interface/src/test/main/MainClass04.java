package test.main;

import test.mypac.Drill;
//메소드가 혼자 존재할 수 없는 한계
public class MainClass04 {
	public static void main(String[] args) {
		//객체에 동작은 1개 포장되어 있다
		Drill d1 = new Drill() {
			@Override
			public void hole() {
				System.out.println("책상에 구멍을 뚫어요");
			}
		};
		useDrill(d1);
		//javascript 를 따라한 불쌍한 java...
		//메소드형식, 인터페이스 메소드가 무조건 1개일 때만 사용할 수 있는 형식
		//람다 표현식
		//나중에 실무에서 스트림 api와 자주 사용된다
		Drill d2 = ()->{
			System.out.println("의자에 구멍을 뚫어요!");
		};
		useDrill(d2);
		useDrill(()->{
			System.out.println("지역 변수에 담지 않고 스스로 참조시켜욘");
		});
	}
	//해당 객체를 메소드를 호출하면서 전달한다
	public static void useDrill(Drill d) {
		//메소드 안에서는 객체에 포장된 1개의 동작을 사용한다
		d.hole();
		d.hole();
	}
}
