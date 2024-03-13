package com.board.service;

import java.util.List;
import java.util.Map;

import com.board.domain.BoardDTO;
import com.board.domain.PageDTO;

public interface BoardService {
	public List<BoardDTO> list(PageDTO pageDto) throws Exception;

	public int regi(BoardDTO dto) throws Exception;

	BoardDTO view(int bbsSeq);

	public int update(BoardDTO dto);

	public int delete(int bbsSeq);
	
	

	public void updateBbsInqCnt(int bbsSeq);

	public void updateBbsSpt(int bbsSeq);
	public String checkBbsSptYn(Map<String, Object> params);
	
	public int getTotal();
	public int getTotal(Map<String, Object> param);
	
	public List<BoardDTO> bbsSrch(Map<String, Object> param);

	//public void updateBbsInqCnt(int bbsSeq);
}
