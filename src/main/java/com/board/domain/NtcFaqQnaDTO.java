package com.board.domain;

public class NtcFaqQnaDTO extends BaseDTO{

	private int nfqSeq;
	private int nfqType;	//1:공지, 2:faq, 3:qna
	private String nfqTtl;
	private String qstnCn;
	private String ansCn;
	private char ansYn;
	private int atchFileNo;
	public int getNfqSeq() {
		return nfqSeq;
	}
	public void setNfqSeq(int nfqSeq) {
		this.nfqSeq = nfqSeq;
	}
	public int getNfqType() {
		return nfqType;
	}
	public void setNfqType(int nfqType) {
		this.nfqType = nfqType;
	}
	public String getNfqTtl() {
		return nfqTtl;
	}
	public void setNfqTtl(String nfqTtl) {
		this.nfqTtl = nfqTtl;
	}
	public String getQstnCn() {
		return qstnCn;
	}
	public void setQstnCn(String qstnCn) {
		this.qstnCn = qstnCn;
	}
	public String getAnsCn() {
		return ansCn;
	}
	public void setAnsCn(String ansCn) {
		this.ansCn = ansCn;
	}
	public char getAnsYn() {
		return ansYn;
	}
	public void setAnsYn(char ansYn) {
		this.ansYn = ansYn;
	}
	public int getAtchFileNo() {
		return atchFileNo;
	}
	public void setAtchFileNo(int atchFileNo) {
		this.atchFileNo = atchFileNo;
	}
	
	
	
}
