package com.ssafy.day1106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution15685 {
	private int N;
	private boolean[][] map;
	private int Y, X, dir, gen;
	private int[] dy = {0,-1,0,1};
	private int[] dx = {1,0,-1,0};
	private int Answer;
	public static void main(String[] args) throws IOException {
		new Solution15685().start();
	}

	private void start() throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;

		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		
		for(int n = 0; n < N; n++) {
			stt = new StringTokenizer(br.readLine());
			X = Integer.parseInt(stt.nextToken());
			Y = Integer.parseInt(stt.nextToken());
			dir = Integer.parseInt(stt.nextToken());
			gen = Integer.parseInt(stt.nextToken());
			map[Y][X] = true;
			Answer = 0;
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(dir);
			Y += dy[dir];
			X += dx[dir];
			map[Y][X] = true;
			//System.out.println(Y + " " + X);
			for(int g = 0;g < gen; g++) {
				int size = list.size();
				for(int i = size-1; i >= 0; i--) {
					int tempDir = (list.get(i) + 1) % 4;
					
					Y += dy[tempDir];
					X += dx[tempDir];
					//System.out.println(Y + " " + X);
					map[Y][X] = true;
					list.add(tempDir);
				}
			}
			
//					for(int i = 0; i < 10; i++) {
//						for(int j = 0; j < 10; j++) {
//							System.out.print(map[i][j] +"\t");
//						}
//						System.out.println();
//					}
//					System.out.println();

		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					Answer++;
			}
		}
		System.out.println(Answer);
	}
}
