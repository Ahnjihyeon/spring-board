package io.millionware.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import io.millionware.dao.BoardDAO;
import io.millionware.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	private BoardDAO dao;
	
	
	//글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	
	//글 목록 조회
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}
	
	//글 조회
	@Override
	public BoardVO read(int bno) throws Exception{
		return dao.read(bno); 
	}
}