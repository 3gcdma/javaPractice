package com.ssafy.fileupload05.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.fileupload05.board.service.BoardService;
import com.ssafy.fileupload05.repository.dto.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list")
	public void list(Model model ) {
		model.addAttribute("list",service.list());
	}
	
	/* 등록폼 이동*/
	@GetMapping("/write")
	public void write () {}
	
	@PostMapping("/write")
	public String write (Board board) throws Exception{
		try {
			service.write(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return "redirect:list";
	}
	
	/** 상세 페이지 이동 */
	@GetMapping("/detail")
	public void detail(int no,Model model) throws Exception{
		//게시물 정보 
//		Map<String, Object> result = service.detail(no);
		Board result = service.detail(no);
		model.addAttribute("result", result);
	}
}
