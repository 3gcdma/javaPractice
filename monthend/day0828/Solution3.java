package com.ssafy.day0828;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution3 {
	private int I;
	private boolean[][] isVisited;
	private int[] knight;
	private int[] home;
	private int Answer;
	
	private int[] dx = { 1, 2, 2, 1,-1,-2,-2,-1};
	private int[] dy = {-2,-1, 1, 2, 2, 1,-1,-2};

	public static void main(String[] args) throws IOException {
		new Solution3().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		
		int T =  Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T ; test_case++) {
			I = Integer.parseInt(br.readLine());
			isVisited= new boolean[I][I];
			knight = new int[2];
			home = new int[2];
			Answer = 0;
			
			stt = new StringTokenizer(br.readLine());
			knight[0] = Integer.parseInt(stt.nextToken());
			knight[1] = Integer.parseInt(stt.nextToken());
			
			stt = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(stt.nextToken());
			home[1] = Integer.parseInt(stt.nextToken());
			
			bfs();
			
			
			System.out.println(Answer);
		}
		
		
	}

	private void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int count = 0;
		q.offer(new int[] {knight[0], knight[1]});
		isVisited[knight[0]][knight[1]] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int n = 0; n < size; n++) {
				int[] t = q.poll();
				if(t[0] == home[0] && t[1] == home[1]) {
					//while(!q.isEmpty()) q.poll();
					Answer = count;
					return;
				}
//				if(isVisited[home[0]][home[1]]) {
//					//while(!q.isEmpty()) q.poll();
//					Answer = count;
//					return;
//				}
//				int[] t = q.poll();
				
				
				for(int i = 0; i < 8; i++) {
					int ny = t[0] + dx[i];
					int nx = t[1] + dy[i];
					if(ny >= 0 && nx >= 0 && ny < I && nx < I && !isVisited[ny][nx]) {
						q.offer(new int[] {ny, nx});
						isVisited[ny][nx] = true;
					}
				}
			}
			
			count++;
		}
		
	}
}
