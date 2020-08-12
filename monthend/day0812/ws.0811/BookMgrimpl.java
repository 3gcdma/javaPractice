import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookMgrimpl implements IBookMgr{

	private List<Book> books = new ArrayList<Book>();
	
	
	private static BookMgrimpl instance;
	private BookMgrimpl() {

	}
	public static BookMgrimpl getInstance() {
		if (instance == null)
			instance = new BookMgrimpl();
		return instance;
	}

	public void add(Book book) {
		books.add(book);
	}

	public List<Book> searchAllBooks() {
		return books;
	}
	
	public Book selectISBN(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	
	public List<Book> selectTitle(String title) {
		List<Book> b = new ArrayList<Book>();

		for(Book book : books) {
			if(book.getTitle().contains(title)) {
				b.add(book);
			}
		}
		
		return b;
	}
	
	public List<Book> selectBooks() {
		List<Book> b = new ArrayList<Book>();

		for(Book book : books) {
			if(book instanceof Megazine) {
				continue;
			}
			b.add(book);
		}
		
		return b;
	}
	
	public List<Book> selectMegazines() {
		List<Book> b = new ArrayList<Book>();

		for(Book book : books) {
			if(book instanceof Megazine) {
				b.add(book);
			}
		}
		
		return b;
	}

//	/** 파라메터로 전달된 감독명의 모든 화 정보를 검색하여 리턴한다 */
//	public Movie searchDirector(String name) {
//		//3
//		for(int i = 0; i < index; i++) {
//			if(movies[i].getDirector().equals(name)) {
//				return movies[i];
//			}
//		}
//		//4 새롭게 생성된 배열의 주소를 기본 변수에 대입
//		return null;
//	}
//
//	/** 파라메터로 전달된 장르의 모든 화 정보를 검색하여 리턴한다 */
//	public Movie[] searchGenre(String genre) {
//		int idx = 0;
//		Movie[] temp = new Movie[index];
//		//3
//		for(int i = 0; i < index; i++) {
//			if(movies[i].getGenre().equals(genre)) {
//				temp[idx++] = movies[i];
//			}
//		}
//		//4 새롭게 생성된 배열의 주소를 기본 변수에 대입
//		return Arrays.copyOf(temp, idx);
//	}
//
//	/** 파라메터로 전달된 제목의 화를 삭제한다. */
//	public void delete(String title) {
//		
//		////내가 쓴 코드
////		int idx = 0;
////		for(int i = 0; i < index; i++) {
////			if(movies[i].getTitle().equals(title)) {
////				idx = i;
////				break;
////			}
////		}
////		
////		for(int i = idx; i < index; i++) {
////			movies[i] = movies[i+1];
////		}
////		movies[index] = null;
////		index--;
//		
//		////조언 코드(배열 통째로 복사)
//		for(int i = 0; i < index; i++) {
//			if(movies[i].getTitle().equals(title)) {
//				int movecnt = index - i + 1;
//				if(movecnt != 0) {
//					System.arraycopy(movies, i+1, movies, i, index - i + 1);
//				}
//				movies[index--] = null;
//				break;
//			}
//		}
//		
//	}
//
	/** 저장된 화 정보의 갯수를 리턴한다. */
	public int getSize() {
		return books.size();
	}


}
