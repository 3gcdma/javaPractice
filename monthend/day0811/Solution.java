package day0811.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		new Solution().start();
	}

	private void start() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<Integer>();
		int size;
		boolean isTrue;
		String Answer;
		
		
		try {
			String input = br.readLine();
			while(!input.equals("0")){
				size = input.length();
				isTrue = true;
				Answer = "yes";
				
				for(int i = 0; i < size/2; i++) {
					s.push(input.charAt(i) - '0');
				}
				
				int tmp = size/2;
				if(input.length()%2 != 0) tmp++;
				while(!s.isEmpty()) {
					if(s.pop() != (input.charAt(tmp++) - '0')) {
						isTrue = false;
					}
				}
				
				if(!isTrue) Answer = "no";
				System.out.println(Answer);
				
				input = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
