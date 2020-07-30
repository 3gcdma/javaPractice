

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        String current = "http://www.ssafy.com";
//        String current = "http://www.acm.org/";  // 문제에서의 시작페이지 
        Stack<String> backward = new Stack<String>();
        Stack<String> forward = new Stack<String>();
        while (true) {
            input = br.readLine().trim();
            if (input.charAt(0) == ('Q')) break;

            st = new StringTokenizer(input);
            switch (st.nextToken().charAt(0)) {
            case 'V':
                forward.clear();
                backward.push(current);
                current = st.nextToken();
                System.out.println(current);
                break;
            case 'B':
                if (backward.isEmpty()) {
                    System.out.println("Ignored");
                } else {
                    forward.add(current);
                    current = backward.pop();
                    System.out.println(current);
                }
                break;
            case 'F':
                if (forward.isEmpty()) {
                    System.out.println("Ignored");
                } else {
                    backward.add(current);
                    current = forward.pop();
                    System.out.println(current);
                }
                break;
            }
        }
    }
}
