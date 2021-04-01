package day0401;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1225 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		Queue<Integer> queue;
		int[] delete = {1,2,3,4,5};
		
		
		for(int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			queue = new LinkedList<>();
			
			
			stt = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(stt.nextToken()));
			}
			
			a:while(true) {
				for(int i = 0; i < 5; i++) {
					int tmp = queue.poll() - delete[i];
					
					if(tmp <= 0) {
						tmp = 0;
						queue.offer(tmp);
						break a;
					}
					
					queue.offer(tmp);
				}
			}
			
			System.out.print("#" + T +" ");
			for(int i : queue) {
				System.out.print(i + " ");
			}
			System.out.println();

		}
	}
}
