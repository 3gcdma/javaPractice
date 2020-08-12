import java.util.ArrayList;
import java.util.Arrays;

import com.ssafy.ws.step06.Book;

public class ProductMgr {
	
	
	private static ProductMgr instance;
	private Product[] product = new Product[2];
	private int index = 0;
	
	private ProductMgr(){
		
	}
	
	public static ProductMgr getInstance() {
		if(instance == null) instance = new ProductMgr();
		return instance;
	}
	
	
	public void input(Product tv) {
		if(index == product.length) {
			product = Arrays.copyOf(product, index * 2);
		}
		product[index++] = tv;
	}

	
	public Product[] searchAll() {
			return Arrays.copyOf(product, index);
	}
	
	
	
	public Product searchProductNum(String productNumber) {
		for(int i = 0; i < index; i++) {
			if(product[i].getProductNum().equals(productNumber)) {
				Product p = product[i];
				return p;
			}
		}
		return null;
	}
	
	
	
	
	
	
	public Product[] searchProductName(String productName) {
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
		Product[] tmp = new Product[index];
		int size = 0;
		for(int i = 0; i < index; i++) {
			if(product[i] instanceof TV) {
				tmp[size++] = product[i];
			}
		}
		
		return Arrays.copyOf(tmp, size);
	}
	
	public Product[] searchRef() {
		Product[] tmp = new Product[index];
		int size = 0;
		for(int i = 0; i < index; i++) {
			if(product[i] instanceof Refrigerator) {
				tmp[size++] = product[i];
			}
		}
		
		return Arrays.copyOf(tmp, size);
		
	}
	
	public boolean delete(String productNum) {
		for(int i = 0; i < index; i++) {
			if(product[i].getProductNum().equals(productNum)) {
				int size = index - i - 1;
				System.arraycopy(product, i+1, product, i, size);
				product[--index] = null;
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

	
}