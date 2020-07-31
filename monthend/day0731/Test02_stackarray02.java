import java.util.Arrays;
import java.util.Scanner;

public class Test02_stackarray02 {
	
	MyArrayStack st = new MyArrayStack();
	Scanner sc = new Scanner(System.in);
	
	private int menu() {
		System.out.println("---------------");
		System.out.println("1. 입력하기");
		System.out.println("2. 꺼내기");
		System.out.println("3. 전체데이터 확인");
		System.out.println("0. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 : ");
		return sc.nextInt();
	}
	
	private void insert() {
		if(st.isFull()) {
			System.out.println("데이터가 꽉 찾습니다.");
			return;
		}
		System.out.print("입력 : ");
		st.push(sc.nextInt());
	}
	
	private void getData() {
		if(st.isEmpty()) {
			System.out.println("데이터가 비었습니다");
			return;
		}
		System.out.println("꺼낸 값 : " + st.pop());
	}
	
	private void select() {
		// TODO Auto-generated method stub
		System.out.println(st);
	}
	
	private void exit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	
	private void service() {
		// TODO Auto-generated method stub
		while(true) {			
			switch(menu()) {
			case 1:
				insert();
				break;
			case 2:
				getData();			
				break;
			case 3:
				select();
				break;
			case 0:
				exit();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Test02_stackarray02().service();
 		
	}




}
