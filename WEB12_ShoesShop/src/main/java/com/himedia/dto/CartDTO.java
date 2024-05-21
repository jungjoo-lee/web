package com.himedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CartDTO {
	private int cseq;
	private String userid;
	private int pseq;
	private String name;
	private int quantity;
	private int price;
	private Timestamp indate;
}
