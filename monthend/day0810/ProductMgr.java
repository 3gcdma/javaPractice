import java.util.Arrays;

public class ProductMgr {
	
	private static ProductMgr instance;
	private Product[] tv = new TV[100];
	private Product[] ref = new Refrigerator[100];
	
	private ProductMgr(){
		
	}
	
	public static ProductMgr getInstance() {
		if(instance == null) instance = new ProductMgr();
		return instance;
	}
	
	public Product[] searchAll() {
		return union();
	}
	
	public Product search(int productNumber) {
		
	}
	
	public Product search(String productName) {
		
	}
	
	public Product[] searchTV() {
		
	}
	
	public Product[] searchRef() {
		
	}
	
	public boolean delete(int productNum) {
		
	}
	
	public int totalPrice() {
		
	}
	
	private Product[] union() {
		Product[] tmp = new Product[tv.length + ref.length];
		System.arraycopy(tv, 0, tmp, 0, tv.length);
		System.arraycopy(ref, 0, tmp, tv.length, ref.length);
		return tmp;
	}
	
}
