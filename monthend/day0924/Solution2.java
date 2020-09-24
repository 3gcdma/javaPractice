import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private int N;
	private boolean[][] map;
	
	//https://www.acmicpc.net/problem/14696
	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}
	
	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int[] a;
		int[] b;
		N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			int answer = 0;
			a = new int[5];
			b = new int[5];
			
			
			
			stt = new StringTokenizer(br.readLine());
			
			int tmp = Integer.parseInt(stt.nextToken());
			for(int i = 0; i < tmp; i++) {
				int t = Integer.parseInt(stt.nextToken());
				a[t]++;
			}
			
			stt = new StringTokenizer(br.readLine());
			
			tmp = Integer.parseInt(stt.nextToken());
			for(int i = 0; i < tmp; i++) {
				int t = Integer.parseInt(stt.nextToken());
				b[t]++;
			}
			
			if(a[4] == b[4]) {
				if(a[3] == b[3]) {
					if(a[2] == b[2]) {
						answer = a[1] - b[1];
					}else{
						answer = a[2] - b[2];
					}
				}else {
					answer = a[3] - b[3];
				}
			}else {
				answer = a[4] - b[4];
			}
			
			if(answer > 0) System.out.println("A");
			else if(answer < 0) System.out.println("B");
			else System.out.println("D");
			
		}
	}
}
