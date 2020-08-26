import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private int N, M, T;
	private int[][] map;
	private int[][] map_copy;
	private boolean[] isChecked;
	private int[] cases;
	private int Answer = 99999999;
	
	List<int[]> list = new ArrayList<>();
	private int[] dx = {1,0,-1,0};
	private int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		T = Integer.parseInt(stt.nextToken());
		map = new int[N+1][M+1];
		cases = new int[T];
		isChecked = new boolean[T];
		
		for(int i = 1; i <= N; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		for(int i = 0; i < T; i++) {
			int[] tmp = new int[3];
			stt = new StringTokenizer(br.readLine());

			tmp[0] = Integer.parseInt(stt.nextToken());
			tmp[1] = Integer.parseInt(stt.nextToken());
			tmp[2] = Integer.parseInt(stt.nextToken());
			list.add(tmp);
		}
		
		purmutation(0);
		
		
		System.out.println(Answer);
	}

	private void purmutation(int cnt) {
		if(cnt == T) {
			map_copy = new int[N+1][];
			for(int i = 1 ;i <= N; i++) {
				map_copy[i] = map[i].clone();
			}
			
			compare();
			return;
		}
		
		for(int i = 0; i < T; i++) {
			if(isChecked[i]) continue;
			isChecked[i] = true;
			cases[cnt] = i;
			purmutation(cnt+1);
			isChecked[i] = false;
		}
		
	}

	private void compare() {
		int min = 99999999;
		for(int i = 0; i < T; i++) {
			//System.out.println("case :" + i);
			//print();
			round(i, 1);
			//print();
		}
		
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = 1; j <=M; j++) {
				sum += map_copy[i][j];
			}
			if(min > sum) min = sum;
		}
		//System.out.println(min);
		if(Answer > min) Answer = min;
	}

	private void print() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				System.out.print(map_copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void round(int cnt, int size) {
		int[] target = list.get(cases[cnt]);
		
		if(size > target[2]) {
			return;
		}
		
		int x = target[1] - size;
		int y = target[0] - size;
		int range = size * 2;
		int t = map_copy[y+1][x];
		
		if( x < 1 || y < 1 || x + range > M || y + range > N) return;
		
		round(cnt, size+1);
		
		for(int i = x; i < x + range; i++) {
			int tmp = map_copy[y][i];
			map_copy[y][i] = t;
			t = tmp;
		}
		
		for(int i = y; i < y + range; i++) {
			int tmp = map_copy[i][x+range];
			map_copy[i][x+range] = t;
			t = tmp;
		}
		
		for(int i = x+range; i > x; i--) {
			int tmp = map_copy[y+range][i];
			map_copy[y+range][i] = t;
			t = tmp;
		}
		
		for(int i = y+range; i > y; i--) {
			int tmp = map_copy[i][x];
			map_copy[i][x] = t;
			t = tmp;
		}
		
	}
}
