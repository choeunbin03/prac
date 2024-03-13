package com.board.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.CmntDTO;

@Repository
public class CmntDAOImpl implements CmntDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.cmnt";
	
	@Override
	public List<CmntDTO> list(CmntDTO params) throws Exception{
		List result = null;
		
		result = sqlSession.selectList(namespace + ".list", params);
		
		return result;
	}
	
	@Override
	public Integer getMaxCmntSeq(CmntDTO params) {
		
		int result = -1;
		result = sqlSession.selectOne(namespace+".maxCmntSeq", params);
		
		return result;
	}
	
	@Override
	public int regiCmnt(CmntDTO dto) {
		int result = sqlSession.insert(namespace+".regiCmnt", dto);
		return result;
	}
	
	
	@Override
	public int updateCmnt(CmntDTO dto) {
		int result = sqlSession.update(namespace+".update", dto);
		return result;
	}
	
	@Override
	public int deleteCmnt(CmntDTO dto) {
		int result = sqlSession.update(namespace+".delete", dto);
		return result;
	}
	
}
