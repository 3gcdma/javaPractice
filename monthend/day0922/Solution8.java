import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2491
public class Solution8 {
	private int N;
	private int[] map;
	public static void main(String[] args) throws IOException {
		new Solution8().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		map = new int[N];
		stt = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(stt.nextToken());
		}
		
		int Answer = 0;
		int count = 1;
		for(int i = 1; i < N; i++) {
			if(map[i] >= map[i-1]) count++;
			else {
				if(Answer < count) Answer = count;
				count = 1;
			}
		}
		
		if(Answer < count) Answer = count;
		
		count = 1;
		for(int i = 1; i < N; i++) {
			if(map[i] <= map[i-1]) count++;
			else {
				if(Answer < count) Answer = count;
				count = 1;
			}
		}
		
		if(Answer < count) Answer = count;
		
		
		System.out.println(Answer);
	}
}
