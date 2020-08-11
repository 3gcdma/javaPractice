package day0811.hw;

import java.util.Arrays;

public interface IProductMgr {

	public void inputTV(Product tv);
	
	public void inputRef(Product ref);
	
	public Product[] searchAll();
	
	public Product search(int productNumber);
	
	public Product[] search(String productName);
	
	public Product[] searchTV();
	
	public Product[] searchRef();
	
	public Product[] over400Ref();
	
	public Product[] over50TV();
	
	public boolean update(int productNum, int price);
	
	public boolean delete(int productNum);
	
	public int totalPrice();

}
