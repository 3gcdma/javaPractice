
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String args[]) throws Exception
	{
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
				int locate;
				int ever;
				
				switch(stt.nextToken()) {
				case "I":
					locate = Integer.parseInt(stt.nextToken());
					ever = Integer.parseInt(stt.nextToken());
					for(int j = locate; j < locate + ever; j++) {
						ll.add(j, Integer.parseInt(stt.nextToken()));
					}
					break;
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 10 ; i++) {
				System.out.print(ll.pop() + " ");
			}
		}
	}
}
