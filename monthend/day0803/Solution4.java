
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int Answer = 1;
			StringTokenizer stt;
			int cases = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < cases; i++) {
				String tmp;
				stt = new StringTokenizer(br.readLine());
				stt.nextToken();
				tmp = stt.nextToken();
				if(!stt.hasMoreTokens() ) {
					switch(tmp) {
					case "+":
					case "-":
					case "*":
					case "/":
						Answer = 0;
						break;
					default :

					}
				}
			}

			System.out.println("#" + test_case + " " + Answer);

		}
	}
}