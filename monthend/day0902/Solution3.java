import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution3 {
	private int N;
	private int[] people;
	private ArrayList<Integer>[] map;
	private boolean[] isChecked;
	private int Answer;

	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		isChecked = new boolean[N+1];
		map = new ArrayList[N+1];
		Answer = Integer.MAX_VALUE;
		
		stt = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(stt.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			stt = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(stt.nextToken());
			map[i] = new ArrayList<Integer>();
			
			for(int j = 0; j < T; j++) {
				map[i].add(Integer.parseInt(stt.nextToken()));
			}
		}
		
		powerSet(0);
		
		if(Answer == Integer.MAX_VALUE) Answer = -1;
		System.out.println(Answer);
	}

	private void powerSet(int cnt) {
		if(cnt > N) {
			int count = 0;
			for(int i = 1; i <= N; i++) {
				//System.out.print(isChecked[i] + " ");
				if(isChecked[i]) {
					count++;
				} 
			}
			if(count == N || count == 0) return;
			
			if(isConnect(true) && isConnect(false)) {
				diff();
			}
			
			return;
		}
		
		isChecked[cnt] = true;
		powerSet(cnt+1);
		isChecked[cnt] = false;
		powerSet(cnt+1);
	}

	private void diff() {
		int t = 0;
		int f = 0;
		for(int i = 1; i <= N; i++) {
			if(isChecked[i]) {
				t += people[i];
			}else {
				f += people[i];
			}
		}
		if(Answer > Math.abs(f-t)) Answer = Math.abs(f-t);
	}

	private boolean isConnect(boolean check) {
		boolean[] isConnected = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		int start  = 0;
		
		for(int i = 1; i <= N; i++) {
			if(isChecked[i] == check) {
				start = i;
				break;
			} 
		}

		
		isConnected[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int target = q.poll();
			int size = map[target].size();
			for(int i = 0; i < size; i++) {
				int tmp = map[target].get(i);
				if(!isConnected[tmp] && isChecked[tmp] == check) {
					isConnected[tmp] = true;
					q.offer(tmp);
				}
			}
		}
		
		for(int i = 1 ; i <= N; i++) {
			if(isConnected[i] != (isChecked[i] == check)) return false;
		}
		
		return true;
	}
}
