import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {

	private int N, Large;
	private int[][] arr;
	private boolean[] isChecked;
	private int satisefy = 0;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution4().start();

	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			stt = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(stt.nextToken());
			Large = Integer.parseInt(stt.nextToken());
			arr = new int[N][2];
			isChecked = new boolean[N];
			satisefy = 0;
			
			for(int i = 0; i < N; i++) {
				stt = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(stt.nextToken());
				arr[i][1] = Integer.parseInt(stt.nextToken());
			}
			com(0);
			
			System.out.println("#" + test_case + " " + satisefy);
		}
	}

	private void com(int cnt) {
		if(cnt == N) {
			int sat = 0;
			int total = 0;
			for(int i = 0; i < N; i++) {
				if(isChecked[i]) {
					sat += arr[i][0];
					total += arr[i][1];
				} 
			}
			if(total > Large) return;
			
			if(satisefy < sat) {
				satisefy = sat;
			}
		
			return;
		}
		
		isChecked[cnt] = true;
		com(cnt+1);

		isChecked[cnt] = false;
		com(cnt+1);
	}


}
