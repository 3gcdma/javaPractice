package day0811.ws;

import java.util.ArrayList;

public interface IBookMgr {	
	public boolean insert(Book data);

	public Book[] searchAll();
	
	public Book search(int isbn);
	
	public Book[] search(String title);
	
	public Book[] searchBook();
	
	public Book[] searchMagazine();
	
	public Book[] searchMagazineYear();
	
	public Book searchPublisher(String publisher);
	
	public Book[] searchPrice(int price);
	
	public int sumPrice();
	
	public int avrPrice();
}
