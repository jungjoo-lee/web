package com.himedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrdersDTO {
	private int oseq;
	private String userid;
	private Timestamp indate;
}
