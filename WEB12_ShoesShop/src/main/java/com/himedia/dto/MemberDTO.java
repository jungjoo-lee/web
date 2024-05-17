package com.himedia.dto;

import java.sql.Timestamp;

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
	private String phone;
	private String email;
	private String zip_num;
	private String address1;
	private String address2;
	private Timestamp indate;
	private char useyn;
}
