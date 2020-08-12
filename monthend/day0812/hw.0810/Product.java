public class Product {
	private String productNum;
	private String productName;
	private int price;
	private int cargo;
	
	
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	
	public Product() {
		
	}
	
	public Product(String productNum, String productName, int price, int cargo) {
		super();
		this.productNum = productNum;
		this.productName = productName;
		this.price = price;
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		return "Product [productNum=" + productNum + ", productName=" + productName + ", price=" + price + ", cargo="
				+ cargo + "]";
	}
	
	
}