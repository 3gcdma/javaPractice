package day0811.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ProductMgr implements IProductMgr{
	
	
	ArrayList<Product> p = new ArrayList<Product>();
	private static ProductMgr instance;
	private Product[] tv = new TV[100];
	private Product[] ref = new Refrigerator[100];
	private Product[] product = new Product[100];
	private int index = 0;
	///////////////
	//tv와 냉장고 구분을 어떻게 하지?...
	/////
	private ProductMgr(){
		
	}
	
	public static ProductMgr getInstance() {
		if(instance == null) instance = new ProductMgr();
		return instance;
	}
	
	public void inputTV(Product tv) {
		if(index == product.length) {
			product = Arrays.copyOf(product, index * 2);
		}
		product[index++] = tv;
	}
	
	public void inputRef(Product ref) {
		if(index == product.length) {
			product = Arrays.copyOf(product, index * 2);
		}
		product[index++] = ref;
	}
	
	
	public Product[] searchAll() {
		return Arrays.copyOf(product, index);
		//return union();
	}
	
	public Product search(int productNumber) {
		for(int i = 0; i < index; i++) {
			if(product[i].getProductNum() == productNumber)
				return product[i];
		}
		return null;
	}
	
	public Product[] search(String productName) {
		Product[] tmp = new Product[index];
		int size = 0;
		for(int i = 0; i < index; i++) {
			if(product[i].getProductName().contains(productName)) {
				tmp[size++] = product[i];
			}
		}
		return Arrays.copyOf(tmp, size);
	}
//	모르는 부분
	public Product[] searchTV() {
		return null;
		
	}
	
	public Product[] searchRef() {
		return null;
		
	}
	
	@Override
	public Product[] over400Ref() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] over50TV() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public boolean update(int productNum, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean delete(int productNum) {
		for(int i = 0; i < index; i++) {
			if(product[i].getProductNum() == productNum) {
				int size = product.length - i - 1;
				System.arraycopy(product, i+1, product, i, size);
				return true;
			}
				
		}
		return false;
	}
	
	public int totalPrice() {
		int sum = 0;
		for(Product p : product) {
			sum += p.getPrice();
		}
		return sum;
	}
	
	private Product[] union() {
		Product[] tmp = new Product[tv.length + ref.length];
		System.arraycopy(tv, 0, tmp, 0, tv.length);
		System.arraycopy(ref, 0, tmp, tv.length, ref.length);
		return tmp;
	}



	
}
