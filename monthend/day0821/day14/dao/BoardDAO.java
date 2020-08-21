import java.util.List;

import com.ssafy.day14.vo.Board;

public interface BoardDAO {
	int insertBoard(Board board) throws Exception;
	int updateBoard(Board board) throws Exception;
	int deleteBoard(int no) throws Exception;
	Board selectBoardByNo(int no) throws Exception;
	List<Board> selectBoard() throws Exception;
}
