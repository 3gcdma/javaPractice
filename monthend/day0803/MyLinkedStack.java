
import java.util.Arrays;

import com.ssafy.live04.Node;

public class MyLinkedStack {
	class Node{ //내부클래스
		String data;
		Node link;
		
		public Node(String data, Node link) {
			//super();
			this.data = data;
			this.link = link;
		}
		
		public Node(String data) {
			//super();
			this.data = data;
		}
	}
	
	private Node head = null;

	public boolean isEmpty() {
		return (head == null);
	}
	
	
	public void push(String item) {
		Node tmpNode = new Node(item, head);
		head = tmpNode;
	}
	
	public String peek() {
		return head.data;
	}
	
	public String pop() {
		String text = head.data;
		head = head.link;
		return text;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Node currNode = head; currNode != null; currNode = currNode.link) {
			sb.append(currNode.data);
			
		}
		return sb.toString();
	}
	
}
