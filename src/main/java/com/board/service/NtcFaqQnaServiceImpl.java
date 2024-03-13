package com.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.board.dao.NtcFaqQnaDAO;
import com.board.domain.NtcFaqQnaDTO;
import com.board.domain.PageDTO;

@Service
public class NtcFaqQnaServiceImpl implements NtcFaqQnaService{

	@Inject
	private NtcFaqQnaDAO ntcFaqQnaDAO;

	@Override
	public List<NtcFaqQnaDTO> list(Map<String, Object> param) throws Exception{
		List<NtcFaqQnaDTO> result = ntcFaqQnaDAO.list(param);
		return result;
	}

	@Override
	public int regiQstn(NtcFaqQnaDTO dto) throws Exception {
		int result = ntcFaqQnaDAO.regiQstn(dto);
		return result;
	}
	
	@Override
	public int regiNtc(NtcFaqQnaDTO dto) throws Exception {
		int result = ntcFaqQnaDAO.regiNtc(dto);
		return result;
	}
	
	@Override
	public int regi(NtcFaqQnaDTO dto) throws Exception{
		int result = ntcFaqQnaDAO.regi(dto);
		return result;
	}
	
	@Override
	public NtcFaqQnaDTO view(int nfqSeq) {
		return ntcFaqQnaDAO.view(nfqSeq);
	}
	
	@Override
	public int update(NtcFaqQnaDTO dto) {
		return ntcFaqQnaDAO.update(dto);
	}
	
	@Override
	public int delete(int nfqSeq) {
		return ntcFaqQnaDAO.delete(nfqSeq);
	}
	
	@Override
	public int getTotal() {
		int result = ntcFaqQnaDAO.getTotal();
		return result;
	}

	@Override
	public int getTotalByType(Map<String, Object> map) {
		int result = ntcFaqQnaDAO.getTotalByType(map);
		return result;
	}
	
	@Override
	public List<NtcFaqQnaDTO> nfqSrch(Map<String, Object> param) {
		List<NtcFaqQnaDTO>  result = ntcFaqQnaDAO.nfqSrch(param);
		return result;
	}

	@Override
	public List<NtcFaqQnaDTO> mngList(PageDTO pageDTO) throws Exception {
		List<NtcFaqQnaDTO> result = ntcFaqQnaDAO.mngList(pageDTO);
		return result;
	}

	
	
}
