package day0811.hw;

import java.util.Scanner;

public class ProductTest {
	
	private static ProductMgr mgr = ProductMgr.getInstance();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int cases = 0;
		//입력 받고
		
		switch(cases) {
		case 1:
//			Product tmp;
//			mgr.inputTV(tmp);
//			mgr.inputRef(tmp);
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
		}
	}

	
	
	private static void totalPrice() {
		System.out.println("Price : " + mgr.totalPrice());
	}



	private static void delete() {
		if(mgr.delete(getInteger())) {
			
		}
		
	}



	private static void searchRef() {
		
	}



	private static void searchTV() {
		
	}



	private static void searchName() {
		Product[] list = mgr.search(getString());
		
	}


	private static void searchNum() {
		Product list = mgr.search(getInteger());
		
	}


	private static int getInteger() {
		return Integer.parseInt(getString());
	}


	private static String getString() {
		return sc.nextLine();
	}


	private static void searchAll() {
		Product[] list = mgr.searchAll();

	}

}
