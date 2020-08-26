import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	private int M, N;
	private int[][] map;
	private boolean[][] isChecked;
	private boolean[][] isCheckedone;
	private int Answer = -1;
	
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(stt.nextToken());
		N = Integer.parseInt(stt.nextToken());
		map = new int[M][N];
		isChecked = new boolean[M][N];
		isCheckedone = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		bfs(0, 0, 1);
		
		System.out.println(Answer);
		
	}

	private void bfs(int y, int x, int canBreak) {
		Queue<int[]> q = new LinkedList<>();
		int count = 1;
		
		q.offer(new int[] {y, x, canBreak});
		isChecked[y][x] = true;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] input = q.poll();
				
				//System.out.println(input[0] +" | "+ input[1] + " | " + input[2]);
				if(input[0] == M-1 && input[1] == N-1) {
					while(!q.isEmpty()) q.poll();
					Answer = count;
					break;
				}
				
				for(int j = 0; j < 4; j++) {
					int tmpy = input[0] + dy[j];
					int tmpx = input[1] + dx[j];
					
					
					if(tmpx >= 0 && tmpy >= 0 && tmpy < M && tmpx < N) {
						if(input[2] == 1) {
							if(!isCheckedone[tmpy][tmpx]) {
								if(map[tmpy][tmpx] == 1){
									q.offer(new int[] {tmpy, tmpx, 0});
									isCheckedone[tmpy][tmpx] = true;
								}else {
									q.offer(new int[] {tmpy, tmpx, input[2]});
									isCheckedone[tmpy][tmpx] = true;
								}
							}
						}else {
							if(!isChecked[tmpy][tmpx]) {
								if(map[tmpy][tmpx] != 1){
									q.offer(new int[] {tmpy, tmpx, input[2]});
									isChecked[tmpy][tmpx] = true;
								}
							}
							
						}
					}
				}
			}
			
			count++;
		}
		
		
	}
}