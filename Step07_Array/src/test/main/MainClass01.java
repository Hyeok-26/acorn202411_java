package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		//변수 안에는 참조 data 값이 들어있다
		//int type 5개를 저장하고 잇는 배열 객체 생성해서 참조값을 nums라는 지역변수에 담기
		int[] nums = {10, 20, 30, 40, 50};
		//double type 5개를 저장하고 있는 배열 객체를 생성해서 참조값을 nums2 라는 지역 변수에 담기
		double[] nums2 = {10.1, 10.2, 10.3, 10.4, 10.5};
		//boolean type 5개를 저장하고 있는 배열
		boolean[] truth = {true, true, false, false, true};
		//String type(참조 데이터 type) 5개를 저장하고 있는 배열
		String[] names = {"김구라","해골","원숭이","주영이","덩어리"};
		System.out.println(nums[2]);
		System.out.println(nums2[4]);
		System.out.println(truth[1]);
		System.out.println(names[3]);
		//배열 객체의 복제본 얻어내기
		int[] reusult = nums.clone();
		//복제본이 아닌 참조값만 복사
		int[] result2 = nums;
		//배열은 순서가 있는 데이터이다.특정index 의 item 참조하는 방법
		int first = nums[0];
		int second = nums[1];
		int third = nums[2];
	}
}
