import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution5 {
	private int Answer;
	private int[] arr;
	private int N, M;
	private Stack<Integer> st = new Stack<Integer>();
	
	public static void main(String args[]) throws Exception
	{
		
		new Solution5().start();
		
	}

	private void start() throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T;
		
		
		
		T=Integer.parseInt(bf.readLine());
		
		StringTokenizer stt;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			stt = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(stt.nextToken());
			M = Integer.parseInt(stt.nextToken());
			
			arr = new int[N];
			Answer = -1;
			stt = new StringTokenizer(bf.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(stt.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				st.push(i);
				dfs();
				st.pop();
			}
			
			System.out.println("#"+test_case +" " + Answer);
			
		}
	}

	private void dfs() {
		if(st.size() == 2) {
			int x = arr[st.pop()];
			int sum = arr[st.peek()] + x;
			if(sum <= M && Answer < sum) {
				Answer = sum;
			}
			return;
		}
		
		for(int i = st.peek()+1; i < N ; i++) {
			st.push(i);
			dfs();
		}
		
		
	}
}
