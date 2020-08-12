public class Refrigerator extends Product{

	public Refrigerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Refrigerator(String productNum, String productName, int price, int cargo) {
		super(productNum, productName, price, cargo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Refrigerator [getProductNum()=" + getProductNum() + ", getProductName()=" + getProductName()
				+ ", getPrice()=" + getPrice() + ", getCargo()=" + getCargo() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
