import java.util.List;
import java.util.Scanner;

public class ProductTest {
	
	private ProductDAOImpl mgr = ProductDAOImpl.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ProductTest pt = new ProductTest();
		pt.start();
	}

	
	
	private void start() {
		
		System.out.println("<<< abc 전자 대리점 관리 프로그램 >>> ");

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
				searchName();
				break;
			case 4:
				//상품 가격 검색 ( 상품 가격을 입력하면 그 가격이하의 모든 상품 정보 보여줌)
				searchPrice();
				break;
			case 5:
				//제품 번호로 검색
				searchNum();
				break;
			case 6:
				//제품 번호로 삭제
				delete();
				break;
			case 7:
				//제품번호와 가격으로 같은 번호를 같아 가격 업데이트 
				update();
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



	private void update() {
		System.out.println("상품 정보 업데이트");
		
		String num = getString("상품 번호 : ");
		int price = getInteger("상품 변경할 가격 : ");
		if(mgr.updateProduct(new Product(num, null, price, 0, 0, 0, "")) > 0) {
			System.out.println("변경에 성공하였습니다.");
		}else {
			System.out.println("변경 실패, 넣으신 내용을 확인하세요");
		}
		System.out.println("------------------------------");
		
	}


	private int showMenu() {
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("1.상품 정보 저장 ");
		System.out.println("2.상품 정보 전체 검색 ");
		System.out.println("3.상품명으로 검색  ");
		System.out.println("4.상품 가격으로 검색");
		System.out.println("5.상품 번호로 검색 ");
		System.out.println("6.상품 번호로 삭제 ");
		System.out.println("7.지정 상품 가격 변경  ");
		System.out.println("0.종료 ");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.print("원하는 번호를 선택하세요. : ");
		return Integer.parseInt(sc.nextLine());
		
	}

	
	private void delete() {
		System.out.println("상품 번호로 삭제 하기");

		if(mgr.deleteProduct((getString("상품 번호 : "))) <= 0){
			System.out.println("해당 번호의 상품이 없습니다. 다시 확인해 주세요 !!");
		}else {
			System.out.println("삭제가 완료되었습니다.!!");
		}
		System.out.println("------------------------------");
	}
	
	private void searchPrice() {
		System.out.println("상품 가격으로 검색 하기");
		List<Product> list = (List<Product>) mgr.selectProductByPrice(getInteger("상품 가격 : "));
		if(list == null || list.size() == 0) {
			System.out.println("상품을 찾을수 없습니다."); 
		}else{
			System.out.println(list); 
		}
		System.out.println("------------------------------");
	}
	
	private void searchName() {
		System.out.println("상품 이름으로 검색 하기");
		List<Product> list = (List<Product>) mgr.selectProductByName(getString("상품 이름 : "));
		if(list == null || list.size() == 0) {
			System.out.println("상품을 찾을수 없습니다."); 
		}else{
			System.out.println(list); 
		}
		System.out.println("------------------------------");
	}
	
	
	private void searchNum() {
		System.out.println("상품 번호로 검색 하기");
		Product product = mgr.selectProductByNum(getString("상품 번호 : "));
		if(product == null) {
			System.out.println("상품을 찾을수 없습니다."); 
		}else{
			System.out.println(product); 
		}
		System.out.println("------------------------------");
	}

	private void searchAll() {
		System.out.println("모든 상품 정보 출력");
		printProduct(mgr.selectProduct());
		System.out.println("------------------------------");
	}


	private void printProduct(List<Product> list) {
		System.out.println("------------------------------");
		for(Product p : list) {
			System.out.println(p);
		}
	}
	
	private void insert() {
		System.out.println("상품 정보 입력");

		String num = getString("제품번호 : ");
		String name = getString("제품명 : ");
		int price = getInteger("상품 가격 : ");
		int amount = getInteger("상품 재고 : ");
		String gubun = getString ("선택( TV (T), 냉장고 (R) ) : ");
		int inch = 0;
		int liter = 0;
		
		if(gubun.equals("T")) {
			inch = getInteger("TV 크기 : ");
		}else {
			liter = getInteger("냉장고 용량 : ");
		}
		
		int result = mgr.insertProduct(new Product(num, name, price, amount, inch, liter, gubun));
		if(result <= 0) {
			System.out.println("상품 정보를 등록할 수가 없습니다.");
		}else {
			System.out.println("상품 정보가 등록되었습니다.");
		}
	}

	private int getInteger(String text) {
		return Integer.parseInt(getString(text));
	}


	private String getString(String text) {
		System.out.print(text);
		return sc.nextLine();
	}



}