package com.board.domain;

/*CREATE TABLE board(
	    bbsSeq NUMBER,
	    bbsTtl VARCHAR2(200),
	    bbsCn VARCHAR2(1000),
	    mbrId VARCHAR2(20),
	    rgtrDt VARCHAR2(100),
	    bbsInqCnt NUMBER
	);*/

public class BoardDTO extends BaseDTO{
	private int bbsSeq;
	private String bbsTtl;
	private String bbsCn;
	private int bbsInqCnt;
	private int bbsSpt;
	private int atchFileNo;
	
	private int cmntSeq;
	private String cmntCn;
	
	
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public String getBbsTtl() {
		return bbsTtl;
	}
	public void setBbsTtl(String bbsTtl) {
		this.bbsTtl = bbsTtl;
	}
	public String getBbsCn() {
		return bbsCn;
	}
	public void setBbsCn(String bbsCn) {
		this.bbsCn = bbsCn;
	}
	public int getBbsInqCnt() {
		return bbsInqCnt;
	}
	public void setBbsInqCnt(int bbsInqCnt) {
		this.bbsInqCnt = bbsInqCnt;
	}
	public int getBbsSpt() {
		return bbsSpt;
	}
	public void setBbsSpt(int bbsSpt) {
		this.bbsSpt = bbsSpt;
	}
	public int getAtchFileNo() {
		return atchFileNo;
	}
	public void setAtchFileNo(int atchFileNo) {
		this.atchFileNo = atchFileNo;
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
