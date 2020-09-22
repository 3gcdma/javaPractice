import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2564
public class Solution7 {
	private int N, M;
	private int[][] map;
	private int[][] cases;
	private int Answer;
	public static void main(String[] args) throws IOException {
		new Solution7().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		Answer = 0;
		int test_case = Integer.parseInt(br.readLine());
		cases = new int[test_case][2];
		
		for(int i = 0; i < test_case; i++) {
			stt = new StringTokenizer(br.readLine());
			cases[i][0] = Integer.parseInt(stt.nextToken());
			cases[i][1] = Integer.parseInt(stt.nextToken());
		}
		
		stt = new StringTokenizer(br.readLine());
		int locate = Integer.parseInt(stt.nextToken());
		int distance = Integer.parseInt(stt.nextToken());
		
		for(int i = 0; i < test_case; i++) {
			
			switch (locate) {
			case 1:
				switch (cases[i][0]) {
				case 1:
					Answer += Math.abs(distance - cases[i][1]);
					break;
				case 2:
					Answer += Math.min(M+ N-distance + N - cases[i][1], M+ distance + cases[i][1]);
					break;
				case 3:
					Answer += distance + cases[i][1];
					break;
				case 4:
					Answer += N - distance + cases[i][1];
					break;
				}
				break;
				
			case 2:
				switch (cases[i][0]) {
				case 1:
					Answer += Math.min(M+ N-distance + N - cases[i][1], M+ distance + cases[i][1]);
					break;
				case 2:
					Answer += Math.abs(distance - cases[i][1]);
					break;
				case 3:
					Answer += distance + M - cases[i][1];
					break;
				case 4:
					Answer += N - distance + M - cases[i][1];
					break;
				}
				break;
			case 3:
				switch (cases[i][0]) {
				case 1:
					Answer += distance + cases[i][1];
					break;
				case 2:
					Answer += M - distance + cases[i][1];
					break;
				case 3:
					Answer += Math.abs(distance - cases[i][1]);
					break;
				case 4:
					Answer += Math.min(N+ M-distance + M - cases[i][1], N+ distance + cases[i][1]);
					break;
				}
				break;
			case 4:
				switch (cases[i][0]) {
				case 1:
					Answer += distance + N - cases[i][1];
					break;
				case 2:
					Answer += M - distance + N - cases[i][1];
					break;
				case 3:
					Answer += Math.min(N+ M-distance + M - cases[i][1], N+ distance + cases[i][1]);
					break;
				case 4:
					Answer += Math.abs(distance - cases[i][1]);
					break;
				}
				break;

			}
		}
		
		System.out.println(Answer);
	}
}
