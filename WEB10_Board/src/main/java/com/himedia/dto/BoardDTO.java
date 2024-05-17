package com.himedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BoardDTO {
	private int num;
	private String pass;
	private String userid;
	private String email;
	private String title;
	private String content;
	private int readCount;
	private Timestamp writeDate;
}