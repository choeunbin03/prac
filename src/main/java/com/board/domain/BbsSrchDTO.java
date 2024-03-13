package com.board.domain;

public class BbsSrchDTO {
	
	private int type;	//0: 제목, 1: 작성자
	private String keyWd;
	/*
	public BbsSrchDTO(int type, String keyWd) {
		this.type = type;
		this.keyWd = keyWd;
	}
	*/
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getKeyWd() {
		return keyWd;
	}

	public void setKeyWd(String keyWd) {
		this.keyWd = keyWd;
	}
	
	
	

}
