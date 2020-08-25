import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
	private int N;
	private int[][] map;
	
	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) -'0';
			}
		}
		
		String Answer = DnQ(0, 0, N);
		if(Answer.length() > 1)
			System.out.println("(" + Answer + ")");
		else
			System.out.println(Answer);
	}

	private String DnQ(int y, int x, int var) {
		if(var == 1) return map[y][x] + "";
		
		StringBuffer sb = new StringBuffer();
		String[] q = new String[4];
		q[0] = DnQ(y, x, var/2);
		q[1] = DnQ(y, x+var/2, var/2);
		q[2] = DnQ(y+var/2, x, var/2);
		q[3] = DnQ(y+var/2, x+var/2, var/2);
		
		
		if(q[0].length() == 1 && q[0].equals(q[1]) && q[1].equals(q[2]) && q[2].equals(q[3])) {
			sb.append(q[0]);
			return sb.toString();
		}
		
		for(int i = 0; i < 4; i++) {
			if(q[i].length() > 1) {
				sb.append("(");
				sb.append(q[i]);
				sb.append(")");
			}else {
				sb.append(q[i]);
			}
		}
		
		
		
		
		return sb.toString();
	}
}