import java.util.List;

public interface INewsDAO {
	public List<News> getNewsList(String s);
	public News Search(String s) ;

}
