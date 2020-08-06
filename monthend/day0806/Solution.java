import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	private int N;
	private int[][] arr;
	
	static class compared implements Comparator<int[]>{

		public int compare(int[] o1, int[] o2) {
			if(o2[1] == o1[1]) return o1[0] - o2[0];
			else return o1[1] - o2[1];

		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().start();
		
		
	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			stt = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stt.nextToken());
			arr[i][1] = Integer.parseInt(stt.nextToken());

		}
		
		Arrays.sort(arr, new compared());
		
		int time = 0;
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i][0] >= time) {
				count++;
				time = arr[i][1];
			}
		}
		System.out.println(count);
		
	}

}
