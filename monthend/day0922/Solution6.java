import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2563
public class Solution6 {
	private int N;
	private boolean[][] map;
	public static void main(String[] args) throws IOException {
		new Solution6().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		map = new boolean[100][100];
		int count = 0;
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(stt.nextToken());
			int y = Integer.parseInt(stt.nextToken());
			
			for(int j = y; j < y+10; j++) {
				for(int k = x; k < x+10; k++) {
					if(!map[j][k]) count++;
					map[j][k] = true;
				}
			}
		}
		System.out.println(count);
		
	}
}
