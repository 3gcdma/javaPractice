package day0811.ws;

public class Magazine extends Book{
	 private int year;
	 private int month;
	 
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", getIsbn()=" + getIsbn() + ", getTitle()=" + getTitle()
				+ ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice()
				+ ", getDesc()=" + getDesc() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	public Magazine(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}
	 
	
}
