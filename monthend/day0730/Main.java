import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack<int[]> input = new Stack<int[]>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hight = Integer.parseInt(br.readLine());
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= hight; i++) {
			int num = Integer.parseInt(stt.nextToken());
			if(input.isEmpty()) {
				input.push(new int[] {i, num});
				System.out.print(0 + " ");
				continue;
			}
			
			if(num < input.peek()[1]) {
				System.out.print(input.peek()[0]+ " ");
				input.push(new int[] {i, num});
			}else {
				while(true) {
					if(input.isEmpty()) {
						System.out.print(0 + " ");
						break;
					}
					int[] temp = input.pop();
					if(temp[1] > num) {
						System.out.print(temp[0]+ " ");
						input.push(temp);
						break;
					}
					
				}
				input.push(new int[] {i, num});
			}
			
		}
	}

}
