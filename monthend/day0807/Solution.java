import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	private int Answer = 0;
	private int Max;
	private int N, M, Range;
	private int[][] map;
	private int[][] test;
	private boolean[][] isChecked;
	private boolean[][] isVisited;
	private int[] num = new int[3];
	private int[] dx = {-1, 0, 1};
	private int[] dy = {0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		Range = Integer.parseInt(stt.nextToken());
		Max = 0;
		
		map = new int[N][M];
		
		for(int i = 0; i <N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		choose(0, 0);
		
		System.out.println(Max);
	}

	private void choose(int cnt, int cur) {
		if(cnt == 3) {
			
			test = new int[N][];
			for(int i = 0; i < N; i++) {
				test[i] = map[i].clone();
			}
			
			System.out.println("[" + num[0] + ","+ num[1] + ","+ num[2] + "]");
			Answer = 0;
			while(check()) {
				shot();
				if (num[0] ==3 && num[1] ==6 &&num[2] ==9) print();
				move();
				if (num[0] ==3 && num[1] ==6 &&num[2] ==9) print();
			}
			System.out.println("[ Answer : " + Answer + "]");
			if(Answer > Max) Max = Answer;
			return;
		}
		
		for(int i = cur; i < M; i++) {
			num[cnt] = i;
			choose(cnt+1, i+1);
		}
	}

	private void move() {
		for(int i = N-1; i >= 0; i--) {
			for(int j = M-1; j >= 0; j--) {
				if(test[i][j] == 1) {
					if(i+1 < N) {
						//System.out.print(i+1);
						test[i+1][j] = 1;
						
					}
					test[i][j] = 0;
				}
			}
		}
	}

	private void shot() {
		isChecked = new boolean[N][M];
		
		for(int n = 0; n < 3; n++) {
			bfs(n);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(isChecked[i][j]) {
					Answer++;
					test[i][j] = 0;
				}
			}
		}
		
	}

	private void bfs(int n) {
		Queue<int[]> q = new LinkedList<int[]>();
		isVisited = new boolean[N][M];
		
		q.offer(new int[] {N,num[n]});
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int k = 0; k < size; k++) {
				int[] target = q.poll();
				
				for(int j = 0; j < 3; j++) {
					int tmpy = target[0];
					int tmpx = target[1];
					tmpy += dy[j];
					tmpx += dx[j];
					
					if(tmpx >= 0 && tmpy >= 0 && tmpx < M && tmpy < N && !isVisited[tmpy][tmpx] && (Math.abs(N - tmpy) + Math.abs(num[n] - tmpx) <= Range)) {
						if(test[tmpy][tmpx] == 1) {
							isChecked[tmpy][tmpx] = true;
							return;
						}else {
							q.offer(new int[] {tmpy, tmpx});
							isVisited[tmpy][tmpx] = true;
						}
					}
				}
			}
		}
	}

	private boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(test[i][j] == 1) return true;
			}
		}
		return false;
	}
	
	private void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(test[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
