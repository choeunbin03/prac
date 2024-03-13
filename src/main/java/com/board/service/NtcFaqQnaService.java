package com.board.service;

import java.util.List;
import java.util.Map;

import com.board.domain.NtcFaqQnaDTO;
import com.board.domain.PageDTO;

public interface NtcFaqQnaService {

	public List<NtcFaqQnaDTO> list(Map<String, Object> param) throws Exception;

	public int regiQstn(NtcFaqQnaDTO dto) throws Exception;
	public int regiNtc(NtcFaqQnaDTO dto) throws Exception;

	public int regi(NtcFaqQnaDTO dto) throws Exception;

	NtcFaqQnaDTO view(int bbsSeq);

	public int update(NtcFaqQnaDTO dto);

	public int delete(int bbsSeq);
	
	public int getTotal();
	public int getTotalByType(Map<String, Object> param);
	
	public List<NtcFaqQnaDTO> nfqSrch(Map<String, Object> param);
	
	public List<NtcFaqQnaDTO> mngList(PageDTO pageDTO) throws Exception;

	
}
