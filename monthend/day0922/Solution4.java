import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


///https://www.acmicpc.net/problem/2605
public class Solution4 {
	private int N;

	public static void main(String[] args) throws IOException {
		new Solution4().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		
		stt = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			list.add(i - 1 - Integer.parseInt(stt.nextToken()), i);
		}
		
		for(Integer i : list) {
			System.out.print(i + " ");
		}
		
	}
}
