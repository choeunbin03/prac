package com.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardDTO;
import com.board.domain.PageDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.board";
	
	@Override
	public List<BoardDTO> list(PageDTO pageDto) throws Exception{
		List result = null;
		
		result = sqlSession.selectList(namespace + ".list", pageDto);
		
		return result;
	}
	
	@Override
	public Integer getMaxBbsSeq() {
		/*
		 * Integer result = -1; result = sqlSession.selectOne(namespace+".maxSeq");
		 * return result;
		 */
		return sqlSession.selectOne(namespace+".maxBbsSeq");
	}
	
	@Override
	public int regi(BoardDTO dto) {
		return sqlSession.insert(namespace+".regi", dto);
	}
	
	@Override
	public BoardDTO view(int bbsSeq) {
		BoardDTO result = sqlSession.selectOne(namespace+".view", bbsSeq);
		return result;
	}
	
	@Override
	public void updateBbsInqCnt(int bbsSeq) {
		sqlSession.update(namespace+".updateBbsInqCnt", bbsSeq);
	}
	
	@Override
	public int update(BoardDTO dto) {
		return sqlSession.update(namespace+".update", dto);
	}
	
	@Override
	public int delete(int bbsSeq) {
		return sqlSession.update(namespace+".delete", bbsSeq);
	}
	
	@Override
	public void updateBbsSpt(int bbsSeq) {
		sqlSession.insert(namespace+".updateBbsSpt", bbsSeq);
	}

	@Override
	public String checkBbsSptYn(Map<String, Object> params) {
		String result = sqlSession.selectOne(namespace+".checkBbsSptYn", params);
		return result;
	}

	@Override
	public int getTotal() {
		int result = sqlSession.selectOne(namespace+".totalCnt");
		return result;
	}

	@Override
	public int getTotal(Map<String, Object> param) {
		int result = sqlSession.selectOne(namespace+".srchBbsTotalCnt", param);
		return result;
	}

	@Override
	public List<BoardDTO> bbsSrch(Map<String, Object> param) {
		List result = null;
		result = sqlSession.selectList(namespace + ".srchList", param);
		return result;
	}

}
