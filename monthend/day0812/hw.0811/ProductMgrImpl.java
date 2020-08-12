
import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr{

	List<Product> product = new ArrayList<Product>();
	
	private static ProductMgrImpl instance;
	private ProductMgrImpl(){
		
	}
	
	public static ProductMgrImpl getInstance() {
		if(instance == null) instance = new ProductMgrImpl();
		return instance;
	}
	

	
	public void input(Product pro) {
		product.add(pro);
	}

	
	public List<Product> searchAll() {
			return product;
	}

	
	public Product searchProductNum(String productNumber) {
		for(Product p : product) {
			if(p.getProductNum().equals(productNumber)) {
				return p;
			}
		}
		return null;
	}
	
	public List<Product> searchProductName(String productName) {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p.getProductName().contains(productName)) {
				b.add(p);
			}
		}

		return b;
	}
	
//	모르는 부분
	public List<Product> searchTV() {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof TV) {
				b.add(p);
			}
		}
		
		return b;
	}
	
	public List<Product> searchRef() {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof Refrigerator) {
				b.add(p);
			}
		}
		
		return b;
	}
	
	
	public boolean delete(String productNum) {
		for(int i = 0; i < product.size(); i++) {
			if(product.get(i).getProductNum().equals(productNum)) {
				product.remove(i);
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

	@Override
	public List<Product> over400Ref() {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof Refrigerator && ((Refrigerator) p).getL() > 400 ) {
				b.add(p);
			}
		}
		
		return b;
	}

	@Override
	public List<Product> over50TV() {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof TV && ((TV) p).getInch() > 50 ) {
				b.add(p);
			}
		}
		
		return b;
	}

	@Override
	public boolean update(String productNum, int price) {
		for(int i = 0; i < product.size(); i++) {
			if(product.get(i).getProductNum().equals(productNum)) {
				Product tmp = product.get(i);
				tmp.setPrice(price);
				product.set(i, tmp);
				return true;
			}
		}
		return false;
	}

	
}