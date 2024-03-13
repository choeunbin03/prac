package com.board.domain;

import java.util.Date;

public class CmntDTO  extends BaseDTO {
	private int bbsSeq;
	private int cmntSeq;
	private String cmntCn;
	


	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	
	public int getCmntSeq() {
		return cmntSeq;
	}
	public void setCmntSeq(int cmntSeq) {
		this.cmntSeq = cmntSeq;
	}
	public String getCmntCn() {
		return cmntCn;
	}
	public void setCmntCn(String cmntCn) {
		this.cmntCn = cmntCn;
	}
	

}
