import java.util.List;

public interface IBookMgr {
	void add(Book book);
	List<Book> searchAllBooks() ;
	Book selectISBN(String isbn);
	List<Book> selectTitle(String title);
	List<Book> selectBooks();
	List<Book> selectMegazines();
}
