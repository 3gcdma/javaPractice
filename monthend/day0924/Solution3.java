import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

///https://www.acmicpc.net/problem/13300
public class Solution3 {
	private int N, K;
	private int[][] map;
	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stt.nextToken());
		K = Integer.parseInt(stt.nextToken());
		map = new int[7][2];
		
		for(int i=0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());

			int sex = Integer.parseInt(stt.nextToken());
			int grade= Integer.parseInt(stt.nextToken());
			
			map[grade][sex]++;
		}
		
		int count = 0;
		
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < 2; j++) {
				count += map[i][j] / K; 
				if(map[i][j] % K != 0) count++;
			}
		}
		System.out.println(count);
		
	}
}
