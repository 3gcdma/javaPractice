package com.ssafy.fileupload05.board.service;

import java.util.List;
import java.util.Map;

import com.ssafy.fileupload05.repository.dto.Board;

public interface BoardService {
	// 게시물 목록 가져오기
	public List<Board> list();
	public void write(Board board) throws Exception; 
//	public Map<String, Object> detail(int no);
	public Board detail(int no);
}
