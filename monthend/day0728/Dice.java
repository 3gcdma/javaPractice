import java.util.Arrays;
import java.util.Scanner;


public class Dice {
	
	private static int N, totalCount;
	private static int[] numbers;
	private static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[7];
		
		
		int mode = sc.nextInt();
		totalCount = 0;
		switch(mode) {
			case 1:	
				dice1(0);
				break;
			case 2:	
				dice2(0);
				break;
			case 3:	
				dice3(0, 1);
				break;
			case 4:	
				dice4(0, 1);
				break;
		}
		System.out.println("총 경우의 수 : "  + totalCount);
		
	}
	
	//중복순열
	private static void dice1(int cnt) {
		
		if(cnt == N) {
			++totalCount;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i <=6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
		
	}
	
	//순열
	private static void dice2(int cnt) {
		
		if(cnt == N) {
			++totalCount;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i <=6; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	//중복 조합
	private static void dice3(int cnt, int cur) {
		
		if(cnt == N) {
			++totalCount;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = cur; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	
	//조합
	private static void dice4(int cnt, int cur) {
		
		if(cnt == N) {
			++totalCount;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = cur; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
}
	