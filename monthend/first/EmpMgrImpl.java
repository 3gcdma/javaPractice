import java.util.Arrays;

public class EmpMgrImpl {

    /** 직원정보를 저장하기 위한 배열 */
	private Employee[] emps= new Employee[100];
	/** 저장된 직원 정보의 갯수를 기억하는 변수 */
	private  int index=0;
		
	private static EmpMgrImpl instance;
	

	private EmpMgrImpl() {
		
	}
	
	public static EmpMgrImpl getInstance() {
		if(instance == null) {
			instance = new EmpMgrImpl();
		}
		return instance;
	}
	/** 직원 정보를 저장하는 메서드 */
	public void add(Employee b) {
    	// 구현 하세요.
		if(index == emps.length) {
			emps = Arrays.copyOf(emps, index * 2);
		}
		emps[index++] = b;
		
	}

	/** 모든 직원 정보를 리턴하는 메서드 */
    public Employee[]  search(){
    	Employee[]  newemps = new Employee[index];
    	
    	// 구현 하세요.
    	newemps = Arrays.copyOfRange(emps, 0, index);
 
    	return newemps;
    }

	/** 저장된 직원정보 중 직원번호를 검색하여 리턴하는 메서드 */
	public Employee search(int empNo) {


    	// 구현 하세요.
    	for(int i = 0; i < index; i++) {
    		if(emps[i].getEmpNo() == empNo) {
    			return emps[i];
    		}
    	}
		
		return null;
	}
    
	/** 저장된 직원정보 중 직원이름을 검색하여 리턴하는 메서드 */
	public Employee[]  search(String name){
    	Employee[]  newemps = null;
    	int idx = 0;
    	// 구현 하세요.
    	for(int i = 0; i < index; i++) {
    		if(emps[i].getName().equals(name)) {
    			idx++;
    		}
    	}
    	newemps = new Employee[idx];
    	idx = 0;
    	for(int i = 0; i < index; i++) {
    		if(emps[i].getName().equals(name)) {
    			newemps[idx++] = emps[i];
    		}
    	}
	    return newemps;
	}
    
	/** 저장된 직원정보 중 직원번호를 검색하여 부서를 수정하는 메서드 */
	public boolean update(int empNo, String dept)  {


    	// 구현 하세요.
		for(int i = 0; i < index; i++) {
    		if(emps[i].getEmpNo() == empNo) {
    			emps[i].setDept(dept);
    			return true;
    		}
    	}
		
		return false;
	}

	/** 저장된 직원정보 중 직원번호를 검색하여 직원을 삭제하는 메서드 */
	public boolean delete(int empNo) {
		int idx;
    	// 구현 하세요.
		for(int i = 0; i < index; i++) {
    		if(emps[i].getEmpNo() == empNo) {
    			idx = index - i + 1;
    			System.arraycopy(emps, i+1, emps, i, idx);
    			emps[index--] = null;
    			return true;
    		}
    	}
		return false;
	}
}
