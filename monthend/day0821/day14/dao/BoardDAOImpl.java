package com.ssafy.day14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.day14.ConnectionPool;
import com.ssafy.day14.SQLExecutor;
import com.ssafy.day14.vo.Board;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insertBoard(Board board) throws Exception{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = ConnectionPool.getConnection();
//			StringBuffer sql = new StringBuffer();
//			sql.append("insert into tb_board( ");
//			sql.append("title, writer, content ");			
//			sql.append(") values ( ");
//			sql.append(" ?, ?, ? ");
//			sql.append(") ");
//			pstmt = con.prepareStatement(sql.toString());
//			
//			int index = 1;
//			pstmt.setString(index++, board.getTitel());
//			pstmt.setString(index++, board.getWriter());
//			pstmt.setString(index++, board.getContent());
//			return pstmt.executeUpdate();
//		}finally {
//			ConnectionPool.close(pstmt);
//			ConnectionPool.releaseConnection(con);
//		}
		return SQLExecutor.update("insert into tb_board( title, writer, content ) values (  ?, ?, ? ) ",
				board.getTitle(), board.getWriter(), board.getContent());
	}

	@Override
	public int updateBoard(Board board) throws Exception{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = ConnectionPool.getConnection();
//			StringBuffer sql = new StringBuffer();
//			sql.append("Update tb_board ");
//			sql.append("Set title = ?, content = ? ");
//			sql.append("Where no = ");
//			sql.append(" ? ");
//			pstmt = con.prepareStatement(sql.toString());
//			
//			int index = 1;
//			pstmt.setString(index++, board.getTitel());
//			pstmt.setString(index++, board.getWriter());
//			pstmt.setInt(index++, board.getNo());
//			return pstmt.executeUpdate();
//		}finally {
//			ConnectionPool.close(pstmt);
//			ConnectionPool.releaseConnection(con);
//		}
		return SQLExecutor.update("Update tb_board Set title = ?, content = ? Where no =  ? ",
				board.getTitle(), board.getWriter(), board.getNo());
	}

	@Override
	public int deleteBoard(int no) throws Exception{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = ConnectionPool.getConnection();
//			StringBuffer sql = new StringBuffer();
//			sql.append("Delete ");
//			sql.append("From tb_board ");
//			sql.append("Where no = ");
//			sql.append(" ? ");
//			pstmt = con.prepareStatement(sql.toString());
//			
//			int index = 1;
//			pstmt.setInt(index++, no);
//			return pstmt.executeUpdate();
//		}finally {
//			ConnectionPool.close(pstmt);
//			ConnectionPool.releaseConnection(con);
//		}
		return SQLExecutor.update("Delete From tb_board Where no = ? ", no);
	}

	@Override
	public Board selectBoardByNo(int no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("Select * ");
			sql.append("From tb_board ");
			sql.append("Where no = ");
			sql.append(" ? ");
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index++, no);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int view_cnt = rs.getInt("view_cnt");
				return new Board(no, title, writer, content, view_cnt);
			}
			
		}finally {
			ConnectionPool.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}

	@Override
	public List<Board> selectBoard() throws Exception{
		List<Board> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("Select * ");
			sql.append("From tb_board ");
			sql.append("Order by no desc ");
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int view_cnt = rs.getInt("view_cnt");
				list.add(new Board(no, title, writer, content, view_cnt));
			}
			
		}finally {
			ConnectionPool.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}

}
