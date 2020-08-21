import java.util.List;

public interface EmpMgr {
	public boolean insert(Employee emp) throws Exception;
	public List<Employee> search()throws Exception;
	public Employee searchByNo(int empNo)throws Exception;
	public List<Employee> searchByName(String name)throws Exception;
	public boolean update(int empNo, String dept)throws Exception;
	public boolean delete(int empNo)throws Exception;
}
