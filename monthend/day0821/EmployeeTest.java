import java.util.List;
import java.util.Scanner;

public class EmployeeTest {
	private Scanner sc = new Scanner(System.in);
	private EmpMgrImpl mgr = EmpMgrImpl.getInstance();
	
	public static void main(String[] args) {
		EmployeeTest et = new EmployeeTest();
		et.start();
	}

	private void start() {
		System.out.println("<<< s회사 직원 관리 프로그램  >>> ");

		while(true) {
			int menu = showMenu();
			switch(menu) {
			case 1:
				//상품 정보 저장
				insert();
				break;
			case 2:
				//상품 전체 정보 검색
				searchAll();
				break;
			case 3:
				//상품명 검색 ( 상품명을 포함한 모든 상품의 정보)
				searchNum();
				break;
			case 4:
				//상품 가격 검색 ( 상품 가격을 입력하면 그 가격이하의 모든 상품 정보 보여줌)
				searchName();
				break;
			case 5:
				//제품 번호로 검색
				update();
				break;
			case 6:
				//제품 번호로 삭제
				delete();
				break;
			case 0:
				System.out.println("종료합네다");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 선택입네다. 다시 고루시라우요");
			}
		}
	}
	
	private void delete() {
		System.out.println("사원 번호로 삭제 하기");

		try {
			if(!mgr.delete((getInteger("사원 번호 : ")))){
				System.out.println("사원이 존재하지 않습니다. !!");
			}else {
				System.out.println("삭제가 완료되었습니다.!!");
			}
		} catch (Exception e) {
			System.out.println("사원이 존재하지 않습니다. !!");
			e.printStackTrace();
		}
		System.out.println("------------------------------");
	}

	private void update() {
		System.out.println("사원 정보 업데이트");
		
		int empNo = getInteger("사원 번호 : ");
		String dept = getString("변경할 부서  : ");
		try {
			if(mgr.update(empNo, dept)) {
				System.out.println("변경에 성공하였습니다.");
			}else {
				System.out.println("변경 실패, 넣으신 내용을 확인하세요");
			}
		} catch (Exception e) {
			System.out.println("변경 실패, 넣으신 내용을 확인하세요");
			e.printStackTrace();
		}
		System.out.println("------------------------------");
	}

	private void searchName() {
		System.out.println("사원 이름으로 검색 하기");
		List<Employee> list;
		try {
			list = (List<Employee>) mgr.searchByName(getString("사원 이름 : "));
			if(list == null || list.size() == 0) {
				System.out.println("사원을 찾을수 없습니다."); 
			}else{
				System.out.println(list); 
			}
		} catch (Exception e) {
			System.out.println("사원을 찾을수 없습니다.");
			e.printStackTrace();
		}
		
		System.out.println("------------------------------");
	}

	private void searchNum() {
		System.out.println("상품 번호로 검색 하기");
		Employee employee;
		try {
			employee = mgr.searchByNo(getInteger("사원 번호 : "));
			if(employee == null) {
				System.out.println("사원을 찾을수 없습니다."); 
			}else{
				System.out.println(employee); 
			}
		} catch (Exception e) {
			System.out.println("사원을 찾을수 없습니다."); 
			e.printStackTrace();
		}
		
		System.out.println("------------------------------");
	}

	private void searchAll() {
		System.out.println("모든 사원 정보 출력");
		try {
			printProduct(mgr.search());
		} catch (Exception e) {
			System.out.println("사원을 찾을수 없습니다."); 
			e.printStackTrace();
		}
		System.out.println("------------------------------");
		
	}
	
	private void printProduct(List<Employee> list) {
		System.out.println("------------------------------");
		for(Employee p : list) {
			System.out.println(p);
		}
	}

	private void insert() {
		System.out.println("상품 정보 입력");
		
		int empNo = getInteger("사원 번호 : ");
		String name = getString("사원 이름 : ");
		String position = getString("직급 : ");
		String dept = getString("부서 : ");

		try {
			if(!mgr.insert(new Employee(empNo, name, position, dept))) {
				System.out.println("상품 정보를 등록할 수가 없습니다.");
			}else {
				System.out.println("상품 정보가 등록되었습니다.");
			}
		} catch (Exception e) {
			System.out.println("상품 정보를 등록할 수가 없습니다.");
			e.printStackTrace();
		}
	}

	private int showMenu() {
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("1.사원 정보 저장 ");
		System.out.println("2.사원 전체 검색 ");
		System.out.println("3.사원번호로 사원 검색  ");
		System.out.println("4.사원 이름으로 사원 검색");
		System.out.println("5.사원 정보 변경 ");
		System.out.println("6.사원 정보 삭제 ");
		System.out.println("0.종료 ");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.print("원하는 번호를 선택하세요. : ");
		return Integer.parseInt(sc.nextLine());
		
	}
	
	private int getInteger(String text) {
		return Integer.parseInt(getString(text));
	}


	private String getString(String text) {
		System.out.print(text);
		return sc.nextLine();
	}
}
