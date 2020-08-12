public class TV extends Product{

	public TV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TV(String productNum, String productName, int price, int cargo) {
		super(productNum, productName, price, cargo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TV [getProductNum()=" + getProductNum() + ", getProductName()=" + getProductName() + ", getPrice()="
				+ getPrice() + ", getCargo()=" + getCargo() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
