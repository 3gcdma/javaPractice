import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1868 {
	private int N;
	private char[][] map;
	private boolean[][] isChecked;
	private int Answer;
	private int[] dy = {-1,-1,-1,0,0,1,1,1};
	private int[] dx = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution1868().start();
	}

	private void start() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			Answer = 0;
			map = new char[N][N];
			isChecked = new boolean[N][N];
			for(int i = 0 ; i < N; i++) {
				String tmp = br.readLine();
				for(int j = 0; j < N ; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}
			
			int count = 0;
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N ; j++) {
					if(map[i][j] == '.' && !isChecked[i][j]) {
						if(check(i,j)) {
							bfs(i, j);
							count++;
						}else {
							
						}
					}
				}
			}
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N ; j++) {
					if(isChecked[i][j]) map[i][j] = 'x';
				}
			}
			
//			for(int i = 0 ; i < N; i++) {
//				for(int j = 0; j < N ; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N ; j++) {
					if(map[i][j] == '.') count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}

	private void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		isChecked[y][x] = true;
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				
				if(ny < 0 || nx < 0 ||ny >= N || nx >= N) continue;
				if(!isChecked[ny][nx] && check(ny,nx)) q.offer(new int[] {ny, nx});
				isChecked[ny][nx] = true;
			}
		}
	}

	private boolean check(int y, int x) {
		for(int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 ||ny >=N || nx >= N) continue;
			if(map[ny][nx] == '*') return false;
		}
		return true;
	}

	
}
