package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;
import com.board.domain.CmntDTO;

public interface CmntService {
	public List<CmntDTO> list(CmntDTO params) throws Exception;

	public int regiCmnt(CmntDTO cmntDto) throws Exception;

	
	public int updateCmnt(CmntDTO dto);

	public int deleteCmnt(CmntDTO dto);
	
}
