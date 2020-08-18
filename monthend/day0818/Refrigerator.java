public class Refrigerator extends Product{
	private int L;
	
	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}

	public Refrigerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Refrigerator(String productNum, String productName, int price, int cargo, int L) {
		super(productNum, productName, price, cargo);
		// TODO Auto-generated constructor stub
		this.L = L;
	}

	@Override
	public String toString() {
		return "Refrigerator [L=" + L + ", getProductNum()=" + getProductNum() + ", getProductName()="
				+ getProductName() + ", getPrice()=" + getPrice() + ", getCargo()=" + getCargo() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	

	
}
