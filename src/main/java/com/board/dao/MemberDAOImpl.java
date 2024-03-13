package com.board.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.member";
	
	@Override
	public MemberDTO login(MemberDTO dto) {
		MemberDTO result = sqlSession.selectOne(namespace+".login", dto);
		return result;
	}

	@Override
	public int join(MemberDTO memberDto) throws Exception {
		return sqlSession.insert(namespace+".join", memberDto);
		
	}

}
