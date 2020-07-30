import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

	public static void main(String[] args) {
		Queue<int[]> q= new LinkedList<int[]>();
		int N = 20;
		int person = 1;
		
		q.offer(new int[] {1,1});
		
		while(N > 0) {
			if(!q.isEmpty()) {
				int[] p = q.poll();
				int availableCnt = (N>=p[1] ? p[1] : N);
				N -= availableCnt;
				if(N==0) {
					System.out.println("마지막 마이쮸를 가져간 사람 :" + p[0] +", 가져간개수 : " + availableCnt);
				}else {
					System.out.println(p[0] +"번이 "+ availableCnt + "개수만큼 가져갑니다. 남은 개수 : " + N);
					++p[1];
					q.offer(p); //다시 줄서기
					q.offer(new int[] {++person, 1});
				}
			}
		}
	}

}
