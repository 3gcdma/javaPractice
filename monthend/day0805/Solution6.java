import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution6 {
	
	private int[][] map;
	private int N;
	private boolean[][] checked;
	private int cnt;
	Stack<Integer> Answer = new Stack<Integer>();
	private int total;
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		new Solution6().start();
	}
	
	
	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checked = new boolean[N][N];
		total = 0;
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && (!checked[i][j])) {
					//BFS(i, j);
					
					cnt = 0;
					checked[i][j] = true;
					cnt++;
					DFS(i, j);
					Answer.push(cnt);

					
					total++;
				} 
			}
		}
		
		int[] s = new int[Answer.size()];
		for(int i = 0; i < s.length; i++) {
			s[i] = Answer.pop();
		}
		
		
		Arrays.sort(s);
		
		System.out.println(total);
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		
	}

	private void BFS(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		int count = 0;
		
		q.offer(new int[] {y, x});
		checked[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			count++;
			int tmpx;
			int tmpy;
			for(int i = 0; i < 4; i++) {
				tmpy = tmp[0] + dy[i];
				tmpx = tmp[1] + dx[i];
				if(tmpy >= 0 && tmpx >= 0 && tmpy < N && tmpx < N && map[tmpy][tmpx] == 1 && (!checked[tmpy][tmpx])) {
					q.offer(new int[] {tmpy, tmpx});
					checked[tmpy][tmpx] = true;
				}
			}
		}
		
		Answer.push(count);
	}
	
	private void DFS(int y, int x) {
		int tmpx;
		int tmpy;
		for(int i = 0; i < 4; i++) {
			tmpy = y + dy[i];
			tmpx = x + dx[i];
			if(tmpy >= 0 && tmpx >= 0 && tmpy < N && tmpx < N && map[tmpy][tmpx] == 1 && (!checked[tmpy][tmpx])) {
				checked[tmpy][tmpx] = true;
				cnt++;
				DFS(tmpy, tmpx);

			}
		}
	}
	
	
}
