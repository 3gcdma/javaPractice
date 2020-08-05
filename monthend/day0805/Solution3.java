import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution3 {
	
	private int[][] map;
	private int N, M;
	private int day;
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stt.nextToken());
		N = Integer.parseInt(stt.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		bfs();
		if(!checked()) {
			day = 0;
		}
		
		System.out.println(day - 1);
	}

	private boolean checked() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		day = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();

			for(int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				int tmpx;
				int tmpy;
				for(int j = 0; j < 4; j++) {
					tmpx = tmp[1] + dx[j];
					tmpy = tmp[0] + dy[j];
					if(tmpx >=0 && tmpy >= 0 && tmpy < N && tmpx < M && map[tmpy][tmpx] == 0) {
						map[tmpy][tmpx] = 1;
						q.offer(new int[] {tmpy, tmpx});
					}
				}
			}
			day++;
			
		}
		
		
	}
}
