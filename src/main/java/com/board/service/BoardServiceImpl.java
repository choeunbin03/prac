package com.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.board.dao.BoardDAO;
import com.board.domain.BoardDTO;
import com.board.domain.PageDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> list(PageDTO pageDto) throws Exception{
		List<BoardDTO>  result = boardDAO.list(pageDto);
		return result;
	}
	
	@Override
	public int regi(BoardDTO dto) throws Exception{
		//int maxSeq = dao.getMaxBbsSeq();
		
		if(boardDAO.getMaxBbsSeq() == null) {//게시글이 존재하지 않을 때,
			
			dto.setBbsSeq(1);//SEQ는 1
		}else {//게시글이 존재할 때
			dto.setBbsSeq(boardDAO.getMaxBbsSeq() + 1);//최대값에 +1
		}
		
		return boardDAO.regi(dto);
		
		/*
		 * dto.setBbsSeq(++maxSeq); int result = dao.regi(dto); return result;
		 */
	}
	
	 @Override
	public void updateBbsInqCnt(int bbsSeq) {
		 boardDAO.updateBbsInqCnt(bbsSeq); 
	}

	
	@Override
	public BoardDTO view(int bbsSeq) {
		return boardDAO.view(bbsSeq);
	}
	
	@Override
	public int update(BoardDTO dto) {
		return boardDAO.update(dto);
	}
	
	@Override
	public int delete(int bbsSeq) {
		return boardDAO.delete(bbsSeq);
	}
	
	@Override
	public void updateBbsSpt(int bbsSeq) {
		boardDAO.updateBbsSpt(bbsSeq);
	}
	/*
	 * public BoardDTO updateBbsSpt(int bbsSeq) { boardDAO.updateBbsSpt(bbsSeq);
	 * return boardDAO.view(bbsSeq); }
	 */
	
	@Override
	public String checkBbsSptYn(Map<String, Object> params) {
		String result = boardDAO.checkBbsSptYn(params);
		return result;
	}

	@Override
	public int getTotal() {
		int result = boardDAO.getTotal();
		return result;
	}

	@Override
	public int getTotal(Map<String, Object> param) {
		int result = boardDAO.getTotal(param);
		return result;
	}
	
	@Override
	public List<BoardDTO> bbsSrch(Map<String, Object> param) {
		List<BoardDTO>  result = boardDAO.bbsSrch(param);
		return result;
	}

}
