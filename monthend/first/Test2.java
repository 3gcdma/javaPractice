import java.io.FileInputStream;
import java.util.Scanner;

public class Test2 {
	static long Answer;
	static int[][] map;
	static int N, S;
	
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0 ,1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void calc(int y, int x, int power) {
		for(int i = 0; i < 8; i++) {
			for(int j = y + dy[i], k = x + dx[i], c = 0; j > 0 && j <= N && k > 0 && k <= N && c < power; j+=dy[i], k+=dx[i], c++) {
				map[j][k]++;
			}
		}
		map[y][x]++;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Test2.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++){
			Answer = 0;
			N=sc.nextInt(); 
			map = new int[N+1][N+1];
			S=sc.nextInt();
			int[][] stone=new int[S][3];
			for(int i=0; i<S; i++){
				stone[i][0]=sc.nextInt();
			}
			
			for(int i=0; i<S; i++){
				stone[i][1]=sc.nextInt();
				stone[i][2]=sc.nextInt();
			}
			

			for(int i = 0; i < S; i++) {
				calc(stone[i][1], stone[i][2], stone[i][0]);
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j<= N; j++) {
					if(Answer < map[i][j]) Answer = map[i][j];
					//System.out.print(map[i][j]+ " ");
				}
				//System.out.println();
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
