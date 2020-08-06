import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	
	private int N;
	private int[][] gread;
	private int Answer;
	private boolean[] isChecked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution3().start();

	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		N = Integer.parseInt(br.readLine());
		gread = new int[N+1][2];
		Answer = 1000000000;
		isChecked = new boolean[N+1];
		
		for(int i = 1; i<= N ; i++) {
			stt = new StringTokenizer(br.readLine());
			gread[i][0] = Integer.parseInt(stt.nextToken());
			gread[i][1] = Integer.parseInt(stt.nextToken());
		}
		
		powerSet(1);
		
		System.out.println(Answer);
	}

	private void powerSet(int cnt) {
		if(cnt > N) {
			int bit=0, shawer=1;
			for(int i = 1; i <= N; i++) {
				if(isChecked[i]) {
					bit += gread[i][1];
					shawer *= gread[i][0];
					
				}
			}
			if(bit == 0 && shawer == 1) return;
			int diff = Math.abs(bit - shawer);
			//System.out.println(diff);
			if( Answer > diff) Answer = diff;
			return;
		}
		
		isChecked[cnt] = true;
		powerSet(cnt+1);
		isChecked[cnt] = false;
		powerSet(cnt+1);
		
	}

}
