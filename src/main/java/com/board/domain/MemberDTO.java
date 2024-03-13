package com.board.domain;

public class MemberDTO extends BaseDTO {
	private String mbrId;
	private String mbrPwd;
	private String mbrNm;
	
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getMbrPwd() {
		return mbrPwd;
	}
	public void setMbrPwd(String mbrPwd) {
		this.mbrPwd = mbrPwd;
	}
	public String getMbrNm() {
		return mbrNm;
	}
	public void setMbrNm(String mbrNm) {
		this.mbrNm = mbrNm;
	}
	
	
}
