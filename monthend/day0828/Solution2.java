package com.ssafy.day0828;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private int N;
	private int[][] map;
	private int[] num;
	private boolean[] isChecked;
	private int Answer;

	public static void main(String[] args) throws IOException {
		new Solution2().start();
	}

	private void start() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			Answer = 999999;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			num = new int[N];
			isChecked = new boolean[N];

			for(int i = 0; i < N; i++) {
				stt = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stt.nextToken());					
				}
			}
			
			combination(0, 0);
			System.out.println("#"+test_case + " " +Answer);
		}
	}

	private void combination(int cnt, int cur) {
		if(cnt == N/2) {
			
			sinerge();
			return;
		}
		
		for(int i = cur; i < N; i++) {
			num[cnt] = i;
			isChecked[i] =true;
			combination(cnt+1, i+1);
			isChecked[i] =false;

		}
		
		
	}

	private void sinerge() {
		int foodA = 0;
		int foodB = 0;
		int diff = 0;
		
		
//		for(int i = 0; i< N; i++) {
//			System.out.print(num[i] +" ");
//		}
//		System.out.println();
		
		int count = N/2;
		for(int j = 0; j < N; j++) {
			if(!isChecked[j]) {
				num[count++] = j;
			}
		}
		
//		for(int i = 0; i< N; i++) {
//			System.out.print(num[i] +" ");
//		}
//		System.out.println();
		
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				if(i == j) continue;
				foodA += map[num[i]][num[j]];
			}
		}
		
		for(int i = N/2; i < N; i++) {
			for(int j = N/2; j < N; j++) {
				if(i == j) continue;
				foodB += map[num[i]][num[j]];
			}
		}
		//System.out.println(foodA + " " + foodB);
		diff = Math.abs(foodA - foodB);
		if(Answer > diff) Answer = diff;
	}
}
