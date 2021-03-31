import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * 리뷰
 * 첫번째 시도 : 성공
 *  이유 : BigInteger 처음 사용, 너무 먼 길로 돌아갔음( BigInteger(숫자, 진법) / Num.toString(진법) ) 사용 가능), 꼭 다시 해보기 
 */
public class JO3116_bigint {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		BigInteger A, B;
		String number;
		BigInteger change;
		BigInteger zero = new BigInteger("0");
		
		while(true) {
			stt = new StringTokenizer(br.readLine());
			
			A = new BigInteger(stt.nextToken());
			
			if(A.compareTo(zero) == 0) break;
			
			number = stt.nextToken();
			B = new BigInteger(stt.nextToken());
			
			change = new BigInteger("0");
			
			//a -> 10
			BigInteger countA = new BigInteger("1");
			
			for(int i = number.length()-1; i >= 0 ; i--) {
				int n = number.charAt(i);
				if(n >= 48 && n <=57) {
					n -= 48 ;
				}else {
					n -= 55 ;
				}
				BigInteger tmp = new BigInteger(n+"").multiply(countA);
				change = change.add(tmp);
				//System.out.println(change.toString());
				countA = countA.multiply(A);
				
			}
			
			//System.out.println(change.toString());
			
			//10 -> b
			
			StringBuffer sb = new StringBuffer();
			
			BigInteger countB = new BigInteger(""+B);
			
			while(change.compareTo(zero) != 0) {
				char tmp;
				int n = change.remainder(countB).intValue();
				
				if(n >= 0 && n <=9) {
					tmp = (char) (n+48);
				}else {
					tmp =(char) (n+55);
				}
				
				//System.out.println(n + " " +tmp);
				sb.insert(0, tmp);
				
				change = change.divide(countB);
			}
			
			System.out.println(sb.toString());
		}

	}

}
