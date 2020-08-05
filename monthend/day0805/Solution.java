import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private int N;
	private	int M;
	private int[] map;
	private int Answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().start();
	}

	
	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stt;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			stt = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stt.nextToken());   
			M = Integer.parseInt(stt.nextToken());
			Answer = N;
			
			map = new int[N+1];
			for(int i = 1; i <= N; i++) {
				map[i] = i;
			}
			for(int i = 0; i < M; i++) {
				stt = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(stt.nextToken());   
				int second = Integer.parseInt(stt.nextToken());
				
				union(first, second);
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
		
	}


	private void union(int first, int second) {
		int x = find_set(first);
		int y = find_set(second);
		if(x == y) return;
		
		map[y] = x;
		Answer--;
	}


	private int find_set(int first) {
		if(map[first] == first) return first;
		else {
			return map[first] = find_set(map[first]);
		}
	}

}
