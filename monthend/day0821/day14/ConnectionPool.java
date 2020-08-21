package com.ssafy.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	public static List<Connection> free = new ArrayList<>();
	public static List<Connection> used = new ArrayList<>();
	private static final int INIT_CNT = 3;
	//커넥션 풀 생성
	static {
		for(int i = 0; i < INIT_CNT; i++) {
			//System.out.println((i+1) + "개의 커넥션 생성");
			try {
				free.add(DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/gumidb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("데이터베이스 초기 연결 생성 중 에러 발생함");
				e.printStackTrace();
			}
		}
	}
	
	
	//생성된 커넥션을 넘겨주기
	public static Connection getConnection() throws Exception{
		if(free.isEmpty()) {
			throw new Exception("사용할수 있는 커넥션이 없습니다.");
		}
		Connection con = free.remove(0);
		used.add(con);
		return con;
	}
	
	public static void close(AutoCloseable ac) {
		try {
			ac.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//커넥션 반환
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
	
	
	public static void main(String[] args) {
		try {
			for(int i = 0; i < 10; i ++) {
				Connection con  = getConnection();
				System.out.println(con);
				Thread.sleep(1000);
				releaseConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
