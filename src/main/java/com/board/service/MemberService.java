package com.board.service;

import com.board.domain.MemberDTO;

public interface MemberService {

	MemberDTO login(MemberDTO dto);

	public int join(MemberDTO memberDto) throws Exception;

}
