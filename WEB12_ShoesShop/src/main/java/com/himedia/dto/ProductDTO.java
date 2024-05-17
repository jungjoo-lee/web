package com.himedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductDTO {
	private int pseq;
	private String name;
	private char kind;
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private char bestyn;
	private char useyn;
	private Timestamp indate;
}
