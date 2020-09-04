import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private int N;
	private int[][] map;
	private int[] locate;
	private int Ssize;
	private int SsizeCount;
	private int time;
	
	private int[] dy = {-1,0,0,1};
	private int[] dx = {0,-1,1,0};
	
	class Fish implements Comparable<Fish>{
		int y, x;

		public Fish(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.y == o.y) return this.x - o.x;
			return this.y - o.y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		locate = new int[2];
		Ssize = 2;
		SsizeCount = Ssize;
		time = 0;
		
		for(int i = 0; i < N ;i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
				if(map[i][j] == 9) {
					locate[0] = i;
					locate[1] = j;
				}
			}
		}
		
		while(true) {
			//System.out.println(time);
			//print();
			if(!bfs()) break;
		}
		System.out.println(time);
		
	}

	private void print() {
		for(int i = 0; i < N ;i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private boolean bfs() {
		//Queue<int[]> q = new LinkedList<>();
		PriorityQueue<Fish> q = new PriorityQueue<Fish>();
		boolean[][] isChecked = new boolean[N][N];
		
		q.offer(new Fish(locate[0], locate[1]));
		isChecked[locate[0]][locate[1]] = true;
		
		int t = 0;
		while(!q.isEmpty()) {
			int Nsize = q.size();
			PriorityQueue<Fish> list = new PriorityQueue<Fish>();
			for(int n = 0; n < Nsize; n++) {
				Fish tmp = q.poll();
				
				if(map[tmp.y][tmp.x] > 0 && map[tmp.y][tmp.x] < Ssize) {
					map[tmp.y][tmp.x] = map[locate[0]][locate[1]];
					map[locate[0]][locate[1]] = 0;

					
					locate[0] = tmp.y;
					locate[1] = tmp.x;
					
					SsizeCount--;
					
					if(SsizeCount == 0) {
						Ssize++;
						SsizeCount = Ssize;
					}
					
					time += t;
					return true;
				}
				
				
				for(int i = 0; i < 4; i++) {
					int ny = tmp.y + dy[i];
					int nx = tmp.x + dx[i];
					if(ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] <= Ssize && !isChecked[ny][nx]) {
						isChecked[ny][nx] = true;
						list.offer(new Fish(ny, nx));
					}
				}
			}
			t++;
			q = list;
		}
		return false;
	}
}
