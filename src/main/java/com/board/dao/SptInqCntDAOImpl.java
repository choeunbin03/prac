package com.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.SptInqCntDTO;

@Repository
public class SptInqCntDAOImpl implements SptInqCntDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.sptInqCnt";	
	
	@Override
	public void insertBbsSpt(Map<String, Object> param) {
		sqlSession.insert(namespace+".insertBbsSpt", param);
	}

}
