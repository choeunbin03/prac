package com.board.domain;

import java.util.Date;

public class SptInqCntDTO extends BaseDTO{
	private int bbsSeq;
	private String mbrId;
	private String bbsSptYn;
	private int bbsInqCnt;
	private Date inqCntMdfrDt;
	
	
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getBbsSptYn() {
		return bbsSptYn;
	}
	public void setBbsSptYn(String bbsSptYn) {
		this.bbsSptYn = bbsSptYn;
	}
	public int getBbsInqCnt() {
		return bbsInqCnt;
	}
	public void setBbsInqCnt(int bbsInqCnt) {
		this.bbsInqCnt = bbsInqCnt;
	}
	public Date getInqCntMdfrDt() {
		return inqCntMdfrDt;
	}
	public void setInqCntMdfrDt(Date inqCntMdfrDt) {
		this.inqCntMdfrDt = inqCntMdfrDt;
	}
	
	
}
