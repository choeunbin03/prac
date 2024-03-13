package com.board.domain;

public class BookmarkDTO extends BaseDTO{
	private String mbrId;
	private String bmkTtl;
	private String bmkUrl;
	
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getBmkTtl() {
		return bmkTtl;
	}
	public void setBmkTtl(String bmkTtl) {
		this.bmkTtl = bmkTtl;
	}
	public String getBmkUrl() {
		return bmkUrl;
	}
	public void setBmkUrl(String bmkUrl) {
		this.bmkUrl = bmkUrl;
	}	
	
}
