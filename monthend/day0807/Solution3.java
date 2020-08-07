import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	private int N, M;
	private int[] s1 = {1,1,0,0};
	private int[] s2 = {0,0,1,1};
	
	
	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer stt = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stt.nextToken());
			M = Integer.parseInt(stt.nextToken());
			
			int firstx = 0;
			int firsty = 0;
			int secondx = 0;
			int secondy = 0;
			
			for(int i = 0; i < N; i++) {
				firstx += s1[i%4];
			}
			for(int i = 0; i < M; i++) {
				firsty += s1[i%4];
			}
			
			for(int i = 0; i < N; i++) {
				secondx += s2[i%4];
			}
			for(int i = 0; i < M; i++) {
				secondy += s2[i%4];
			}
			
			System.out.println("#" + test_case + " " + (firstx * firsty + secondx * secondy));
			
		}
	}

}
