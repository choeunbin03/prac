package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.domain.NtcFaqQnaDTO;
import com.board.domain.PageDTO;

public interface NtcFaqQnaDAO {

	public List<NtcFaqQnaDTO> list(Map<String, Object> param) throws Exception;

	public Integer getMaxNfqSeq();

	public int regiQstn(NtcFaqQnaDTO dto);
	public int regiNtc(NtcFaqQnaDTO dto) throws Exception;

	public int regi(NtcFaqQnaDTO dto);

	NtcFaqQnaDTO view(int nfqSeq);

	public int update(NtcFaqQnaDTO dto);
	public int delete(int nfqSeq);
	
	public int getTotal();
	public int getTotalByType(Map<String, Object> map);
	
	public List<NtcFaqQnaDTO> nfqSrch(Map<String, Object> param);
	
	public List<NtcFaqQnaDTO> mngList(PageDTO pageDTO) throws Exception;

}
