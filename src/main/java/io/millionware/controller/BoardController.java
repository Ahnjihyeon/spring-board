package io.millionware.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.millionware.service.BoardService;
import io.millionware.vo.BoardVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	//글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("글 작성 화면이다");
	}
	
	//글 작성
	public String write(BoardVO boardVO) throws Exception{
		logger.info("글 작성");
		
		service.write(boardVO);
		return "redirect:/";
	
	}
	
}
