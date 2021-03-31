import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 리뷰 
 * 첫번째 시도 : 성공
 *  어려웠던 이유 - 주의깊게 읽지 않은 문제(설계 오류), 익숙하지 않은 방식 사용(시간 조금 줄인다고 일일히 작성), 입력범위 오류(-로 끝날수도 있엇음)
 */

public class JO1620 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		String tel = stt.nextToken(); // 전화번호 
		int num = Integer.parseInt(stt.nextToken()); //각 자리수에 더할 수
		int target = Integer.parseInt(stt.nextToken()); // 몇 번째 전화번호
		
		int count = 1;
		int calc = Integer.MIN_VALUE;
		
		//token 분리 전 정제 작업 필요
		if(tel.charAt(tel.length()-1) == '-') {
			tel += '0';
		}
		
		//token 분리 작업
		stt = new StringTokenizer(tel, "-");
		while(stt.hasMoreElements()) {
			int tmp = Integer.parseInt(stt.nextToken());
			
			//입력이 10000을 넘으면 에러 바로 출력후 종료
			if(tmp >= 10000) {
				System.out.println("INPUT ERROR!");
				return;
			}
			
			//지정 위치의 전화번호 가져옴
			if(count == target) {
				calc = tmp;
			}
			
			count++;

		}
		
		//아무것도 못 가져왔으면 범위를 벗어난것임으로 입력 오류
		if(calc == Integer.MIN_VALUE) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int answer = 0;
		//암호 계산 (for문으로 할껄...)
		answer += ((calc % 10) + num) %10;
		calc /= 10;
		answer += (((calc % 10) + num) %10) *10;
		calc /= 10;
		answer += (((calc % 10) + num) %10) *100;
		answer += (((calc / 10) + num) %10) *1000;
		
		System.out.println(answer);
	}

}
