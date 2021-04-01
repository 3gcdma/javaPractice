package day0401;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 리뷰
 * 첫번째 시도 : 성공
 *  어려웠던 이유 : 없었음. stack이라는 생각만 난다면 큰 문제 없이 풀 수 있음
 */


public class Solution1234 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		Stack<Integer> s;
		
		
		for(int t = 1; t <= 10; t++) {
			s = new Stack<>();
			
			stt = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stt.nextToken());
			String list = stt.nextToken();
			
			
			for(int i = 0; i < N ; i++) {
				int tmp = list.charAt(i) - 48;
				
				if(s.isEmpty() || tmp != s.peek()) {
					s.push(tmp);
				}else {
					s.pop();
				}
			}
			
			StringBuilder answer = new StringBuilder();
			while(!s.isEmpty()) {
				answer.insert(0, s.pop());
			}
			
			System.out.println("#" + t + " " + answer.toString());
		}
	}
}
