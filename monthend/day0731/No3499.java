import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class No3499 {
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> left = new LinkedList<String>();
		Queue<String> right = new LinkedList<String>();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stt;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = Integer.parseInt(br.readLine());
			int half = num / 2;
			stt = new StringTokenizer(br.readLine());
			String s;
			
			if(num%2 == 1) half++;
			
			for(int i = 0; i < half; i++) {
				left.offer(stt.nextToken());
			}
			for(int i = half; i < num; i++) {
				right.offer(stt.nextToken());
			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < num; i++) {
				if(i%2 == 0 && !left.isEmpty()) {
					System.out.print(left.poll() + " ");
				}else if(i%2 == 1 && !right.isEmpty()) {
					System.out.print(right.poll() + " ");
				}
			}
			System.out.println();
		}
	}
}
