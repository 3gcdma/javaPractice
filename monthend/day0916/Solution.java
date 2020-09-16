import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private int N;
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}
	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		
		
		
		
		
		
		int second = 0;
		int wait = 0;
		
		Queue<int[]> b = new LinkedList<>();
		int bridge_weight = 0;
		
		
		while(true) {
			///System.out.println("count : " + second + " wait : " + wait);
			if(wait == truck_weights.length && b.isEmpty()) {
				break;
			}
			
			Queue<int[]> tmp = new LinkedList<>();
			while(!b.isEmpty()) {
				int[] t = b.poll();
				if(t[1] != bridge_length) {
					tmp.offer(new int[] {t[0], t[1] + 1});
				}else {
					bridge_weight -= t[0];
					//System.out.println(t[0] + " " + second);
				}
			}
			b = tmp;
			
			
			if(wait < truck_weights.length && bridge_weight + truck_weights[wait] <= weight) {
				bridge_weight += truck_weights[wait];
				b.offer(new int[] {truck_weights[wait++], 1});
			}
			
			
			second++;
		}
		
		System.out.println(second);
	}
}
