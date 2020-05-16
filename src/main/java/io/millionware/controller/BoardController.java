package io.millionware.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.millionware.service.BoardService;
import io.millionware.vo.BoardVO;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	
	@Inject
	BoardService service;
	
	//글 작성 화면
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
	}
	
	//글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{		
		service.write(boardVO);
		return "redirect:/board/list123";
	
	}
	
	//글 목록 조회
	@RequestMapping(value="/list123", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		model.addAttribute("list",service.list());	
		return "board/list";
		 
	}
	
	//글 조회
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception{
		model.addAttribute("read", service.read(boardVO.getBno()));
		return "board/readView";
	}
	
	//글 수정 화면
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model)throws Exception{
		model.addAttribute("update", service.read(boardVO.getBno()));
		return "board/updateView";
	}
	
	//글 수정
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		service.update(boardVO);
		return "redirect:/board/list123";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		service.delete(boardVO.getBno());
		return "redirect:/board/list";
	}
}
