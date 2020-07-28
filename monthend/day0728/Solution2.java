import java.io.FileInputStream;
import java.util.Scanner;

public class Solution2 {
	
	private static int Answer;
	private static int[][] map = new int[100][100];
	
	private static int[] dx = {-1, 1};
	
	private static void up(int y, int x) {
		boolean switchs = true;
		int tmpx = x;
		int tmpy = y;
		int d = 1;

		Label :
		while(true) {
			if(tmpy == 0) {
				Answer = tmpx;
				break;
			}
			
			if(switchs) {
				for(int i = 0; i < 2; i++) {
					if((tmpx + dx[i]) >= 0 && (tmpx + dx[i]) < 100 && map[tmpy][tmpx+dx[i]] == 1) {
						switchs = false;
						d = dx[i];
						tmpx += dx[i];
						continue Label;
					}
				}
				tmpy -= 1;
			}else {
				if( map[tmpy - 1][tmpx] == 1) {
					switchs = true;
					tmpy -= 1;
					continue;
				}
				tmpx += d;
			}
		}
		
	}
	
	private static void horizon(int y, int x, int dx) {
		
	}
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다. 
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("input2.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T = sc.nextInt();
			sc.nextLine();
			
			for(int i = 0 ; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 100; i++) {
				if(map[99][i] == 2) {
					up(98, i);
					break;
				} 
			}
			
			System.out.println("#"+ T + " " + Answer);
		}
	}
}
