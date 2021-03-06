
import java.util.Scanner;

public class MyLinkedStackTest {
	Scanner sc = new Scanner(System.in);
	MyLinkedStack stack = new MyLinkedStack();

	private int menu() {
		System.out.println("------------------");
		System.out.println("1. 입력");
		System.out.println("2. 꺼내기");
		System.out.println("3. 전체데이터 확인");
		System.out.println("0. 종료");
		System.out.println("------------------");
		System.out.print("메뉴 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service() {
		while (true) {
			switch (menu()) {
			case 1: addData(); break;
			case 2: getData(); break;
			case 3:	viewData();  break;
			case 0: exit();
			}
		}
	}
	
	public void addData() {
		System.out.print("입력 값 : ");
		stack.push(sc.nextLine());
	}
	
	public void getData() {
		if (stack.isEmpty()) {
			System.out.println("입력된 데이터가 없습니다.\n");
			return;
		}
		System.out.println("꺼낸값 : " + stack.pop());	
	}
	
	public void viewData() { System.out.println(stack); }
	
	public void exit() { System.exit(0);}
	
	public static void main(String[] args) {
		MyLinkedStackTest mas = new MyLinkedStackTest();
		mas.service();
	}	
}
