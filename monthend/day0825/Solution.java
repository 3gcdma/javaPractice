import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	private int N, M, min = 9999999;
	private int[] peek;
	private List<int[]> house = new ArrayList<>(); 
	private List<int[]> chi = new ArrayList<>();;
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		peek = new int[M];
		
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(stt.nextToken());
				if(tmp == 1) {
					house.add(new int[] {i, j});
				}else if(tmp == 2) {
					chi.add(new int[] {i, j});
				}
			}
		}
		
		combination(0, 0);
		
		System.out.println(min);
		
		
	}

	private void combination(int cnt, int cur) {
		int cSize = chi.size();
		if(cnt == M) {
			chistreet();
			return;
		}
		for(int i = cur; i < cSize; i++) {
			peek[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}

	private void chistreet() {
		int minStreet = 0;
		int hSize = house.size();
		for(int i = 0; i < hSize; i++) {
			int comp = 9999999;
			int[] h =  house.get(i);
			
			for(int j = 0; j < M ; j++) {
				int[] c = chi.get(peek[j]);
				int ct = (Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
				if( comp > ct) {
					comp = ct;
				}
			}
			
			minStreet += comp;
		}
		if(minStreet < min) min = minStreet;
	}
}
