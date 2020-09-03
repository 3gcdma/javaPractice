import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private int N;
	private int[][] map;
	private int[] team1;
	private int[] team2;
	private int[] num;
	private boolean[] isChecked;
	private int Answer;
	private int sum;
	
	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		team1 = new int[N/2];
		team2 = new int[N/2];
		isChecked = new boolean[N];
		num = new int[2];
		Answer = Integer.MAX_VALUE;
		
		for(int i = 0 ;i < N ;i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		combination(0,0);
		
		System.out.println(Answer);
	}

	private void combination(int cnt, int cur) {
		if(cnt == N/2) {
			int count = 0;
			for(int i = 0; i < N ; i++) {
				if(!isChecked[i]) {
					team2[count++] = i;
				}
			}
			sum = 0;
			combinationT1(0, 0);
			int f = sum;
			sum = 0;
			combinationT2(0, 0);
			int s = sum;
			if(Answer > Math.abs(f-s)) Answer = Math.abs(f-s);
			return;
		}
		
		for(int i = cur; i < N; i++) {
			isChecked[i] = true;
			team1[cnt] = i;
			combination(cnt+1, i+1);
			isChecked[i] = false;
			
		}
	}

	private void combinationT2(int cnt, int cur) {
		if(cnt == 2) {
			sum += map[num[0]][num[1]] + map[num[1]][num[0]];
			return;
		}
		for(int i = cur; i < N/2; i++) {
			num[cnt] = team2[i];
			combinationT2(cnt+1, i+1);
		}
	}

	private void combinationT1(int cnt, int cur) {
		if(cnt == 2) {
			sum += map[num[0]][num[1]] + map[num[1]][num[0]];
			return;
		}
		for(int i = cur; i < N/2; i++) {
			num[cnt] = team1[i];
			combinationT1(cnt+1, i+1);
		}
	}
}
