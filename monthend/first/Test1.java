/**
 *  Math.abs(값1-값2)  // 값1과 값2의 절대값을 리턴해 줍니다.
 *
 */

public class Test1 {

	public static void main(String[] args) {

		int[]  su=  {77, 80, 60, 99, 100, 73, 85, 88, 95, 62};
		int avr = 0;
		int locate = 0;
		int diff = 0;
		
		for(int i = 0; i < su.length; i++) {
			avr += su[i];
		}
		avr = avr / su.length;
		
		for(int i = 0; i < su.length; i++) {
			if(diff < Math.abs(su[i] - avr)) {
				diff = Math.abs(su[i] - avr);
				locate = i;
			}
		}
		
		System.out.println(locate + " " + su[locate]);
		
		
		
		
		
		
		
		
	}
}
