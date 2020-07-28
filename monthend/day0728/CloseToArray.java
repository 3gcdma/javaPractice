public class CloseToArray {
	private static int Answer = 0;
	private static int[][] map = new int[5][5];
	private static int[][] abs = new int[5][5];
	private static int N = 5;
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	
	
	public static void list(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int j = y + dy[i];
			int k = x + dx[i]; 
			if(j >=0 && j < N && k >=0 && k < N) {
				Answer += Math.abs(map[j][k] - map[y][x]);
				abs[y][x] += Math.abs(map[j][k] - map[y][x]);
			}
		}
	}
	public static void main(String[] args) {
		
		boolean[] check = new boolean[26];
		int temp;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				while(true) {
					temp = (int) ((Math.random() * 25) + 1);
					if(!check[temp]) break;
				}
				map[i][j] = temp;
				check[temp] = true;
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				list(i, j);
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(abs[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println(Answer);
	}

}
