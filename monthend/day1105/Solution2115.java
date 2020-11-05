package com.ssafy.day1105;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2115 {
	private int N, M, C;
	private int[][] map;
	private int[][] list;
	private int[] num;
	private boolean[] isChecked;
	private int result;
	public static void main(String[] args) throws IOException {
		new Solution2115().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			stt = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stt.nextToken());
			M = Integer.parseInt(stt.nextToken());
			C = Integer.parseInt(stt.nextToken());
		
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				stt = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stt.nextToken());
				}
			}
			
			list = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N-M+1; j++) {
					num = new int[M];
					for(int k = 0; k < M; k++) {
						num[k] = map[i][j+k];
					}
					isChecked = new boolean[M];
					result = 0;
					PowerSet(0, 0);
					list[i][j] = result;
				}
			}
			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(list[i][j] +" ");
//					
//				}
//				System.out.println();
//			}
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N-M+1; j++) {
					int sum = list[i][j];
//					System.out.print(sum +" ");
					for(int y = 0; y < N; y++) {
						for(int x = 0; x < N-M+1; x++) {
							if(y == i && Math.abs(x - j) < M) continue;
							if(sum + list[y][x] > max) max = sum + list[y][x];
						}
					}
					
				}
			}
			
			System.out.println("#" +t+" " + max);
			
		}
	}

	private void PowerSet(int cnt, int sum) {
		if(cnt == M) {
			int s = 0;
			for(int i = 0; i < M; i++) {
				if(isChecked[i]) s += num[i] * num[i];
			}
			
			if(s > result) result = s;
			return;
		}
		
		if(sum + num[cnt] <= C) {
			isChecked[cnt] = true;
			PowerSet(cnt+1, sum+num[cnt]);
		}
		isChecked[cnt] = false;
		PowerSet(cnt+1, sum);
		
	}
}
