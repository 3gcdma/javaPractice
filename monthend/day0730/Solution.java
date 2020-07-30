
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{	
		
			Stack<Character> stack = new Stack<Character>();
			String s;
			char cmp;
			int T;
			int Answer = 1;
			
			T=sc.nextInt();
			sc.nextLine();
			
			s = sc.nextLine();
			Label :
			for(int i = 0; i < T; i++) {
				
				cmp = s.charAt(i);
				switch(cmp) {
					case '(' :
					case '{' :
					case '[' :
					case '<' :
						stack.push(cmp);
						break;
						/*
					case ')' :
						if(!stack.isEmpty() && stack.pop() == '(') {
							
						}else {
							Answer = 0;
							break Label;
						}
						break;
					case '}' :
						if(!stack.isEmpty() && stack.pop() == '{') {
							
						}else {
							Answer = 0;
							break Label;
						}
						break;
					case ']' :
						if(!stack.isEmpty() && stack.pop() == '[') {
							
						}else {
							Answer = 0;
							break Label;
						}
						break;
					case '>' :
						if(!stack.isEmpty() && stack.pop() == '<') {
							
						}else {
							Answer = 0;
							break Label;
						}
						break;
						*/
					default:
						if(!check(stack, cmp)) {
							Answer = 0;
							break Label;
						}
				}
				
				
			}
			
			if(!stack.isEmpty()) {
				Answer = 0;
				//System.out.println(stack.size() + " " + stack.peek());
			}
			System.out.println("#" + (test_case) + " " + Answer);
		}
	}

	private static boolean check(Stack<Character> stack, char cmp) {
		if(stack.isEmpty()) return false;
		char ch = stack.pop();
		switch(cmp) {
		case ')' : return ch == '(';
		case '}' : return ch == '{';
		case ']' : return ch == '[';
		case '>' : return ch == '<';
		}

		return false;
	}
}
