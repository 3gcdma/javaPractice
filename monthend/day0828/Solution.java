import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.crypto.KeySelector.Purpose;

public class Solution {
	private int N;
	private int[] gram;
	private int[] num;
	private boolean[] isChecked;
	private int Answer;
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			gram = new int[N];
			isChecked = new boolean[N];
			
			stt = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				gram[i] = Integer.parseInt(stt.nextToken());
			}
			
			permutation(0);
			System.out.println("#"+test_case + " " +Answer);
		}
	}

	private void permutation(int cnt) {
		if(cnt == N) {
			powerset(0, 0, 0);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isChecked[i]) continue;
			isChecked[i] = true;
			num[cnt] = i;
			permutation(cnt+1);
			isChecked[i] = false;
		}
	}

	private void powerset(int cnt, int left, int right) {
		
		if(cnt == N) {
			//System.out.println(left + " " + right);
			Answer++;
			return;
		}
		int move = gram[ num[cnt] ];
		
		powerset(cnt+1, left+move, right);
		
		if(left >= (right + move))
			powerset(cnt+1, left, (right + move));
	}
}
