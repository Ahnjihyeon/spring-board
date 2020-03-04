package io.millionware.dao;

import io.millionware.vo.BoardVO;

public interface BoardDAO {

	//글 작성
	public void write(BoardVO boardVO) throws Exception;
	
}
