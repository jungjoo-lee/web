package com.himedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String phone;
}