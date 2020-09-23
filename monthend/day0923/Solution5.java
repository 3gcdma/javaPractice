import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/10157
public class Solution5 {
	private int C, R;
	private boolean[][] isChecked;
	public static void main(String[] args) throws IOException {
		new Solution5().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		C = Integer.parseInt(stt.nextToken());
		R = Integer.parseInt(stt.nextToken());
		isChecked = new boolean[R][C];
		
		int target = Integer.parseInt(br.readLine());
		int count = 0;
		int x = -1, y = -1;
		
		
		int size = R < C ? R : C;
		
		if(size%2 == 1) ++size;
		size /= 2;
		
		
		label:
		for(int n = 0; n < size; n++) {
			for(int i = n ; i < R-n-1; i++) {
				System.out.println(i + " " + n);
				if(!isChecked[i][n]) {
					isChecked[i][n] = true;
					count++;
					
					if(count == target) {
						y = i;
						x = n;
						break label;
					} 
				}
				
					
			}
			
			for(int j = n ; j < C-n-1; j++) {
				System.out.println((R-n-1) + " " + j);
				if(!isChecked[R-n-1][j]) {
					isChecked[R-n-1][j] = true;
					count++;
					
					if(count == target) {
						y = R-n-1;
						x = j;
						break label;
					} 
				}
				
			}
			
			for(int i = R-n-1 ; i > n; i--) {
				System.out.println(i + " " + (C-n-1));
				if(!isChecked[i][C-n-1]) {
					isChecked[i][C-n-1] = true;
					count++;
					
					if(count == target) {
						y = i;
						x = C-n-1;
						break label;
					} 
				}
				
			}
			
			for(int j = C-n-1 ; j > n; j--) {
				System.out.println(n + " " + j);
				if(!isChecked[n][j]) {
					isChecked[n][j] = true;
					count++;
					
					if(count == target) {
						y = n;
						x = j;
						break label;
					} 
				}
				
			}
			
		}
		if(x == -1 && y == -1) System.out.println(0);
		else System.out.println((x+1) + " " + (y+1));
	}
}
