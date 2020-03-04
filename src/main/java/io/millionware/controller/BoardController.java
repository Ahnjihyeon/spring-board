package io.millionware.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.millionware.service.BoardService;
import io.millionware.vo.BoardVO;

@Controller
public class BoardController {
	
	
	@Inject
	BoardService service;
	
	//글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
	}
	
	//글 작성
	@RequestMapping(value = "board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{		
		service.write(boardVO);
		return "redirect:/board/list";
	
	}
	
	//글 목록 조회
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		model.addAttribute("list",service.list());	
		return "board/list";
		 
	}
	
	//글 조회
	@RequestMapping(value="/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception{
		model.addAttribute("read", service.read(boardVO.getBno()));
		return "board/readView";
	}
	
}
