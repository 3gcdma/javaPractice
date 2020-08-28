package com.ssafy.day0828;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4 {
	private int N, D, K, C;
	private int[] velt;
	private int[] cases;
	private Queue<Integer> q = new LinkedList<>();
	int max; 
	int count;
	
	public static void main(String[] args) throws IOException {
		new Solution4().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stt.nextToken());  
		D = Integer.parseInt(stt.nextToken());  
		K = Integer.parseInt(stt.nextToken());  
		C = Integer.parseInt(stt.nextToken());  
		velt = new int[N + K];
		max = 0;
		count = 0;
		cases = new int[D+1];
		
		
		for(int i = 0; i < N; i++) {
			velt[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 0; i < K; i++) {
			velt[N+i] = velt[i];
		}
		
		for(int i = 0; i < K; i++) {
			q.offer(velt[i]);
			if(cases[velt[i]]++ == 0) {
				count++;
			}
		}
		
		totalcount(count);
		
		
		for(int i = K; i < N+K; i++) {
			int tmp = q.poll();
			
			if(--cases[tmp] == 0) {
				count--;
			}
			
			q.offer(velt[i]);
			if(cases[velt[i]]++ == 0) {
				count++;
			}

			totalcount(count);
		}
		
		System.out.println(max);
		
	}

	private void totalcount(int c) {
		if(cases[C] == 0) {
			c++;
		}
		
		if(max < c) max = c;
	}
}
