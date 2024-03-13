package com.board.dao;

import java.util.List;

import com.board.domain.CmntDTO;

public interface CmntDAO {
	public List<CmntDTO> list(CmntDTO params) throws Exception;

	public Integer getMaxCmntSeq(CmntDTO params);

	public int regiCmnt(CmntDTO cmntDto);
	
	public int updateCmnt(CmntDTO dto);
	public int deleteCmnt(CmntDTO dto);
}
