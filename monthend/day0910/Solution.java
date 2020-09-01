import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private int V, E;
	private int start;
	private ArrayList[] map;
	private int[] dis;
	private boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		V = Integer.parseInt(stt.nextToken());
		E = Integer.parseInt(stt.nextToken());
		start = Integer.parseInt(br.readLine());
		map = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			map[i] = new ArrayList<int[]>();
		}
		dis = new int[V+1];
		isVisited = new boolean[V+1];
		
		for(int i = 0; i < E; i++) {
			stt = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stt.nextToken());
			int to = Integer.parseInt(stt.nextToken());
			int distance = Integer.parseInt(stt.nextToken());
			
			map[from].add(new int[] {to, distance});
		}
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		
		
		int current = start;
		for(int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j = 1; j <= V; j++) {
				if(!isVisited[j] && min > dis[j]) {
					min = dis[j];
					current = j;
				}
			}
			
			isVisited[current] = true;
			
			for(int j = 0; j < map[current].size(); j++) {
				int[] tmp = (int[]) map[current].get(j);
				if(!isVisited[tmp[0]] && dis[tmp[0]] > min + tmp[1]) {
					dis[tmp[0]] = min + tmp[1];
				}
			}
			
		}
		print();
	}

	private void print() {
		for(int i = 1; i <= V; i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				System.out.println("INF" + " ");
				continue;
			}
			System.out.println(dis[i] + " ");
		}
	}	
}
