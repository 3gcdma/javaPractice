
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution3 {
	public static void main(String args[]) throws Exception
	{
		new Solution3().start();
	}
	
	
	private void start() {
		try {
			System.setIn(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			boolean iszero = false;
			
			
			sc.nextLine();
			for(int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			sc.nextLine();
			while(!iszero) {
				int tmp;
				for(int i = 1; i <=5; i++) {
					tmp = q.poll();
					tmp -= i;
					if(tmp <= 0) {
						iszero = true;
						tmp = 0;
						q.offer(tmp);
						break;
					}
					q.offer(tmp);
				}
			}
			
			System.out.print("#" + test_case + " ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	
	}

}
