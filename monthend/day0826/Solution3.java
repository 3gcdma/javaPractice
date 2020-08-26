import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	private int N;
	private int[][] map = new int[20][20];
	private boolean[][][] isChecked = new boolean[4][20][20];
	private int find = 0;
	private int targetx = 0;
	private int targety = 0;
	
	private int[] dx = {1,1,1,0};
	private int[] dy = {-1,0,1,1};
	

	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		for(int i = 0; i < 19; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		Lable:
		for(int j = 0; j < 19; j++) {
			for(int i = 0; i < 19; i++) {
				if(map[i][j] != 0) {
					if(find(i, j)) break Lable;
				}
			}
		}
		
		System.out.println(find);
		if(find != 0 ) {
			System.out.println( (targety + 1) + " " + (targetx + 1));
		}
		
	}

	private boolean find(int y, int x) {
		for(int i = 0; i < 4; i++) {
			if(isChecked[i][y][x] == true) continue;
			//System.out.println(y + " " + x + " "+ i);
			int tmpy = y + dy[i];
			int tmpx = x + dx[i];
			if(tmpy >= 0 && tmpx >= 0 && tmpy < 19 && tmpx < 19 && map[y][x] == map[tmpy][tmpx] && !isChecked[i][tmpy][tmpx]) {
				if(dfs(tmpy, tmpx, i) + 1 == 5){
					find = map[y][x];
					targety = y;
					targetx = x;
					return true;
				}
			}
		}
		return false;
	}

	private int dfs(int y, int x, int i) {
		int tmpy = y + dy[i];
		int tmpx = x + dx[i];
		isChecked[i][y][x] = true;
		
		if(tmpy >= 0 && tmpx >= 0 && tmpy < 19 && tmpx < 19 && map[tmpy][tmpx] == map[y][x]) {
			return dfs(tmpy, tmpx, i) + 1;
		}else {
			return 1;
		}
		
	}
}
