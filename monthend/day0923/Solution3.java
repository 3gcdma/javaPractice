import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/2477
public class Solution3 {
	private int N;
	private int[] map;
	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		map = new int[5];
		int first = 0;
		int count = 0;
		
		stt = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(stt.nextToken());
		int data = Integer.parseInt(stt.nextToken());
		first = data;
		if(map[dir] < data) {
			map[dir] = data;
		}
		
		for(int i = 1; i < 6; i++) {
			stt = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(stt.nextToken());
			int t_data = Integer.parseInt(stt.nextToken());
			
			count += t_data * data;
			data = t_data;
			if(map[dir] < data) {
				map[dir] = data;
			}
		}
		count += data * first;
		int x = map[3] > map[4] ? map[3] : map[4];
		int y = map[1] > map[2] ? map[1] : map[2];
		
		System.out.println((count - 2 * x * y)*N);
	}
}
