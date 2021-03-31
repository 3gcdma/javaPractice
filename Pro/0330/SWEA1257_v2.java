import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 리뷰 
 * 첫번째 시도 : 실패
 *  이유 : LCP 개념 처음 접함, cnt에서 너무 많이 헤매었음
 *  
 */


public class SWEA1257_v2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for(int t = 1; t <= T ; t++) {

			int K = Integer.parseInt(br.readLine()); /// 찾고싶은 부분 문자 위치
			String str = br.readLine(); //문자열
			
			int len = str.length(); // 문자열 총 길이
			
			String[] sf = new String[len]; //사전 배열할 큰 부분집합
			
			int[] lcp = new int[len]; //LCP 배열
			int[] cnt = new int[len]; //count 배열
			
			for(int i = 0; i < len; i++) {
				sf[i] = str.substring(i); // 부분집합화
			}
			
			Arrays.sort(sf);// 사전순 정렬
			
			for(int i = 1; i < len; i++) {
				lcp[i] = getLCP(sf[i], sf[i-1]); // lcp 가져오기
			}
			
			cnt[0] = sf[0].length(); //각 부분문자열별 총 갯수 초기화
			
			for(int i = 1; i < len; i++) {// 갯수 세기
				cnt[i] = sf[i].length() - lcp[i] + cnt[i-1];
			}
			
			if(K > cnt[len-1]) { // 찾고자 하는 위치가 총 갯수보다 많은면 none 리턴
				System.out.println("#" + t + " " + "none");
			}else {
				int i;
				
				//어느 위치에 존재하는 지 찾기
				for(i = 0; i < len; i++) {
					if(K <= cnt[i]) break;
				}
				
				int end = -1;
				
				// 정확한 end 위치 찾기
				if(i == 0) {
					end = K;
				}else {
					end = K - cnt[i-1] + lcp[i];
					
				}
			
				System.out.println("#" + t + " " + sf[i].substring(0,end));
			}
		}

	}

	private static int getLCP(String s1, String s2) { //lcp 가져오기
		int len = s1.length() > s2.length() ? s2.length() : s1.length(); // 두 문자열중 짧은 문자열의 길이 받아오기
		int i;
		for(i = 0; i < len; i++) { // 앞에서부터 하나씩 비교하면서 같은 부분 문자열 반환
			if(s1.charAt(i) != s2.charAt(i)) {
				break;
			}
		}
		return i;// 찾은 부분 문자열 길이 반환
	}
}
