import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1861 {
	private int N;
	private int[][] map;
	private int[][] check;
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};
	
 	public static void main(String args[]) throws Exception
	{
 		System.setIn(new FileInputStream("input.txt"));
		new No1861().start();
		
	}
 	
	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stt.nextToken());
				}
			}
			
			
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					recul(i, j);
				}
			}
			
			
			
			int max = 0;
			int num = 110;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(check[i][j] > max) {
						max = check[i][j];
						num = map[i][j];
					}else if(check[i][j] == max && num > map[i][j]) {
						num = map[i][j];
					}
				}
			}
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(check[i][j]);
//				}
//				System.out.println();
//			}
			
			System.out.println("#" + test_case + " " + num + " " + (max+1));
		}
		
	}
	private int recul(int y, int x) {

		if(check[y][x] != 0) {
			return check[y][x];
		}
		
		
		int tmpy;
		int tmpx;
		int tmp;
		int max = 0;
		for(int i =0; i < 4; i++) {
			tmpy = y + dy[i];
			tmpx = x + dx[i];
			if(tmpy >= 0 && tmpy < N && tmpx >= 0 && tmpx < N && (map[y][x] + 1 == map[tmpy][tmpx])) {
				tmp = 1 + recul(tmpy, tmpx);
				
				if(max < tmp) {
					max = tmp;
				}
			}
		}
		//System.out.println(y + " " + x + " " + max);
		check[y][x] = max;
		return check[y][x];
	}
	

}
