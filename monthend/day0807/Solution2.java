import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	private int N;
	private int Max;
	private int Count;
	private int Answer = 0;
	private int[][] map;
	private boolean[][] isChecked;
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution2().start();
	}
	
	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Max = 0;
		
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
				if(Max < map[i][j]) Max = map[i][j];
			}
		}
		
		for(int m = 0; m < Max; m++) {
			isChecked = new boolean[N][N];
			Count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > m && !isChecked[i][j]) {
						Count++;
						bfs(i, j ,m);
					}
				}
			}
			
			if(Count > Answer) Answer = Count;
		}
		
		System.out.println(Answer);
	}

	private void bfs(int y, int x, int hight) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {y, x});
		isChecked[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int tmpy = tmp[0] + dy[i];
				int tmpx = tmp[1] + dx[i];
				
				if(tmpy >= 0 && tmpx >= 0 && tmpy <N && tmpx < N && map[tmpy][tmpx] > hight && !isChecked[tmpy][tmpx]) {
					q.offer(new int[] {tmpy, tmpx});
					isChecked[tmpy][tmpx] = true;
				}
			}
		}
		
		
	}

}
