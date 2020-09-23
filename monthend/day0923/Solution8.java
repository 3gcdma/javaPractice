import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10158
public class Solution8 {
	private static int N, M;
	private static int x, y;
	private static int move;
	private static int[] dx = {1,-1};
	private static int[] dy = {1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		M = Integer.parseInt(stt.nextToken());
		N = Integer.parseInt(stt.nextToken());
		
		stt = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(stt.nextToken());
		y = Integer.parseInt(stt.nextToken());
		
		move = Integer.parseInt(br.readLine());
		
		int tx = move%(M*2);
		int ty = move%(N*2);
		
		int dir = 0;
		for(int i = 0; i < tx; i++) {
			if(x == 0) dir = 0;
			else if(x == M) dir = 1;
			
			x += dx[dir];
		}
		
		dir = 0;
		for(int i = 0; i < ty; i++) {
			if(y == 0) dir = 0;
			else if(y == N) dir = 1;
			
			y += dy[dir];
		}
		
		
		System.out.println(x + " " + y);
	}
}
