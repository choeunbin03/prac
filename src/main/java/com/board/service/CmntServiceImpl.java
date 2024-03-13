package com.board.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.board.dao.CmntDAO;
import com.board.domain.CmntDTO;

@Service
public class CmntServiceImpl implements CmntService{
	
	@Inject
	private CmntDAO cmntDAO;
	
	@Override
	public List<CmntDTO> list(CmntDTO params) throws Exception{
		List<CmntDTO>  aa = cmntDAO.list(params);
		return aa;
	}
	

	@Override
	public int updateCmnt(CmntDTO dto) {
		int result = cmntDAO.updateCmnt(dto);
		return result;
	}
	
	@Override
	public int deleteCmnt(CmntDTO dto) {
		int result = cmntDAO.deleteCmnt(dto);
		return result;
	}

	@Override
	public int regiCmnt(CmntDTO cmntDto) throws Exception {
		
		int result = -1;
		int cmntMaxSeq = cmntDAO.getMaxCmntSeq(cmntDto);
		if(cmntMaxSeq < 1) {
			cmntDto.setCmntSeq(1);
		}else {
			cmntDto.setCmntSeq(++cmntMaxSeq);
		}
		result = cmntDAO.regiCmnt(cmntDto);
		return result;
	}

	
}
