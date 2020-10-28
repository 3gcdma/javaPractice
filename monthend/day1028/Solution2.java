package com.ssafy.day1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private int N;
	private int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution2().start();
	}

	private void start() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			 stt = new StringTokenizer(br.readLine());
			 
			 N = Integer.parseInt(stt.nextToken());
			 map = new int[N][N];
			 String dir = stt.nextToken();
			 
			 for(int i = 0; i < N; i++) {
				 stt = new StringTokenizer(br.readLine());
				 for(int j = 0; j < N; j++) {
					 map[i][j] = Integer.parseInt(stt.nextToken());
				 }
			 }
			 
			 
			 if(dir.equals("up")) {
				 moveup();
			 }
			 else if(dir.equals("down")) {
				 movedown();
			 }else if(dir.equals("left")) {
				 moveleft();
			 }else {
				 moveright();
			 }
			System.out.println("#"+t+" "); 
			print();
		}
	}

	private void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void moveup() {
		int target;
		for(int j = 0; j < N; j++) {
			target = 0;
			for(int i = 0; i < N; i++) {
				if(map[i][j] != 0) {
					map[target][j] = map[i][j];
					if(i != target) map[i][j] = 0;
					target++;
				}
				
			}
		}
		for(int j = 0; j < N; j++) {
			for(int i = 1; i < N; i++) {
				if(map[i][j] == map[i-1][j] && map[i][j] != 0) {
					map[i-1][j] *= 2;
					map[i][j] = 0;
				}
			}
		}
		for(int j = 0; j < N; j++) {
			target = 0;
			for(int i = 0; i < N; i++) {
				if(map[i][j] != 0) {
					map[target][j] = map[i][j];
					if(i != target) map[i][j] = 0;
					target++;
				}
				
			}
		}
	
	}
	
	private void movedown() {
		int target;
		for(int j = 0; j < N; j++) {
			target = N-1;
			for(int i = N-1; i >= 0; i--) {
				if(map[i][j] != 0) {
					map[target][j] = map[i][j];
					if(i != target) map[i][j] = 0;
					target--;
				}
				
			}
		}
		for(int j = 0; j < N; j++) {
			for(int i = N-2; i >=0; i--) {
				if(map[i][j] == map[i+1][j] && map[i][j] != 0) {
					map[i+1][j] *= 2;
					map[i][j] = 0;
				}
			}
		}
		for(int j = 0; j < N; j++) {
			target = N-1;
			for(int i = N-1; i >= 0; i--) {
				if(map[i][j] != 0) {
					map[target][j] = map[i][j];
					if(i != target) map[i][j] = 0;
					target--;
				}
				
			}
		}
	
	}
	
	private void moveleft() {
		int target;
		for(int i = 0; i < N; i++) {
			target = 0;
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					map[i][target] = map[i][j];
					if(j != target) map[i][j] = 0;
					target++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(map[i][j] == map[i][j-1] && map[i][j] != 0) {
					map[i][j-1] *= 2;
					map[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			target = 0;
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					map[i][target] = map[i][j];
					if(j != target) map[i][j] = 0;
					target++;
				}
			}
		}
	
	}
	
	private void moveright() {
		int target;
		for(int i = 0; i < N; i++) {
			target = N-1;
			for(int j = N-1; j >= 0; j--) {
				if(map[i][j] != 0) {
					map[i][target] = map[i][j];
					if(j != target) map[i][j] = 0;
					target--;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = N-2; j >= 0; j--) {
				if(map[i][j] == map[i][j+1] && map[i][j] != 0) {
					map[i][j+1] *= 2;
					map[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			target = N-1;
			for(int j = N-1; j >= 0; j--) {
				if(map[i][j] != 0) {
					map[i][target] = map[i][j];
					if(j != target) map[i][j] = 0;
					target--;
				}
			}
		}
	
	}
	
}
