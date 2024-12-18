package test.main;

public class MainClassTest {

	public static int salGrade(int a,int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		String result = (a>b)?"a win":"b win";
		System.out.println(result);
		
		if(a>=10 && b<=20) {
			System.out.println("통과요~~");
		}else {
			System.out.println("나가리요~~");
		}
		for(int i=0;i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
		String names[] = new String[5];
		int[] num = new int[5];
		num[2] =10;
		names[2] = "노혁천";
		System.out.println(names[2]);
		System.out.println(num[2]);
		int nums[] = {1,22,3,5,6};
		for(int numbers:nums) {
			System.out.println(numbers);
		}
		System.out.println("배열의 길이: "+nums.length);
		
		
		int[][] count = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		System.out.println(count[2][2]);
		
		int sum = salGrade(10,20);
		System.out.println(sum);
		
	}	
	
	
}
