import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/2578
public class Solution5 {
	private int[][] map;
	private boolean[][] isChecked;
	public static void main(String[] args) throws IOException {
		new Solution5().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		isChecked = new boolean[5][5];
		map = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		
		for(int i = 0; i < 5; i++) {
			stt = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				int target = Integer.parseInt(stt.nextToken());
				erase(target);
				
				if(checked() >= 3) {
					System.out.println(i*5 + j + 1);
					return ;
				}
			
			}
		}
		
	}

	private int checked() {
		int count = 0;
		
		label:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(!isChecked[i][j]) {
					continue label;
				}
			}
			count++;
		}
		
		label:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(!isChecked[j][i]) {
					continue label;
				}
			}
			count++;
		}
		
		int i = 0;
		for(i = 0; i < 5; i++) {
			if(!isChecked[i][i]) {
				break;
			}
		}
		if(i == 5) count++;
		
		for(i = 0; i < 5; i++) {
			if(!isChecked[i][4-i]) {
				break;
			}
		}
		if(i == 5) count++;
		
		return count;
	}

	private void erase(int target) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(map[i][j] == target) {
					isChecked[i][j] = true;
					return;
				}
			}
		}
	}
}
