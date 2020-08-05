import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4 {
	private int Answer;
	private int H, W;
	private int[][] map;
	private boolean[][] isChecked;
	private int[] dx = {0,0,-1,1,-1,1,-1,1};
	private int[] dy = {-1,1,0,0,-1,-1,1,1};	
	
	public static void main(String[] args) throws IOException {
		new Solution4().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		while(true) {
			stt = new StringTokenizer(br.readLine());
			W = Integer.parseInt(stt.nextToken());
			H = Integer.parseInt(stt.nextToken());
			Answer = 0;
			
			if(W == 0 && H == 0) break;
			
			map = new int[H][W];
			isChecked = new boolean[H][W];
			
			for(int i = 0; i < H; i++) {
				stt = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(stt.nextToken());
				}
			}
			
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == 1 && (!isChecked[i][j])) {
						BFS(i, j);
					}
				}
			}
			
			System.out.println(Answer);
		}
		
		
	}

	private void BFS(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] tmp;
		int tmpx;
		int tmpy;

		q.offer(new int[] {y,x});
		isChecked[y][x] = true;
		while(!q.isEmpty()) {
			tmp = q.poll();
			
			
			for(int i = 0; i < 8; i++) {
				tmpx = tmp[1] + dx[i];
				tmpy = tmp[0] + dy[i];
				if(tmpx >=0 && tmpy >=0 && tmpx < W && tmpy < H && map[tmpy][tmpx] == 1 && (!isChecked[tmpy][tmpx])) {
					q.offer(new int[] {tmpy, tmpx});
					isChecked[tmpy][tmpx] = true;
				}
			}
		}
		
		Answer++;
	}
}
