import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private int N;
	private int[][] map;
	private int start;
	private int end;
	private int[] distance;
	private boolean[] isVisited;
	private int Answer;
	
	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		distance = new int[N];
		isVisited = new boolean[N];
		start = 0;
		Answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		isVisited[start] = true;
		dfs(1, start, 0);
		
		System.out.println(Answer);
	}

	private void dfs(int cnt, int target, int size) {
		if(cnt == N) {
			if( map[target][start] != 0 && Answer > size + map[target][start]) {
				Answer = size + map[target][start];
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(i == target) continue;
			
			if(!isVisited[i] && map[target][i] != 0 &&Answer > size + map[target][i]) {
				isVisited[i] = true;
				dfs(cnt+1, i, size + map[target][i]);
				isVisited[i] = false;
			}
		}
	}
}
