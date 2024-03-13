package com.board.service;

import java.util.List;
import java.util.Map;

import com.board.domain.BookmarkDTO;

public interface BookmarkService {

	public void saveBookmark(BookmarkDTO bookmarkDTO);	
	public List<BookmarkDTO> list(BookmarkDTO bookmarkDTO);
	public List getBmkList(String mbrId); 
	
	
}
