import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution3 {
	
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			LinkedList<Integer> ll = new LinkedList<Integer>();
			
			int original = Integer.parseInt(br.readLine());
			StringTokenizer stt = new StringTokenizer(br.readLine());
			for(int i = 0; i < original; i++) {
				ll.add(Integer.parseInt(stt.nextToken()));
			}
			
			int cases = Integer.parseInt(br.readLine());
			stt = new StringTokenizer(br.readLine());
			for(int i = 0; i < cases; i++) {
				int target;
				int length;
				
				switch(stt.nextToken()) {
				case "I":
					target = Integer.parseInt(stt.nextToken());
					length = Integer.parseInt(stt.nextToken());
					for(int j = target; j < target + length; j++) {
						ll.add(j, Integer.parseInt(stt.nextToken()));
					}
					break;
				case "D" :
					LinkedList<Integer> temp = ll;
					target = Integer.parseInt(stt.nextToken());
					length = Integer.parseInt(stt.nextToken());
					for(int j = 0; j < length; j++) {
						ll.remove(target);
					}
					break;
				case "A":
					length = Integer.parseInt(stt.nextToken());
					for(int j = 0; j < length; j++) {
						ll.addLast(Integer.parseInt(stt.nextToken()));
					}
					break;
				}
				
			}
			System.out.print("#" + test_case + " ");
			int print = 10;
			if(ll.size() < 10) print = ll.size();
			for(int i = 0; i < print ; i++) {
				System.out.print(ll.pop() + " ");
			}
			System.out.println();
		}
	}
}
