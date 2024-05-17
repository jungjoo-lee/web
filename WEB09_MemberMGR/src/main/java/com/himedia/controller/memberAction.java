package com.himedia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;

import com.himedia.dao.MemberDAO;
import com.himedia.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class memberAction {
	public String registerPage(HttpServletRequest request, HttpServletResponse response) {
		return "/member/registerPage.jsp";
	}
	
	public JSONObject register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		JSONObject jsonResult = new JSONObject();
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO member = MemberDTO.builder()
				.id(jsonObj.getString("userid"))
				.pwd(jsonObj.getString("pwd"))
				.name(jsonObj.getString("name1"))
				.phone(jsonObj.getString("phone"))
				.build();
		
		try {
			memberDAO.insertMember(member);
			jsonResult.put("status", true);
			jsonResult.put("url", "/WEB09_MemberMGR/index.do");
			jsonResult.put("message", "멤버 추가 성공");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "빨리 가입하지 뭐했노");
		}		
		
		return jsonResult;
	}
	
	public String updatePage(HttpServletRequest request, HttpServletResponse response) {
		return "/member/registerPage.jsp";
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) {
			
	}
	
	public JSONObject delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		JSONObject jsonResult = new JSONObject();
		
		MemberDAO memberDAO = new MemberDAO();
		
		try {
			memberDAO.deleteMember(jsonObj.getString("userid"));
			jsonResult.put("status", true);
			jsonResult.put("url", "/WEB09_MemberMGR/index.do");
			jsonResult.put("message", "멤버 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "멤버 삭제 실패");
		}		
		
		return jsonResult;
	}
}