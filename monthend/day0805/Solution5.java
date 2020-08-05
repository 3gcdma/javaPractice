import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution5 {

	private int N, M;
	private int[] map;
	private int Answer;
	
	public static void main(String[] args) throws IOException {
		new Solution5().start();

	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		map = new int[N+1];
		Answer = N;
		
		for(int i = 1; i <= N; i++) {
			map[i] = i;
		}
		
		for(int i = 1; i <= M; i++) {
			stt = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(stt.nextToken());
			int s = Integer.parseInt(stt.nextToken());
			union(f, s);
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(!arr.contains(i)) {
				arr.add(i);
			}
		}
		
		System.out.println(Answer);
		System.out.println(arr.size());
	}

	private void union(int f, int s) {
		int x = find(f);
		int y = find(s);
		if(x == y) return;
		else {
			map[y] = x;
			Answer--;
		}
		
	}

	private int find(int f) {
		if(map[f] == f) return f;
		else {
			return map[f] = find(map[f]);
		}
	}
}
