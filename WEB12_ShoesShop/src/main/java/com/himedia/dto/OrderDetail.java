package com.himedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderDetail {
	private int odseq;
	private int oseq;
	private int pseq;
	private int quantity;
	private char result;
}
