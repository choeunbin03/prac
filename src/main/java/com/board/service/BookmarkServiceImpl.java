package com.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.board.dao.BookmarkDAO;
import com.board.domain.BookmarkDTO;

@Service
public class BookmarkServiceImpl implements BookmarkService{
	
	@Inject
	private BookmarkDAO bookmarkDao;

	@Override
	public void saveBookmark(BookmarkDTO bookmarkDTO) {
		bookmarkDao.saveBookmark(bookmarkDTO);
	}

	@Override
	public List<BookmarkDTO> list(BookmarkDTO bookmarkDTO) {
		return bookmarkDao.list(bookmarkDTO);
	}

	@Override
	public List getBmkList(String mbrId) {
		List result = bookmarkDao.getBmkList(mbrId);
		return result;
	}

}
