import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


//https://www.acmicpc.net/problem/2635
public class Solution7 {
	private int N;

	public static void main(String[] args) throws IOException {
		new Solution7().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> Answer = new ArrayList<Integer>();
		int Answer_count = 0;
		
		for(int i = N; i >= N/2; i--) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(N);
			list.add(i);
			int count = 2;
			while(true) {
				int distanse = list.get(count-2) - list.get(count -1);
				if(distanse < 0) break;
				list.add(distanse);
				count++;
			}
			if(Answer_count < count) {
				Answer_count = count;
				Answer = list;
			}
		}
		
		System.out.println(Answer_count);
		for(int i = 0; i < Answer_count; i++) {
			System.out.print(Answer.get(i) + " ");
		}
		
	}
}
