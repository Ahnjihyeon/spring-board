package io.millionware.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import io.millionware.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	//글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);

	}
	
	//글 목록 조회
	@Override
	public List<BoardVO> list() throws Exception{
		return sqlSession.selectList("boardMapper.list");
	}
	
	//글 조회
	@Override
	public BoardVO read(int bno) throws Exception{
		return sqlSession.selectOne("boardMapper.read", bno);
	}

	//글 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("boardMapper.update", boardVO);
	}
	
	//글 삭제
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("boardMapper.update", bno);
	}

	
}
