import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	private Node[] n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution().start();
	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int N = Integer.parseInt(br.readLine());
		n = new Node[N];
		
		for(int i = 0; i < N; i++) {
			Node tmp = new Node();
			stt = new StringTokenizer(br.readLine());
			tmp.age = Integer.parseInt(stt.nextToken());
			tmp.name = stt.nextToken();
			tmp.cnt = i;
			n[i] = tmp;
		}
		
		Arrays.sort(n);
		
		for(int i = 0; i < N; i++) {
			System.out.println(n[i].age + " " + n[i].name);
		}
		
	}
}

class Node implements Comparable<Node>{
	int age;
	String name;
	int cnt;
	
	@Override
	public int compareTo(Node o) {
		if(this.age == o.age) return this.cnt - o.cnt;
		return this.age - o.age;
	}
}