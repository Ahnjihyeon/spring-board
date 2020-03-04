package io.millionware.service;

import java.util.List;

import io.millionware.vo.BoardVO;

public interface BoardService {
	//글 작성
	public void write(BoardVO boardVO) throws Exception;
	
	//글 목록 조회
	public List<BoardVO> list() throws Exception;
	
	//글 조회
	public BoardVO read(int bno) throws Exception;
}
