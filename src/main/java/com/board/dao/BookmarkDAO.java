package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.domain.BookmarkDTO;

public interface BookmarkDAO {
	
	public void saveBookmark(BookmarkDTO bookmarkDTO);
	public List<BookmarkDTO> list(BookmarkDTO bookmarkDTO);
	public List<BookmarkDTO> getBmkList(String mbrId);

}
