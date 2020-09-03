import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private int R, C, T;
	private int[][] map;
	
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		R = Integer.parseInt(stt.nextToken());
		C = Integer.parseInt(stt.nextToken());
		T = Integer.parseInt(stt.nextToken());
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		curculate();
		Answer();
	}

	private void Answer() {
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	private void curculate() {
		for(int i = 0; i < T; i++) {
			//print();
			dust();
			//print();
			aircleaner();
			//print();
		}
	}

	private void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void aircleaner() {
		int y = 0;
		for(int i = 0; i < R; i++) {
			if(map[i][0] == -1) {
				y = i;
				break;
			}
		}
		
		
		int carry = 0;
		for(int i = 1 ; i < C-1; i++) {
			int tmp =  map[y][i];
			map[y][i] = carry;
			carry = tmp;
		}
		
		for(int i = y ; i > 0; i--) {
			int tmp =  map[i][C-1];
			map[i][C-1] = carry;
			carry = tmp;
		}
		
		for(int i = C-1 ; i > 0; i--) {
			int tmp =  map[0][i];
			map[0][i] = carry;
			carry = tmp;
		}
		
		for(int i = 0 ; i < y; i++) {
			int tmp =  map[i][0];
			map[i][0] = carry;
			carry = tmp;
		}
		
		y += 1;
		carry = 0;
		for(int i = 1 ; i < C-1; i++) {
			int tmp =  map[y][i];
			map[y][i] = carry;
			carry = tmp;
		}
		
		for(int i = y ; i < R-1; i++) {
			int tmp =  map[i][C-1];
			map[i][C-1] = carry;
			carry = tmp;
		}
		
		for(int i = C-1 ; i > 0; i--) {
			int tmp =  map[R-1][i];
			map[R-1][i] = carry;
			carry = tmp;
		}
		
		for(int i = R-1 ; i > y; i--) {
			int tmp =  map[i][0];
			map[i][0] = carry;
			carry = tmp;
		}
		
	}

	private void dust() {
		int[][] tmp = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 4) {
					int move = map[i][j] / 5;
					for(int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] != -1) {
							tmp[ny][nx] += move;
							tmp[i][j] -= move;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] += tmp[i][j];
			}
		}
	}
}
