
import java.util.Stack;

public class ST1 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		System.out.println(stack.size() +"//"+stack.isEmpty());
		stack.push("가나다");
		stack.push("마바사");
		stack.push("아자차");
		System.out.println(stack.size() +"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size() +"//"+stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size() +"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size() +"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size() +"//"+stack.isEmpty());
	}

}
