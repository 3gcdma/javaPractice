import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No1223 {
	Stack<Character> mos = new Stack<Character>();
	
	Queue<Character> s = new LinkedList<Character>();
	
	Stack<Integer> num = new Stack<Integer>();
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		new No1223().start();
		
	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T = Integer.parseInt(br.readLine());
			
			String c = br.readLine();
			for(int i = 0; i < T; i++) {
				char tmp = c.charAt(i);
				seperate(tmp);
			}
			while(!mos.empty()){
				s.offer(mos.pop());
			}
			
//			while(!s.isEmpty()) {
//				System.out.print(s.poll());
//			}
			
			for(int i = 0; i < T; i++) {
				char tmp = s.poll();
				calcuate(tmp);
			}
			
			System.out.println("#" + test_case + " " + num.pop());
		}
	}

	private void calcuate(char tmp) {
		// TODO Auto-generated method stub
		int first;
		int second;
		if(tmp >= '0' && tmp <= '9') {
			num.push(tmp - '0');
		}else {
			first = num.pop();
			second = num.pop();
			
			if(tmp == '*') {
				num.push(first * second);
				
			}else {
				num.push(first + second);
			}

		} 
		
	}

	private void seperate(char tmp) {
		if(tmp >= '0' && tmp <= '9') {
			s.offer(tmp);
		}else if(tmp == '*') {
			while(!mos.isEmpty()) {
				if(mos.peek() != '*') break;
				s.offer(mos.pop());
			}
			mos.push(tmp);
		}else {
			while(!mos.isEmpty()) {
				s.offer(mos.pop());
			}
			mos.push(tmp);
		}
		
	}
}
