package com.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.board.dao.SptInqCntDAO;
import com.board.domain.SptInqCntDTO;

@Service
public class SptInqCntServiceImpl implements SptInqCntService{
	
	@Inject
	private SptInqCntDAO sptInqCntDAO;
	
	//@Override
	//public SptInqCntDTO updateBbsSpt(int bbsSeq) {
	//	sptInqCntDAO.updateBbsSpt(bbsSeq);
	//	return sptInqCntDAO.view(bbsSeq);
	//}
	
	@Override
	public void insertBbsSpt(Map<String, Object> param) {
		sptInqCntDAO.insertBbsSpt(param);
	}

}
