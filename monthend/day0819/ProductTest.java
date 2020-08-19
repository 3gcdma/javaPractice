import java.util.List;
import java.util.Scanner;


public class ProductTest {
	
	private ProductMgrImpl mgr = ProductMgrImpl.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ProductTest pt = new ProductTest();
		pt.start();
	}
	
	private void start() {
		mgr.getListData();
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
				over400();
				break;
			case 8:
				over50();
				break;
			case 9:
				update();
				break;
			case 10:
				delete();
				break;
			case 11:
				totalPrice();
				break;
			case 12:
				totalPriceLess();
				break;
			case 13:
				sendToServer();
				break;
			case 0:
				sendToServer();
				System.out.println("종료합네다");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 선택입네다. 다시 고루시라우요");
			}
		}
	}



	private void totalPriceLess() {
		System.out.println("지정 금액 이하의 상품 전체 금액 조회 하기");
		int price = getInteger("상품 변경할 가격 : ");
		System.out.println("------------------------------");
		System.out.println("전체 재고 상품 총 가격 : " + mgr.totalPriceLess(price));
		System.out.println("------------------------------");
	}

	private void sendToServer() {
		System.out.println("상품 정보를 서버로 전송합니다.");
		mgr.sendToServers();
		System.out.println("성공적으로 전송하였습니다.");
		System.out.println("------------------------------");
	}


	private void update() {
		System.out.println("상품 정보 업데이트");
		
		String productNum = getString("상품 번호 : ");
		int price = getInteger("상품 변경할 가격 : ");
		if(mgr.update(productNum, price)) {
			System.out.println("변경에 성공하였습니다.");
		}else {
			System.out.println("변경 실패, 넣으신 내용을 확인하세요");
		}
		System.out.println("------------------------------");
		
	}



	private void over50() {
		System.out.println("50inch TV 상품 정보 출력");
		try {
			printProduct(mgr.over50TV());
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		System.out.println("------------------------------");
	}



	private void over400() {
		System.out.println("400L이상의 TV 상품 정보 출력");
		try {
			printProduct(mgr.over400Ref());
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		
		System.out.println("------------------------------");
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
		System.out.println("7.400L 이상의 Refrigerator 검색  ");
		System.out.println("8.50inch 이상의 TV검색  ");
		System.out.println("9.상품 가격을 변경  ");
		System.out.println("10.상품 삭제 ");
		System.out.println("11.상품 전체 금액 검색 ");
		System.out.println("12.지정 금액 이하의 상품 전체 금액 검색");
		System.out.println("13.서버로 데이터 전송");
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
		try {
			System.out.println(mgr.searchProductNum(getString("상품 번호 : "))); 
		} catch (CodeNotFoundException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		
		System.out.println("------------------------------");
	}

	private void searchAll() {
		System.out.println("모든 상품 정보 출력");
		printProduct(mgr.searchAll());
		System.out.println("------------------------------");
	}


	private void printProduct(List<Product> list) {
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
		
		try {
			if(kind == 1) {
				int inch = getInteger("TV 크기 : ");
				mgr.input(new TV(productNum, productName, price, cargo, inch));
			}else {
				int L = getInteger("냉장고 용량 : ");
				mgr.input(new Refrigerator(productNum, productName, price, cargo, L));
			}
			
			System.out.println("상품 정보가 등록되었습니다.");
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
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