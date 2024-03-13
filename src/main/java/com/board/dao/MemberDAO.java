package com.board.dao;

import com.board.domain.MemberDTO;

public interface MemberDAO {
	public MemberDTO login(MemberDTO dto);

	public int join(MemberDTO memberDto) throws Exception;
}
