package day0401;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1230 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		LinkedList<Integer> list = new LinkedList<>();
		int N,C;
		
		for(int t = 1; t <= 10; t++) {
			list = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			
			stt = new StringTokenizer(br.readLine());
			for(int i = 0; i < N ; i++) {
				list.add(Integer.parseInt(stt.nextToken()));
			}

			C = Integer.parseInt(br.readLine());
			
			stt = new StringTokenizer(br.readLine());
			for(int i = 0; i < C ; i++) {
				char cases = stt.nextToken().charAt(0);
				int x, y;
				
				
				switch (cases) {
				case 'I':
					x = Integer.parseInt(stt.nextToken());
					y = Integer.parseInt(stt.nextToken());
					
					for(int j = 0; j < y ; j++) {
						list.add(x++,Integer.parseInt(stt.nextToken()));
					}
					
					break;
				case 'D':
					x = Integer.parseInt(stt.nextToken());
					y = Integer.parseInt(stt.nextToken());
					
					for(int j = 0; j < y ; j++) {
						list.remove(x+1);
					}
					break;
				case 'A':
					y = Integer.parseInt(stt.nextToken());
					for(int j = 0; j < y ; j++) {
						list.addLast(Integer.parseInt(stt.nextToken()));
					}
					break;

				default:
					System.out.println("ERRER");
					break;
				}
				
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0 ; i < 10; i++) {
				System.out.print(list.get(i) +" ");
			}
			System.out.println();
			
		}
	}
}
