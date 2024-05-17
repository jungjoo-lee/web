package com.himedia.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String phone;
}
