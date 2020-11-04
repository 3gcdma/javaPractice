package com.ssafy.fileupload04;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@RequestMapping(value = "/upload01.do", method = RequestMethod.POST)
	public String upload01(String msg, MultipartFile attach ) throws Exception {
		System.out.println("msg : " + msg);
		System.out.println("원본 파일명 : " + attach.getOriginalFilename());
		System.out.println("파일 크기 : " + attach.getSize());
		System.out.println("파일 종류 : " + attach.getContentType());
		
		
		String orgName = attach.getOriginalFilename();
		int index = orgName.lastIndexOf(".");
		String ext = "";
		if (index != -1) {
			ext = orgName.substring(index);
		}
		// 유니크한 이름 만들기
		String name = UUID.randomUUID().toString();
		
		attach.transferTo(new File("C:\\SSAFY\\upload", name + ext));
		return "index";
	}
	
	@RequestMapping(value = "/upload02.do", method = RequestMethod.POST)
	public String upload02(String msg, List<MultipartFile> attach ) throws Exception {
		System.out.println("msg : " + msg);
		
		System.out.println("attach size : " + attach.size());
		for(MultipartFile file : attach) {
			
			if(file.isEmpty()) continue;
			
			String orgName = file.getOriginalFilename();
			int index = orgName.lastIndexOf(".");
			String ext = "";
			if (index != -1) {
				ext = orgName.substring(index);
			}
			// 유니크한 이름 만들기
			String name = UUID.randomUUID().toString();
			
			file.transferTo(new File("C:\\SSAFY\\upload", name + ext));
			
		}
		
		return "index";
	}
	
	
	
	
	@RequestMapping(value = "/upload03.do", method = RequestMethod.POST)
	public String upload03(FileVO filevo ) throws Exception {
		
		for(MultipartFile file : filevo.getAttach()) {
			
			if(file.isEmpty()) continue;
			
			String orgName = file.getOriginalFilename();
			int index = orgName.lastIndexOf(".");
			String ext = "";
			if (index != -1) {
				ext = orgName.substring(index);
			}
			// 유니크한 이름 만들기
			String name = UUID.randomUUID().toString();
			
			file.transferTo(new File("C:\\SSAFY\\upload", name + ext));
			
		}
		
		return "index";
	}
}
