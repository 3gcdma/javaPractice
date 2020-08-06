import java.util.LinkedList;
import java.util.Queue;

public class Homework {
	private int N, R;
	private int[] input;
	private int[] num;
	private boolean[] ischecked;
	
	private void print() {
		for(int i = 0; i < R; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
	//순열
	private void permutation(int cnt) {
		if(cnt == R) {
			print();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(ischecked[i]) continue;
			num[cnt] = input[i];
			ischecked[i] = true;
			permutation(cnt+1);
			ischecked[i] = false;
		}
	}
	//중복순열
	private void permutation2(int cnt) {
		if(cnt == R) {
			print();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			num[cnt] = input[i];
			permutation2(cnt+1);
		}
	}
	//조합
	private void combination(int cnt, int cur) {
		if(cnt == R) {
			print();
			return;
		}
		
		for(int i = cur; i < N; i++) {
			num[cnt] = input[i];
			combination(cnt+1, cur+1);
		}
	}
	//중복조합
	private void combination2(int cnt, int cur) {
		if(cnt == R) {
			print();
			return;
		}
		
		for(int i = cur; i < N; i++) {
			num[cnt] = input[i];
			combination2(cnt+1, cur);
		}
	}
	//부분집합
	private void powerSet(int cnt) {
		if(cnt == N) {
			StringBuilder sb = new StringBuilder();
			sb.append("[ ");
			for(int i = 0; i < N-1; i++) {
				if(ischecked[i]) sb.append(input[i]);
				else sb.append(input[i]);
				
				if(i != N-1) sb.append(", ");
			}
			sb.append("]");
			System.out.println(sb.toString());
			return;
		}
		
		ischecked[cnt] = false;
		powerSet(cnt+1);
		ischecked[cnt] = false;
		powerSet(cnt+1);
	}
	
	
	private int W,H;
	private int[][] map;
	private boolean[][] checked;
	private int[] dx = {0,0,-1,1,-1,1,-1,1};
	private int[] dy = {-1,1,0,0,-1,-1,1,1};
	//DFS (or 재귀)
	private void DFS(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[nx][ny] == map[x][y] + 1) {
				DFS(nx, ny);
			}
		}
	}
	
	//BFS
	//배열버전
	private void BFS1(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {y, x});
		checked[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int tmpx = tmp[1] + dx[i];
				int tmpy = tmp[0] + dy[i];
				if(tmpx >=0 && tmpy >=0 && tmpx < W && tmpy < H && map[tmpy][tmpx] == 1 && (!checked[tmpy][tmpx])) {
					q.offer(new int[] {tmpy, tmpx});
					checked[tmpy][tmpx] = true;
				}
			}
		}
	}
	
}
