package test.main;

public class Mainclass02 {
	public static void main(String[] args) {
		// 0으로초기화된 방 3개짜리 int[] 개게를 반들어서 참조값을 지역변수 nums 에 담기
		int[] nums = {0, 0, 0};
		//0번 방에 10, 1번 방에 20, 2번 방에 30을 저장하기
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		//0으로 초기화된 방 500개 짜리 int[] 객체 만들어서 참조값 지역 변수 nums2에 담기
		int[] nums2 = new int [500];
		System.out.println(nums2.length);

		for(int i=0 ; i<nums2.length;i++) {
			nums[i] = i+1;
			System.out.println(nums2[i]);
		}
	}
}
