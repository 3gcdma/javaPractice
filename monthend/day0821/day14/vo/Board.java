package com.ssafy.day14.vo;

public class Board {
	private int no;
	private String title;
	private String writer;
	private String content;
	private int view_cnt;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String titel) {
		this.title = titel;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public Board(int no, String title, String writer, String content, int view_cnt) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.view_cnt = view_cnt;
	}
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", view_cnt="
				+ view_cnt + "]";
	}
	
	
}
