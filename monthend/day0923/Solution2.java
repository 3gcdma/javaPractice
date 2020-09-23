import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/17413
public class Solution2 {
	private int N;

	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		boolean tagFlag = false;
		int size = s.length();
		for(int i = 0; i < size; i++) {
			char tmp = s.charAt(i);
			if(tmp == '<') {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				tagFlag = true;
			}else if(tmp == '>') {
				sb.append(tmp);
				tagFlag = false;
				continue;
			}
			
			if(tagFlag) {
				sb.append(tmp);
				continue;	
			}
			
			
			
			if(tmp == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			}else {
				stack.push(tmp);
			}
		}
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}
		
		System.out.println(sb.toString());
	}
}
