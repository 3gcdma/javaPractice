import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T+1];
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			arr[i] = Integer.parseInt(stt.nextToken());
		}
		int man = Integer.parseInt(br.readLine());
		int sex, target;
		for(int i = 0; i < man; i++) {
			stt = new StringTokenizer(br.readLine());
			sex = Integer.parseInt(stt.nextToken());
			target = Integer.parseInt(stt.nextToken());
			
			if(sex ==   1) {
				for(int j = target; j <= T; j+=target) {
					if(arr[j] == 1) arr[j] = 0;
					else if(arr[j] == 0) arr[j] = 1;
				}
			}else {
				if(target != T && target != 1) {
					int left = target, right = target;
					while(arr[left] == arr[right]) {
						left--;
						right++;
						if(left <= 0 || right > T) {
							break;
						}
					}
					for(int j = left + 1; j < right; j++) {
						if(arr[j] == 1) arr[j] = 0;
						else if(arr[j] == 0) arr[j] = 1;
					}
				}else {
					if(arr[target] == 1) arr[target] = 0;
					else if(arr[target] == 0) arr[target] = 1;
				}
				
				
			}
			
		}
		
		int tmp = 1;
		while(T - tmp >= 20) {
			for(int k = 0; k < 20; k++, tmp++ ) {
				System.out.print(arr[tmp] + " ");
			}
			System.out.println();
		}
		//System.out.println(tmp);
		for(int k = tmp ; k <= T; k++) {
			System.out.print(arr[k] + " ");
		}
		
		
		
	}
}
