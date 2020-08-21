import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeConnectionPool {
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();
	private static final int INIT_CNT = 3;
	
	
	static {
		for(int i = 0; i < INIT_CNT; i++) {
			try {
				free.add(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeedb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","root","1234"));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("데이터베이스 초기 생성 에러");
			}
		}
	}
	
	public static Connection getConnection() throws Exception {
		if(free.isEmpty()) {
			throw new Exception("사용할 수 있는 커넥션 없음");
		}
		Connection con = free.remove(0);
		used.add(con);
		return con;
	}
	
	public static void close( AutoCloseable ac) {
		try {
			ac.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
}
