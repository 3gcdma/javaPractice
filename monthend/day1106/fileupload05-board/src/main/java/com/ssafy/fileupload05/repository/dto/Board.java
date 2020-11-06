package com.ssafy.fileupload05.repository.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author multicampus
 *
 */
public class Board {
	
	//첨부파일 
	private List<BoardFile> fileList;
	/**
	 * 
	 */
	private int no;
	public List<BoardFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<BoardFile> fileList) {
		this.fileList = fileList;
	}
	private String title;
	private String content;
	private String writer;
	private List<MultipartFile> attach;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public List<MultipartFile> getAttach() {
		return attach;
	}
	public void setAttach(List<MultipartFile> attach) {
		this.attach = attach;
	}
	
	
}
