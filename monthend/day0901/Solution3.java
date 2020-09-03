import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	private int N, M;
	private char[] st;
	private char[] target;
	private int[] ti;
	private int Answer;
	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = br.readLine().toCharArray();
		target = br.readLine().toCharArray();
		M = st.length;
		N = target.length;
		ti = new int[N];
		Answer = 0;
		
		int j = 0;
		for(int i = 1; i < N; i++) {
			while(j > 0 && target[i] != target[j]) {
				j = ti[j-1];
			}
			
			if(target[i] == target[j]) {
				ti[i] = ++j;
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.print(ti[i]);
//		}
//		System.out.println();
		
		j = 0;
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			while(j > 0 && st[i] != target[j]) {
				j = ti[j-1];
			}
			if(st[i] == target[j]) {
				if(j == N-1) {
					Answer++;
					list.add(i - j + 1);
					j = ti[j];
				}else {
					j++;
				}
			}
		}
		System.out.println(Answer);
		for(int i = 0; i < Answer; i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
}
