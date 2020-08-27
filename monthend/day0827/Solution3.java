import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	
	private int R, C;
	private char[][] map;
	private boolean[] isVisited = new boolean[30];
	private int max = 0;
	
	private int[] dx = {0, 0, -1, 1};
	private int[] dy = {-1, 1, 0, 0};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution3().start();
	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(stt.nextToken());
		C = Integer.parseInt(stt.nextToken());
		map = new char[R][];
		
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		isVisited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
		
	}

	private void dfs(int y, int x, int count) {
		if(count > max) max = count;
		//System.out.println(y + " " + x);
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx >= 0 && ny >= 0 && ny < R && nx < C ) {
				int target = map[ny][nx] - 'A';
				if(!isVisited[target]) {
					isVisited[target] = true;
					dfs(ny, nx, count+1);
					isVisited[target] = false;
				}
			}
		}
		
	}
}
