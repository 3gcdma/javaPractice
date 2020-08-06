import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
	
	private int cost;
	private int count = 0;
	private int[] arr = {500, 100, 50, 10, 5, 1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution2().start();
	}

	private void start() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cost = 1000 - Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 6; i++) {
			count += cost / arr[i];
			cost %= arr[i];
			
		}
		
		System.out.println(count);
	}
}
