package com.ssafy.fileupload04;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private String msg;
	private List<MultipartFile> attach;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<MultipartFile> getAttach() {
		return attach;
	}
	public void setAttach(List<MultipartFile> attach) {
		this.attach = attach;
	}
	
	
}
