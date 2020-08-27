import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {
	
	private int N;
	private int[] comp = new int[2];
	private int[] home = new int[2];
	private int[] num;
	private boolean[] isChecked;
	private List<int[]> list;
	private int min;
	
	public static void main(String args[]) throws Exception
	{

		new Solution2().start();

	}

	private void start() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			isChecked = new boolean[N];
			list = new ArrayList<>();
			min = 99999999;
			
			stt = new StringTokenizer(br.readLine());
			comp[0] = Integer.parseInt(stt.nextToken());
			comp[1] = Integer.parseInt(stt.nextToken());

			home[0] = Integer.parseInt(stt.nextToken());
			home[1] = Integer.parseInt(stt.nextToken());
			
			for(int i = 0; i < N; i++) {
				int[] tmp = new int[2];
				tmp[0] = Integer.parseInt(stt.nextToken());
				tmp[1] = Integer.parseInt(stt.nextToken());
				
				list.add(tmp);
			}
			
			
			
			purmutation(0);
			System.out.println("#" + test_case + " " + min);
		}
	}

	private void purmutation(int cnt) {
		if(cnt == N) {
//			for(int i = 0 ; i < N ;i++) {
//				System.out.print(num[i]);
//			}
//			System.out.println();
			distance();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isChecked[i]) continue;
			isChecked[i] = true;
			num[cnt] = i;
			purmutation(cnt+1);
			isChecked[i] = false;
		}
		
	}

	private void distance() {
		int sum = 0;
		
		int[] t1;
		int[] t2 = list.get(num[0]);
		
		
		sum += (Math.abs(comp[0] - t2[0]) + Math.abs(comp[1] - t2[1]));
		
		for(int i = 0 ; i < N-1; i++) {
			t1 = list.get(num[i]);
			t2 = list.get(num[i+1]);
			sum += (Math.abs(t1[0] - t2[0]) + Math.abs(t1[1] - t2[1]));
			//System.out.println(num[i] + " " + num[i+1]);
		}
		
		t1 = list.get(num[N-1]);
		sum += (Math.abs(home[0] - t1[0]) + Math.abs(home[1]- t1[1]));
		//System.out.println(sum);
		if(min > sum) min = sum;
	}
}
