package io.millionware.dao;

import java.util.List;

import io.millionware.vo.BoardVO;

public interface BoardDAO {

	//글 작성
	public void write(BoardVO boardVO) throws Exception;
	
	//글 목록 조회
	public List<BoardVO> list() throws Exception;
	
	//글 조회
	public BoardVO read(int bno) throws Exception;
	
	//글 수정
	public void update(BoardVO boardVO) throws Exception;
	
	//글 삭제
	public void delete(int bno) throws Exception;
}
