import java.util.Scanner;

public class BookTest {
	private Scanner sc = new Scanner(System.in);
	private BookMgr mgr = BookMgr.getInstance();
	
	private void service() {
		System.out.println("<<< 영화 관리 프로그램 >>> ");
		
		
		while(true) {
			int menu = showMenu();
			switch(menu) {
			case 1:
				addBook();
				break;
			case 2:
				showAllBooks();
				break;
			case 3:
				showBookbyISBN();
				break;
			case 4:
				selectTitle();
				break;
			case 5:
				selectBooks();
				break;
			case 6:
				selectMegazines();
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


//	
//	private void deleteMovie() {
//		// TODO Auto-generated method stub
//		System.out.print("제목을 입력하세요 : ");
//		String title = sc.nextLine();
//		mgr.delete(title);
//		System.out.println("------------------------------");
//		System.out.println("삭제가 완료되었습니다.");
//		System.out.println("------------------------------");
//	}
//
//	private void searchGen() {
//		// TODO Auto-generated method stub
//		System.out.print("제목을 입력하세요 : ");
//		String genre = sc.nextLine();
//		Movie[] movies = mgr.searchGenre(genre);
//		System.out.println("------------------------------");
//		System.out.println("검색 정보");
//		System.out.println("------------------------------");
//		System.out.println("제목\t감독\t장르\t등급\t내용");
//		for(Movie m : movies) {
//			System.out.println(m.getTitle() + "\t" + m.getDirector() + "\t" + m.getGenre() + "\t" + m.getGrade() + "\t" + m.getSummary());
//			//System.out.println(m);
//		}
//		System.out.println("------------------------------");
//	}
//
//	private void searchDir() {
//		// TODO Auto-generated method stub
//		System.out.print("감독 이름을 입력하세요 : ");
//		String name = sc.nextLine();
//		Movie m = mgr.searchDirector(name);
//		if(m == null) {
//			System.out.println(name + " 감독의 작품이 조회되지 않음!!");
//			return;
//		}
//		System.out.println("------------------------------");
//		System.out.println("검색 정보");
//		System.out.println("------------------------------");
//		System.out.println("제목\t감독\t장르\t등급\t내용");
//		System.out.println(m.getTitle() + "\t" + m.getDirector() + "\t" + m.getGenre() + "\t" + m.getGrade() + "\t" + m.getSummary());
//			//System.out.println(m);
//		System.out.println("------------------------------");
//	}
//
	
	private void selectMegazines() {
		System.out.println("매거진만 검색");
		System.out.println("------------------------------");
		System.out.println("검색 정보");
		System.out.println("------------------------------");
		printBooks(mgr.selectMegazines());
		System.out.println("------------------------------");
		
	}

	private void selectBooks() {
		System.out.println("책만 검색");
		
		System.out.println("------------------------------");
		System.out.println("검색 정보");
		System.out.println("------------------------------");
		//System.out.println("제목\t감독\t장르\t등급\t내용");
		printBooks(mgr.selectBooks());
		System.out.println("------------------------------");
			
	}

	private void selectTitle() {
		// TODO Auto-generated method stub
		System.out.println("책 제목 검색");
		String title = scanString("제목을 입력하세요 : ");
		
		System.out.println("------------------------------");
		System.out.println("검색 정보");
		System.out.println("------------------------------");
		//System.out.println("제목\t감독\t장르\t등급\t내용");
		printBooks(mgr.selectTitle(title));
		System.out.println("------------------------------");
	}

	private void printBooks(Book[] books) {
		for(Book b : books) {
			//System.out.println(m.getTitle() + "\t" + m.getDirector() + "\t" + m.getGenre() + "\t" + m.getGrade() + "\t" + m.getSummary());
			System.out.println(b);
		}
	}
	private void showBookbyISBN() {
		System.out.println("책 ISBN 정보 검색");
		String isbn = scanString("검색할 ISBN 번호 : ");
		Book book = mgr.selectISBN(isbn);
		if(book == null) {
			System.out.println("입력한 ISBN에 해당하는 책이 없습니다.");
			return;
		}
		System.out.println(book);
	}
	private void showAllBooks() {
		System.out.println("------------------------------");
		System.out.println("도서 정보 (전체 : " + mgr.getSize() + "권)");
		System.out.println("------------------------------");
		//System.out.println("제목\t감독\t장르");
		printBooks(mgr.searchAllBooks());
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		
	}

	private int showMenu() {
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("1.책 정보 입력 ");
		System.out.println("2.도서 정보 전체 검색 ");
		System.out.println("3.도서 ISBN 검색 ");
		System.out.println("4.도서 제목 검색 ");
		System.out.println("5.책만 검색 ");
		System.out.println("6.잡지만 검색 ");
//		System.out.println("5.영화 정보 삭제 ");
//		System.out.println("6.영화 감독 검색");
		System.out.println("0.종료 ");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.print("원하는 번호를 선택하세요. : ");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	private void addBook() {

		System.out.println("책 정보 입력");
		
		int kind = scanInt("선택(1.책, 2.잡지) : ");
		String isbn = scanString("책번호(ISBN) : ");
		String title = scanString("제목 : ");
		String author = scanString("저자 : ");
		String publisher = scanString("출판사 : ");
		int price = scanInt("가격 : ");
		String desc = scanString("설명 : ");

		
		if(kind == 1) {
			mgr.add(new Book(isbn, title, author, publisher, price, desc));
		}else {
			int year = scanInt("년도 : ");
			int month = scanInt("월 : ");
			mgr.add(new Megazine(isbn, title, author, publisher, price, desc, year, month));
		}
		

		System.out.println("영화 정보가 등록되었습니다.");
		

		//System.out.print("제목 : ");
		//String title = sc.nextLine();
		//m.setTitle(title);
		
	}
	
	private String scanString(String text) {
		System.out.print(text);
		return sc.nextLine();
	}
	
	private int scanInt(String text) {
		return Integer.parseInt(scanString(text));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookTest mt = new BookTest();
		mt.service();
		
	}
	
}
