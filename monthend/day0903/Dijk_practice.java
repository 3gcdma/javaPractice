import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijk_practice {
	private int N;
	private int[][] map;
	private int start;
	private int end;
	private int[] distance;
	private boolean[] isVisited;

	class Dijk implements Comparable<Dijk>{
		int no, totalDistance;

		public Dijk(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Dijk o) {
			return this.totalDistance - o.totalDistance;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		new Dijk_practice().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Dijk> pq = new PriorityQueue<Dijk>();
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		distance = new int[N];
		isVisited = new boolean[N];
		start = 0;
		
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pq.offer(new Dijk(start, distance[start]));
		
		Dijk current = null;
		while(!pq.isEmpty()) {
			
			current = pq.poll();
			if(isVisited[current.no]) {
				continue;
			}
			
			isVisited[current.no] = true;
			if(isAllChecked()) break;
			
			for(int i = 0; i < N; i++) {
				if(!isVisited[i] && map[current.no][i] != 0 && distance[i] > current.totalDistance + map[current.no][i]) {
					distance[i] = current.totalDistance + map[current.no][i];
					pq.offer(new Dijk(i, distance[i]));
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(distance[i] + " ");
		}
		System.out.println();
	}

	private boolean isAllChecked() {
		for(int i = 0; i < N; i++) {
			if(!isVisited[i]) return false;
		}
		
		return true;
	}
}
