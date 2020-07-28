import java.util.Scanner;

public class EmpMain {
	Scanner s=new Scanner(System.in);
	EmpMgrImpl mgr= EmpMgrImpl.getInstance();  

	public static void main(String[] args) {
		EmpMain m=new EmpMain();
		int num=0;
		while(true) {
			num=m.menu();
			if(num==0) break;
			switch (num){
				case 1:
					m.insert();
					break;
				case 2:
					m.search();
					break;
				case 3:
					m.searchNum();
					break;
				case 4:
					m.searchName();
					break;
				case 5:
					m.update();
					m.search();
					break;
				case 6:
					m.delete();
					m.search();
					break;
				default:
					System.err.println("메뉴 번호를 정확히 입력해 주세요.");
				    continue;
			}
			
		}
	}
	public  int menu() {
		int result=0;
		System.out.println("==================================");
		System.out.println("========== 직원 관리 프로그램 ==========");
		System.out.println("==================================");
		System.out.println("1. 직원 등록");
		System.out.println("2. 직원 목록 보기");
		System.out.println("3. 직원 검색(사번으로 검색)");
		System.out.println("4. 직원 검색(이름으로 검색)");
		System.out.println("5. 직원 수정");
		System.out.println("6. 직원 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택 하세요.");

		result=s.nextInt();

		return result;
		
	}
    public void insert() {
    	System.out.println("직원 정보를 입력하세요. 형식:사번(숫자4자리),이름,직위,부서");
    	String[] info=s.next().split(",");

		mgr.add(new Employee(Integer.parseInt(info[0]), info[1], info[2], info[3]));

    }
    public void search() {
    	System.out.println(">>>>>>>>  직원 목록 보기 ");
    	Employee[] emps=mgr.search();
    	if(emps.length == 0) {
    		System.err.println("직원 정보가 없습니다.");
    		return;
    	}
    	for(Employee e: emps) {
    		System.out.println(e);
    	}
    }
    public void searchNum() {
    	System.out.println(">>>>>>>>  직원  검색 (사번으로 검색) ");
    	System.out.println("검색하고자하는 사번을 입력하세요.");
    	int snum=s.nextInt();
    	Employee e = mgr.search(snum);
    	if(e !=null)
			System.out.println(e);
    	else
    		System.err.println("검색 실패~~~ 사번을 확인하세요.");
 
    }
    public void searchName() {
    	 	
    	System.out.println(">>>>>>>>  직원  검색 (이름으로 검색) ");
    	System.out.println("검색하고자하는 이름을 입력하세요.");
    	s.nextLine();
    	String name = s.nextLine();
    	Employee[] emps=mgr.search(name);
    	if(emps.length == 0) {
    		System.err.println("검색 하고자 하는 이름의 직원 정보가 없습니다.");
    		return;
    	}
    	for(Employee e: emps) {
    		System.out.println(e);
    	}

    }
    public void update() {
    	System.out.println(">>>>>>>>  직원  수정 ");
    	System.out.println("수정하고자하는 사번,부서을 입력하세요.");
    	String[] info=s.next().split(",");
    	boolean flag=mgr.update(Integer.parseInt(info[0]), info[1]);
		if(flag)
			System.out.println("정상적으로 수정되었습니다.");
		else
			System.err.println("수정 실패~~~  사번을 확인 하세요.");

    }
    public void delete() {
    	System.out.println(">>>>>>>>  직원 삭제 ");
    	System.out.println("삭제하고자하는 사번을 입력하세요.");
    	int snum=s.nextInt();
    	boolean flag = mgr.delete(snum);
		if(flag)
			System.out.println("정상적으로 수정되었습니다.");
		else
			System.err.println("삭제 실패~~~  사번을 확인 하세요.");
    	
    }
 
}
