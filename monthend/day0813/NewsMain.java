import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NewsMain {
	private Scanner sc = new Scanner(System.in);
	private INewsDAO ind = new NewsDAODOMImpl();
	
	public NewsMain() {
		while(true) {
			int menu = choiceMenu();
			switch(menu) {
			case 1:
				showList();
				break;
			case 2:
				execute();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요!!");
				break;
			}
		}
	}
	
	private void execute() {
		News n;
		String choose;
		System.out.print("뉴스번호 : ");
		n = ind.Search(sc.nextLine());
		System.out.println("-------------------------------------");
		System.out.println("제목 : " + n.getTitle());
		System.out.println("내용 : " + n.getDesc());
		System.out.println("링크 : " + n.getLink());
		System.out.println("-------------------------------------");
		System.out.print("뉴스페이지 이동하기(Y/N) : ");
		choose = sc.nextLine();
		//System.out.println(choose.equals("Y"));
		if(choose.equals("Y")) {
			Runtime exe = Runtime.getRuntime();
			try {
				exe.exec("C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe " + n.getLink());
			}catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

	private void showList() {
		List<News> list = ind.getNewsList("");
		for(News n : list) {
			System.out.println(n);
		}
		System.out.println("-------------------------------------");
	}

	private int choiceMenu() {
		System.out.println("-------------------------------------");
		System.out.println("뉴스 정보");
		System.out.println("-------------------------------------");
		System.out.println("1. 뉴스 전체 조회");
		System.out.println("2. 상세 조회");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------");
		System.out.print("선택 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public static void main(String[] args) {
		NewsMain nm = new NewsMain();
	}

}
