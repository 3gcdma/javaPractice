
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2239 {
	private int N = 9;
	private int[][] map;
	public static void main(String[] args) throws IOException {
		new Solution2239().start();
		
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		dfs(0);
		
		print();
		
	}
	
	private boolean dfs(int num) {
		int y = num/9;
		int x = num%9;
		if(y == 9) {
			return true;
		}
		
		if(map[y][x] != 0) return dfs(num+1);
		
		for(int i = 1; i <= N; i++) {
			if(input(y,x,i)) {
				map[y][x] = i;
				if(dfs(num+1)) return true;
				map[y][x] = 0;
			}
		}
		
		return false;
	}

	private void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private boolean input(int y, int x, int target) {
		for(int j = 0; j < N; j++) {
			if(map[y][j] == target) return false;
		}
		
		for(int j = 0; j < N; j++) {
			if(map[j][x] == target) return false;
		}
		
		int ny = (y/3 +1) *3;
		int nx = (x/3 +1) *3;
		for(int j = ny-3; j < ny; j++) {
			for(int k = nx-3; k < nx; k++) {
				if(map[j][k] == target) return false;
			}
		}
		
		return true;
	}

}
