import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {
	
	static class Node{
		int data;
		Node next;
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	static int N = 101;
	static Node[] map;
	static boolean[] checked;
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		new Solution().start(); 

	}

	private void start() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			map = new Node[N];
			checked = new boolean[N];
			stt = new StringTokenizer(br.readLine());
			int cases = Integer.parseInt(stt.nextToken());
			int start = Integer.parseInt(stt.nextToken());
			stt = new StringTokenizer(br.readLine());
			for(int i = 0; i < cases/2; i++) {
				int from = Integer.parseInt(stt.nextToken());
				int to = Integer.parseInt(stt.nextToken());
				map[from] = new Node(to, map[from]);
			}
			
			bfs(start);
			System.out.println("#" + test_case + " " + max);
		}
	}

	private void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		//Queue<Integer> tmp = new LinkedList<Integer>();
		
		q.offer(start);
		checked[start] = true;
		
		while(!q.isEmpty()) {
			max = 0;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int num = q.poll();
				if(max < num) max = num;
				
				Node t = map[num];
				while(t != null) {
					if(!checked[t.data]) {
						q.offer(t.data);
						checked[t.data] = true;
					}
					t = t.next;
				}
			}
		}
		
	}
}