import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5 {

	private int N, M;
	private int dx[] = {1,-1,0};
	private int dy[] = {1,1,2};
	private boolean[] isChecked = new boolean[100010];
	private int Answer = 0;
	
	public static void main(String[] args) throws IOException {
		new Solution5().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		
		if(N >= M) {
			System.out.println(N - M);
			System.exit(0);
		}
		BFS();
		System.out.println(Answer+1);
	}

	private void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(N);
		isChecked[N] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			//System.out.println(q.toString());
			for(int s = 0; s < size; s++) {
				int tmp = q.poll();
				
				for(int i = 0; i < 3; i++) {
					int tmpx = tmp + dx[i];
					tmpx *= dy[i];
					if(tmpx >= 0 && tmpx <= 100000 && !isChecked[tmpx]) {
						if(tmpx == M) return;
						else {
							q.offer(tmpx);
							isChecked[tmpx] = true;
						}
					}
				}
			}
			Answer++;
		}
		
	}

}