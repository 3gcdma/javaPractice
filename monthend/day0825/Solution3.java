import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	private int N, r, c;
	private int Answer;
	private int count = 0;
	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stt.nextToken());
		r = Integer.parseInt(stt.nextToken());
		c = Integer.parseInt(stt.nextToken());
		int n = (int) Math.pow(2,N);

		
		DnQ(0, 0, n);
		
		System.out.println(Answer);
	}

	private boolean DnQ(int y, int x, int size) {
		if(size == 1) {
			if(y == r && x == c) {
				Answer = count;
				return true;
			} 
			count++;
			return false;
		}
		
		if(DnQ(y, x, size/2)) {
			return true;
		}
		if(DnQ(y, x+size/2, size/2)) {
			return true;
		}
		if(DnQ(y+size/2, x, size/2)) {
			return true;
		}
		if(DnQ(y+size/2, x+size/2, size/2)) {
			return true;
		}
		return false;
	}
}