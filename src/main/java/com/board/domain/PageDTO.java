package com.board.domain;

public class PageDTO {
	
	private int startPage;//게시글 화면에 보여질 첫번째 번호
	private int endPage;//게시글 화면에 보여질 페이징의 마지막 번호
	private boolean prev, next;//이전버튼, 다음버튼 활성화여부
	
	private int pageNum;//현재 페이지
	private int amount = 10;//한 페이지에 보여질 데이터 수
	private int displayPage = 10;
	private int total;//전체게시글 수 
	
	private int strtIndx;

	/*
	 * public PageDTO(int pageNum, int amount, int total) { this.endPage =
	 * (int)Math.ceil(this.pageNum / (double)displayPage)*displayPage;
	 * this.startPage = this.endPage - 10 + 1;
	 * 
	 * int totalPage = (int)Math.ceil(this.total / (double)this.amount);
	 * 
	 * if(this.endPage > totalPage) { this.endPage = totalPage; next = false; }else
	 * { next=true; }
	 * 
	 * this.prev = this.startPage > 1;
	 * 
	 * System.out.println("사직페이지:" + this.startPage + ", 끝페이지: "+this.endPage);
	 * this.strtIndx = (amount * (pageNum - 1)); }
	 */

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		paging();
	}

	public int getStrtIndx() {
		return strtIndx;
	}

	public void setStrtIndx(int strtIndx) {
		this.strtIndx = strtIndx;
	}
	
	private void paging() {
		
		if((total/amount) > displayPage ) {
			this.endPage = (int)Math.ceil(this.pageNum / (double)displayPage)*displayPage;
			this.startPage = this.endPage - 10 + 1;
		}else {
			this.endPage = (int)Math.ceil(total/(double)amount);
			this.startPage = 1;
		}
		
		
		int totalPage = (int)Math.ceil(this.total / (double)this.amount);
		
		if(this.endPage > totalPage) {
			this.endPage = totalPage;
			next = false;
		}else {
			next = totalPage>10;
		}
		
		this.prev = this.startPage > 1;
		
		System.out.println("사직페이지:" + this.startPage + ", 끝페이지: "+this.endPage);
	}
	
}
