import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private int R, C;
	private char[][] map;
	private boolean[][] isChecked;
	private int Answer = 0;
	
	private int[] dy = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(stt.nextToken());
		C = Integer.parseInt(stt.nextToken());
		map = new char[R][C];
		isChecked = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0 ; i < R; i++) {
			
			dfs(i,0);
		}
		
		System.out.println(Answer);
		
	}

	private boolean dfs(int y, int x) {
		if(x == C-1) {
			Answer++;
			isChecked[y][x] = true;
			return true;
		} 
		
		for(int i = 0; i < 3; i++) {
			int tmpy = y + dy[i];
			int tmpx = x + 1;
			if(tmpy >= 0 && tmpy < R && map[tmpy][tmpx] == '.' && !isChecked[tmpy][tmpx]) {
				isChecked[tmpy][tmpx] = true;
				if(dfs(tmpy, tmpx)) {
					return true;
				}
				//isChecked[tmpy][tmpx] = false;
			}
		}
		
		return false;
	}
}
