public class Megazine extends Book{
	private int year;
	private int month;

	public Megazine() {
		super();
	}

	public Megazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	

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
		return "Megazine [year=" + year + ", month=" + month + ", toString()=" + super.toString() + "]";
	}

	

	
	
	
}
