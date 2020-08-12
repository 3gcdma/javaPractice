import java.lang.reflect.Array;
import java.util.Arrays;

public class BookMgr {

	private static BookMgr instance;
	private Book[] books = new Book[2];
	//private Book books = new Book[2];
	//데이터가 들어갈 위치아 입력된 데이터의 크기
	private int index;
	
	private BookMgr() {

	}

	public static BookMgr getInstance() {
		if (instance == null)
			instance = new BookMgr();
		return instance;
	}

	/** 파라메터로 전달된 화 정보를 전달받아 배열에 저장한다. */
	public void add(Book book) {
		
		//1
		if(index == books.length) {
			books = Arrays.copyOf(books, index * 2);
		}
		books[index++] = book;
		
		//System.out.println(Arrays.toString(movies));
	}

	/** 배열에 저장된 모든 화정보를 리턴한다. */
	public Book[] searchAllBooks() {
		return Arrays.copyOf(books, index);
	}
	
	public Book selectISBN(String isbn) {
		for(int i = 0; i < index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				Book b = books[i];
				return b;
			}
		}
		return null;
		//for문을 통해 해당하는 값을 전달
	}
	/** 파라메터로 전달된 타이틀을 포함하고 있는 모든 화 정보를 검색하여 리턴한다 */
	public Book[] selectTitle(String title) {
		int idx = 0;
		Book[] b = new Book[index];
		//3
		for(int i = 0; i < index; i++) {
			if(books[i].getTitle().contains(title)) {
				b[idx++] = books[i];
			}
		}
		//4 새롭게 생성된 배열의 주소를 기본 변수에 대입
		return Arrays.copyOf(b, idx);
	}
	
	public Book[] selectBooks() {
		int idx = 0;
		Book[] b = new Book[index];

		for(int i = 0; i < index; i++) {
			///if(books[i] instanceof Book) { ///  둘다 참이다 
			if(books[i] instanceof Megazine) continue;
			
			b[idx++] = books[i];
		}

		return Arrays.copyOf(b, idx);
	}
	
	public Book[] selectMegazines() {
		int idx = 0;
		Book[] b = new Book[index];

		for(int i = 0; i < index; i++) {
			if(books[i] instanceof Megazine) b[idx++] = books[i];
		}

		return Arrays.copyOf(b, idx);
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
		return index;
	}


}
