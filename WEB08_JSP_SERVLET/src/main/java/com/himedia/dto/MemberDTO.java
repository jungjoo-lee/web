package com.himedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberDTO {
	private String userid;
	private String pwd;
	private String name;
	private String nickName;
	private String email;
	private String phone;
}