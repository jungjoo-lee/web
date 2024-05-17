package com.himedia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;

import com.himedia.dao.MemberDAO;
import com.himedia.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MemberAction {
	public String loginForm(HttpServletRequest request, HttpServletResponse response) {
		return "/member/loginForm.jsp";
	}
	
	public String joinForm(HttpServletRequest request, HttpServletResponse response) {
		return "/member/joinForm.jsp";
	}
	
	public String mainForm(HttpServletRequest request, HttpServletResponse response) {
		return "/main/main.jsp";
	}
	
	public JSONObject login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		JSONObject jsonResult = new JSONObject();
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = null;
		
		try {
			if (!jsonObj.getString("userid").equals("") && jsonObj.getString("userid") != null) {
				memberDTO = memberDAO.getMember(jsonObj.getString("userid"));
				
				if (memberDTO.getPwd().equals(jsonObj.getString("pwd"))) {
					HttpSession session = request.getSession(false);
					session.setAttribute("member", memberDTO);
					
					jsonResult.put("status", true);
					jsonResult.put("message", "안녕하세요. " + memberDTO.getName() + "님.");
					jsonResult.put("url", "/WEB10_Board/main.do");
				} else {
					jsonResult.put("status", false);
					jsonResult.put("message", "오류");
				}
			} else {
				jsonResult.put("status", false);
				jsonResult.put("message", "오류");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
	
	public JSONObject idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		JSONObject jsonResult = new JSONObject();
		
		String userid = jsonObj.getString("userid");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = null;
		try {
			memberDTO = memberDAO.getMember(userid);
			
			if (memberDTO != null) {
				jsonResult.put("status", true);
				jsonResult.put("message", "중복된 아이디입니다.");
			} else {
				jsonResult.put("status", false);
				jsonResult.put("userid", userid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
	public JSONObject join(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		JSONObject jsonResult = new JSONObject();
		
		MemberDAO memberDAO = new MemberDAO();

		try {
			memberDAO.insertMember(MemberDTO.builder()
					.userid(jsonObj.getString("userid"))
					.pwd(jsonObj.getString("pwd"))
					.name(jsonObj.getString("name1"))
					.email(jsonObj.getString("email"))
					.phone(jsonObj.getString("phone"))
					.build());
			jsonResult.put("status", true);
			jsonResult.put("message", "가입성공");
			jsonResult.put("url", "/WEB10_Board/loginform.do");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
}
