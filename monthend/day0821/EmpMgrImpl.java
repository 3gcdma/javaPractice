import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpMgrImpl implements EmpMgr{

	private static EmpMgrImpl instance;
	private EmpMgrImpl(){
		
	}
	
	public static EmpMgrImpl getInstance() {
		if(instance == null) instance = new EmpMgrImpl();
		return instance;
	}
	
	@Override
	public boolean insert(Employee emp) throws Exception {
		if(SQLUpdate("insert into employee values(?,?,?,?)",
				emp.getEmpNo(), emp.getName(), emp.getPosition(), emp.getDept()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> search() throws Exception {
		return SQLSelect("select * from employee");
	}

	@Override
	public Employee searchByNo(int empNo) throws Exception {
		List<Employee> list = SQLSelect("select * " + 
				 "from employee " + 
				 "where empNo Like " + "'" + empNo + "'");
		if(list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public List<Employee> searchByName(String name) throws Exception {
		return SQLSelect("select * " + 
				 "from employee " + 
				 "where name Like " + "'%" + name + "%'");
	}

	@Override
	public boolean update(int empNo, String dept) throws Exception {
		if(SQLUpdate("UPDATE employee " + 
				 "SET dept = ? " + 
				 "where empNo Like " + "'" + empNo + "'",
				 dept) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int empNo) throws Exception {
		if( SQLUpdate("delete from employee " + 
				 "where empNo Like " + "'" + empNo + "'") > 0) {
			return true;
		}
		return false;
	}
	
	public int SQLUpdate(String sql, Object...args) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = EmployeeConnectionPool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			int index = 1;
			for(Object arg : args) {
				pstmt.setObject(index++, arg);
			}
			return pstmt.executeUpdate();
		}finally {
			EmployeeConnectionPool.close(pstmt);
			EmployeeConnectionPool.releaseConnection(con);
		}
	}
	
	public List<Employee> SQLSelect(String sql, Object...args) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			con = EmployeeConnectionPool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			int index = 1;
			for(Object arg : args) {
				pstmt.setObject(index++, arg);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Employee tmp = new Employee();
				tmp.setEmpNo(rs.getInt("empNo"));
				tmp.setName(rs.getString("name"));
				tmp.setPosition(rs.getString("position"));
				tmp.setDept(rs.getString("dept"));
				list.add(tmp);
			}
			return list;
		}finally {
			EmployeeConnectionPool.close(pstmt);
			EmployeeConnectionPool.releaseConnection(con);
		}
	}
	
}
