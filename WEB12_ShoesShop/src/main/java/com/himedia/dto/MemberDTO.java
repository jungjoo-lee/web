package com.himedia.dto;

import java.sql.Timestamp;

import org.json.JSONObject;

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
	private int useyn;

	public MemberDTO() {}
	
	public MemberDTO(JSONObject json) {
		super();
		this.userid = json.getString("userid");
		this.pwd = json.getString("pwd");
		this.name = json.getString("name");
		this.phone = json.getString("phone");
		this.email = json.getString("email");
		this.zip_num = json.getString("zip_num");
		this.address1 = json.getString("address1");
		this.address2 = json.getString("address2");
	}
}
