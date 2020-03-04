package io.millionware.service;

import io.millionware.vo.BoardVO;

public interface BoardService {
	//글 작성
	public void write(BoardVO boardVO) throws Exception;
}
