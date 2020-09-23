import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


//https://programmers.co.kr/learn/courses/30/lessons/42628?language=java
public class Solution6 {
	private int N;

	public static void main(String[] args) throws IOException {
		new Solution6().start();
	}

	private void start() throws IOException {
		String[] operations = {"I 7","I 5","I -5","D -1"};
		
		int[] Answer = solution(operations);
		System.out.println(Answer[0] +" " + Answer[1]);
	}

	private int[] solution(String[] operations) {
		PriorityQueue<Integer> max = new PriorityQueue<Integer>((e1, e2) -> {
			return (e1 - e2) * -1;
		});
		Queue<Integer> q = new LinkedList<Integer>();
		
		StringTokenizer stt;
		
		
		int[] answer = new int[2];
		
		for(int i = 0; i < operations.length; i++) {
			stt = new StringTokenizer(operations[i]);
			String dir = stt.nextToken();
			if(dir.equals("I")) {
				max.offer(Integer.parseInt(stt.nextToken()));
			}
			else {
				if(!max.isEmpty()) {
					if(Integer.parseInt(stt.nextToken()) < 0) {
						while(max.size() > 1) {
							q.offer(max.poll());
						}
						max.poll();
						while(!q.isEmpty()) {
							max.offer(q.poll());
						}
					}else {
						max.poll();
					}
				}
			}
			
		}
		
		if(max.size() > 1) {
			answer[0] = max.poll();
			while(max.size() > 1) {
				max.poll();
			}
			answer[1] = max.poll();
		}else if(max.size() == 1) {
			int tmp = max.poll();
			answer[0] = tmp;
			answer[1] = tmp;
		}
		
		return answer;
	}
}
