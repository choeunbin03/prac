package com.board.domain;

import java.util.Date;

public class BaseDTO {

	private String rgtrId;
	private Date   rgtrDt;
	private String mdfrId;
	private Date   mdfrDt;
	
	public String getRgtrId() {
		return rgtrId;
	}
	public void setRgtrId(String rgtrId) {
		this.rgtrId = rgtrId;
	}
	
	public Date getRgtrDt() {
		return rgtrDt;
	}
	public void setRgtrDt(Date rgtrDt) {
		this.rgtrDt = rgtrDt;
	}
	
	public String getMdfrId() {
		return mdfrId;
	}
	public void setMdfrId(String mdfrId) {
		this.mdfrId = mdfrId;
	}
	
	public Date getMdfrDt() {
		return mdfrDt;
	}
	public void setMdfrDt(Date mdfrDt) {
		this.mdfrDt = mdfrDt;
	}
}
