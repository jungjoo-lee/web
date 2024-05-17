package com.himedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductImageDTO {
	private int piseq;
	private int pseq;
	private String orgName;
	private String realName;
	private long filesize;
}
