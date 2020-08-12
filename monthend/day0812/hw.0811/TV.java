public class TV extends Product{
	private int inch;
	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public TV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TV(String productNum, String productName, int price, int cargo, int inch) {
		super(productNum, productName, price, cargo);
		// TODO Auto-generated constructor stub
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [inch=" + inch + ", getProductNum()=" + getProductNum() + ", getProductName()=" + getProductName()
				+ ", getPrice()=" + getPrice() + ", getCargo()=" + getCargo() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
