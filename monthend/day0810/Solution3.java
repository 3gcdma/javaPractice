import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3 {
	private static Node[] n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		n = new Node[N];
		int size = 0;
		Label:
		for(int i = 0; i < N; i++) {
			String t = br.readLine();
			for(int j = 0; j < size; j++) {
				if(n[j].text.equals(t)) continue Label;
			}
			n[size++] = new Node(t, t.length());
		}
		Node[] Answer = Arrays.copyOf(n, size);
		Arrays.sort(Answer);
		
		for(int i = 0; i < size; i++) {
			System.out.println(Answer[i].text);
		}
		
	}
	
	public static class Node implements Comparable<Node>{
		String text;
		int length;
		
		public Node(String text, int length) {
			this.text = text;
			this.length = length;
		}

		@Override
		public int compareTo(Node o) {
			if(this.length == o.length) return this.text.compareTo(o.text);
			return this.length - o.length;
		}
		
	}
}
