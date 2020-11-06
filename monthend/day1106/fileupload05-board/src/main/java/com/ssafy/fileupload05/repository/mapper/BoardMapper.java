package com.ssafy.fileupload05.repository.mapper;

import java.util.List;

import com.ssafy.fileupload05.repository.dto.Board;
import com.ssafy.fileupload05.repository.dto.BoardFile;

public interface BoardMapper {
//	@Select("select * from board order by no desc")
	List<Board> selectBoard();
	void insertBoard(Board board);
	void insertBoardFile(BoardFile boardfil);
	Board selectBoardByNo(int no);
	List<BoardFile> selectBoardFileByNo(int no);
}
