package com.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BookmarkDTO;

@Repository
public class BookmarkDAOImpl implements BookmarkDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.bookmark";
	
	public void saveBookmark(BookmarkDTO bookmarkDTO) {
		sqlSession.insert(namespace+".saveBmk", bookmarkDTO);
	}

	@Override
	public List<BookmarkDTO> list(BookmarkDTO bookmarkDTO) {
		List<BookmarkDTO> result = sqlSession.selectList(namespace+".list", bookmarkDTO);
		return result;
	}

	@Override
	public List getBmkList(String mbrId) {
		List<BookmarkDTO> result = sqlSession.selectList(namespace+".getBmkList", mbrId);
		return result;
	}

}
