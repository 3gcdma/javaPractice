import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	private int N, M;
	private int[][] map;
	private boolean[][] isChecked;
	private int ilend;
	private PriorityQueue<Brige> list;
	private int[] parents;
	private int Answer;
	
	private int[] dy = {-1,1,0,0};
	private int[] dx = {0,0,-1,1};
	
	
	class Brige implements Comparable<Brige>{
		int from, to, distance;

		public Brige(int from, int to, int distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Brige o) {
			if(this.distance == o.distance) return this.from - o.from;
			return this.distance - o.distance;
		}


	}
	
	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		map = new int[N][M];
		isChecked = new boolean[N][M];
		ilend = 1;
		list = new PriorityQueue<Brige>();
		Answer = 0;
		
		
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					ilend++;
					bfs(i, j);
				}
			}
		}
		
		//
		//print();
		///
		parents = new int[ilend+1];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 1) {
					makeset(i, j);
				}
			}
		}
		
		for(int i = 2; i < (ilend+1) ; i++) {
			parents[i] = i;
		} 
		
		
//		while(!list.isEmpty()){
//			Brige b = list.poll();
//			
//		}
		
		

		while(!list.isEmpty()) {
			if(isAll()) break;
			Brige b = list.poll();
			//System.out.println(b.from + " " + b.to + " " + b.distance);
			if(!union(b.from, b.to)) {
				continue;
			}
			
			Answer += b.distance;
		}
		
		if(!isAll()) {
			Answer = -1;
		} 

		System.out.println(Answer);
//		
	}

	private boolean isAll() {
		
		for(int i = 2; i <= ilend; i++) {
			findset(i);
			//System.out.print(parents[i]);
		}
		//System.out.println();
		
		for(int i = 2; i < ilend; i++) {
			
			if(parents[i] != parents[i+1]) {
				return false;
			}
		}

		return true;
	}

	private boolean union(int from, int to) {
		int f = findset(from);
		int t = findset(to);
		//System.out.println(f + " | " + t);
		if(f == t) return false;
		
		parents[t] = f;
		return true;
	}

	private int findset(int to) {
		if(parents[to] == to) return to;
		else return parents[to] = findset(parents[to]);
	}

	private void makeset(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y;
			int nx = x;
			int count = 0;
			while(true) {
				ny += dy[i];
				nx += dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == map[y][x]) {
					break;
				}
				
				if( map[ny][nx] != 0 && map[ny][nx] != map[y][x]) {
					//System.out.println(y + " " + x + " " + ny + " " + nx + " " + count);
					if(count > 1 && map[ny][nx] > map[y][x]) {
						//System.out.println(y + " " + x + " " + ny + " " + nx + " " + count);
						list.offer(new Brige( map[y][x], map[ny][nx], count));
					}
					break;
				}
				count++;
			}
		}
	}

	private void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {y,x});

		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			map[tmp[0]][tmp[1]] = ilend;
			for(int i = 0; i < 4; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				
				if(ny >= 0 && nx >=0 && ny <N && nx < M && map[ny][nx] == 1) {
					q.offer(new int[] {ny, nx});
				}
			}
		}
	}
}
