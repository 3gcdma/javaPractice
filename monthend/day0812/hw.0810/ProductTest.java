import java.util.Scanner;

import com.ssafy.ws.step06.Book;
import com.ssafy.ws.step06.Megazine;

public class ProductTest {
	
	private ProductMgr mgr = ProductMgr.getInstance();
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
				input();
				break;
			case 2:
				searchAll();
				break;
			case 3:
				searchNum();
				break;
			case 4:
				searchName();
				break;
			case 5:
				searchTV();
				break;
			case 6:
				searchRef();
				break;
			case 7:
				delete();
				break;
			case 8:
				totalPrice();
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



	private int showMenu() {
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("1.상품 입력 ");
		System.out.println("2.상품 정보 전체 검색 ");
		System.out.println("3.상품 번호 검색 ");
		System.out.println("4.상품명으로 검색 ");
		System.out.println("5.TV만 검색 ");
		System.out.println("6.냉장고만 검색 ");
		System.out.println("7.상품 삭제 ");
		System.out.println("8.전체 상품 재고 금액 검색");
		System.out.println("0.종료 ");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.print("원하는 번호를 선택하세요. : ");
		return Integer.parseInt(sc.nextLine());
		
	}
	

	private void totalPrice() {
		System.out.println("전체 상품 재고 금액 조회 하기");
		System.out.println("------------------------------");
		System.out.println("전체 재고 상품 총 가격 : " + mgr.totalPrice());
		System.out.println("------------------------------");
	}

	
	
	private void delete() {
		System.out.println("상품 번호로 삭제 하기");
		if(!mgr.delete(getString("상품 번호 : "))){
			System.out.println("해당 번호의 상품이 없습니다. 다시 확인해 주세요 !!");
		}else {
			System.out.println("삭제가 완료되었습니다.!!");
		}
		System.out.println("------------------------------");
	}

	
	private void searchRef() {
		System.out.println("모든 냉장고 상품 정보 출력");
		printProduct(mgr.searchRef());
		System.out.println("------------------------------");
	}
	
	private void searchTV() {
		System.out.println("모든 TV 상품 정보 출력");
		printProduct(mgr.searchTV());
		System.out.println("------------------------------");
	}
	
	
	private void searchName() {
		System.out.println("상품 이름으로 검색 하기");
		System.out.println(mgr.searchProductNum(getString("상품 이름 : "))); 
		System.out.println("------------------------------");
	}
	
	
	private void searchNum() {
		System.out.println("상품 번호로 검색 하기");
		System.out.println(mgr.searchProductNum(getString("상품 번호 : "))); 
		System.out.println("------------------------------");
	}

	private void searchAll() {
		System.out.println("모든 상품 정보 출력");
		printProduct(mgr.searchAll());
		System.out.println("------------------------------");
	}

	private void printProduct(Product[] list) {
		System.out.println("------------------------------");
		for(Product p : list) {
			System.out.println(p);
		}
	}
	
	private void input() {
		System.out.println("상품 정보 입력");
		
		int kind = getInteger("선택(1.TV, 2.냉장고) : ");
		
		String productNum = getString("제품번호 : ");
		String productName = getString("제품명 : ");
		int price = getInteger("상품 가격 : ");
		int cargo = getInteger("상품 재고 : ");
		
		
		if(kind == 1) {
			mgr.input(new TV(productNum, productName, price, cargo));
		}else {
			mgr.input(new Refrigerator(productNum, productName, price, cargo));
		}
		
		System.out.println("상품 정보가 등록되었습니다.");
	}

	private int getInteger(String text) {
		return Integer.parseInt(getString(text));
	}


	private String getString(String text) {
		System.out.print(text);
		return sc.nextLine();
	}



}