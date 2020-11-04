
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5643_2 {
	private int N, M;
	private int Answer;
	private int[][] map;
	private int[][] result;
	private int MAX = 1000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution5643_2().start();
	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			Answer = 0;
			
			for(int i = 0 ; i < M; i++) {
				stt = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(stt.nextToken());
				int to = Integer.parseInt(stt.nextToken());
				
				map[from][to] = 1;
			}
			
			FW();
			
			for(int i = 1 ; i <= N; i++) {
				int count = 0;
				for(int j = 1; j <= N; j++) {
					if(result[i][j] != MAX) count++;
					if(result[j][i] != MAX) count++;
				}
				if(count == N-1) Answer++;
			}
			
			System.out.println("#"+t + " " + Answer);
		}
		
	}

	private void FW() {
		result = new int[N+1][N+1];
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] != 0) result[i][j] = map[i][j];
				else result[i][j] = MAX;
			}
		}
		
		for(int k = 1; k <= N; k++) {
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(result[i][k] + result[k][j] < result[i][j]) {
						result[i][j] = result[i][k] + result[k][j];
					}
				}
			}
		}
	}
}
