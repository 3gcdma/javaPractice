package day0811.ws;

import java.util.ArrayList;

public class BookManager implements IBookMgr{

	
	ArrayList<Book> b = new ArrayList<Book>();
	
	public boolean insert(Book data) {
		return true;
	}
	
	public Book[] searchAll() {
		return null;
		//Arrays.copyOF을 이용해서 배열 넘겨주기
	}
	public Book search(int isbn) {
		return null;
		//for문을 통해 해당하는 값을 전달
	}
	public Book[] search(String title) {
		return null;
		//String의 containe을 이용하여 해당되는 모든 값을 배열에 넣고 복사해서 넘겨주기
		
	}
	public Book[] searchBook() {
		return null;
		//??? 이걸 어떻게 판단할까?
	}
	public Book[] searchMagazine() {
		return null;
		//??? 이걸 어떻게 판단할까?
	}
	
	public Book[] searchMagazineYear() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Book searchPublisher(String publisher) {
		return null;
		//String의 equlse을 이용하여 해당되는 모든 값을 배열에 넣고 복사해서 넘겨주기
	}
	public Book[] searchPrice(int price) {
		return null;
		//for문을 통해 하나씩 비교해가면 해당되면 배열을 추가
	}
	public int sumPrice() {
		return 0;
		//foreach를 통해 합을 구해 반환
	}
	public int avrPrice() {
		return 0;
		//sumprice를 가져와 배열 크기만큼 나누기 
	}

	
}
