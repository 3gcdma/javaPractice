import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		double a = Double.parseDouble(stt.nextToken());
		double b = Double.parseDouble(stt.nextToken());
		
		System.out.println(a/b);
	}

}
