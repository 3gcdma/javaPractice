import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	private int T, N, M, K;
	private int[][] map;
	private boolean[][] isChecked;
	private int Answer;
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution2().start();
	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			stt = new StringTokenizer(br.readLine());
			M = Integer.parseInt(stt.nextToken());
			N = Integer.parseInt(stt.nextToken());
			K = Integer.parseInt(stt.nextToken());
			map = new int[N][M];
			isChecked = new boolean[N][M];
			Answer = 0;
			
			
			for(int i = 0; i < K; i++) {
				stt = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stt.nextToken());
				int y = Integer.parseInt(stt.nextToken());
				map[y][x] = 1;
			}
			for(int i = 0; i < N;i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !isChecked[i][j]) {
						Answer++;
						bfs(i, j);
					}
				}
			}
			
			System.out.println(Answer);
		}
		
		
		
	}

	private void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {y, x});
		isChecked[y][x] = true;
		
		
		while(!q.isEmpty()) {
			int[] locate = q.poll();
			for(int i = 0; i < 4; i++) {
				int tmpy = locate[0] + dx[i];
				int tmpx = locate[1] + dy[i];
				if(tmpy >=0 && tmpx >=0 && tmpy < N && tmpx < M && map[tmpy][tmpx] == 1 && !isChecked[tmpy][tmpx]) {
					q.offer(new int[] {tmpy, tmpx});
					isChecked[tmpy][tmpx] = true;
				}
			}
		}
		
	}
}
