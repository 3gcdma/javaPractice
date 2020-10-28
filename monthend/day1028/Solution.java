package com.ssafy.day1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private int N, M;
	private int Answer;
	private int[][] map;
	private boolean[][] isChecked;
	private int[] dx = {0,0,-1,1};
	private int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		new Solution().start();
	}

	private void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stt.nextToken());
		M = Integer.parseInt(stt.nextToken());
		map = new int[N][M];
		Answer = 0;
		for(int i = 0; i < N; i++) {
			stt= new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
			}
		}
		int count = 0;
		
		while(true) {
			int c = isMT();
			if(c == 0) break;
			else {
				Answer = c;
			}
			bfs();
//			print();
			erase();
			count++;
//			print();
		}
		System.out.println(count);
		System.out.println(Answer);
		
		
		
	}

	private void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private int isMT() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) count++;
			}
		}
		return count;
	}

	private void erase() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) map[i][j] = 0;
			}
		}
	}

	private void bfs() {
		Queue<int[]> q = new LinkedList<>();
		isChecked = new boolean[N][M];
		
		q.offer(new int[] {0,0});
		isChecked[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				
				if(ny < 0 || nx < 0|| ny >= N || nx >= M) continue;
				if(isChecked[ny][nx]) continue;
				
				isChecked[ny][nx] = true;
				if(map[ny][nx] == 0) {
					q.offer(new int[] {ny, nx});
				}else {
					map[ny][nx] = 2;
				}
			}
		}
	}
}














