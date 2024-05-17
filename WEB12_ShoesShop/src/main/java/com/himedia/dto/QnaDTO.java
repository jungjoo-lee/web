package com.himedia.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class QnaDTO {
	private int qseq;
	private String userid;
	private String subject;
	private String content;
	private String reply;
	private Timestamp indate;
}
