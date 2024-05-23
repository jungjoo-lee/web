package com.himedia.dao;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage;
	private int endPage;
	private int currentPage;
	private int amount;
	private int total;
	private int realEnd;
	private boolean prev;
	private boolean next;

	public PageDTO(int currentPage, int amount, int total) {
		this.currentPage = currentPage;
		this.amount = amount;
		this.total = total;
		this.endPage = (int)Math.ceil(this.currentPage * 0.1) * 10;
		this.startPage = this.endPage - 10 + 1;
		this.realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		if(this.currentPage > realEnd) {
			this.currentPage = 1;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
