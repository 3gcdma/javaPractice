import java.io.Serializable;

public class Product implements Serializable {
	private String num;
	private String name;
	private int price;
	private int amount;
	private int inch;
	private int liter;
	private String gubun;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public int getLiter() {
		return liter;
	}
	public void setLiter(int liter) {
		this.liter = liter;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public Product(String num, String name, int price, int amount, int inch, int liter, String gubun) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.inch = inch;
		this.liter = liter;
		this.gubun = gubun;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + ", inch=" + inch
				+ ", liter=" + liter + ", gubun=" + gubun + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}