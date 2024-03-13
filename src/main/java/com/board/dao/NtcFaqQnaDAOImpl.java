package com.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

import com.board.domain.NtcFaqQnaDTO;
import com.board.domain.PageDTO;

@Repository
public class NtcFaqQnaDAOImpl implements NtcFaqQnaDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.ntcFaqQna";
	
	@Override
	public List<NtcFaqQnaDTO> list(Map<String, Object> param) throws Exception{
		List result = null;
		
		result = sqlSession.selectList(namespace + ".list", param);
		
		return result;
	}
	
	@Override
	public Integer getMaxNfqSeq() {
		/*
		 * Integer result = -1; result = sqlSession.selectOne(namespace+".maxSeq");
		 * return result;
		 */
		return sqlSession.selectOne(namespace+".maxNfqSeq");
	}
	
	@Override
	public int regiQstn(NtcFaqQnaDTO dto) {
		int result = sqlSession.insert(namespace+".regiQstn", dto);
		return result;
	}

	@Override
	public int regiNtc(NtcFaqQnaDTO dto) throws Exception {
		int result = sqlSession.insert(namespace+".regiNtc", dto);
		return result;
	}
	
	@Override
	public int regi(NtcFaqQnaDTO dto) {
		int result = sqlSession.insert(namespace+".regi", dto);
		return result;
	}
	
	@Override
	public NtcFaqQnaDTO view(int nfqSeq) {
		NtcFaqQnaDTO result = sqlSession.selectOne(namespace+".view", nfqSeq);
		return result;
	}
	
	@Override
	public int update(NtcFaqQnaDTO dto) {
		return sqlSession.update(namespace+".update", dto);
	}
	
	@Override
	public int delete(int nfqSeq) {
		return sqlSession.update(namespace+".delete", nfqSeq);
	}

	@Override
	public int getTotal() {
		int result = sqlSession.selectOne(namespace+".totalCnt");
		return result;
	}

	@Override
	public int getTotalByType(Map<String, Object> map) {
		int result = sqlSession.selectOne(namespace+".totalCntByType", map);
		return result;
	}

	@Override
	public List<NtcFaqQnaDTO> nfqSrch(Map<String, Object> param) {
		List result = null;
		result = sqlSession.selectList(namespace + ".srchList", param);
		return result;
	}

	@Override
	public List<NtcFaqQnaDTO> mngList(PageDTO pageDTO) throws Exception {
		List result = sqlSession.selectList(namespace + ".mngList", pageDTO);
		return result;
	}

}
