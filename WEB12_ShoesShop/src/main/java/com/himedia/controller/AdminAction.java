package com.himedia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himedia.dao.AdminDAO;
import com.himedia.dao.PageDTO;
import com.himedia.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminAction {
	public String adminForm(HttpServletRequest request, HttpServletResponse response) {		
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> memberList = null;
		
		int total = dao.getTotalMember();
		int currentPage = 1;
		int amount = 10;
		PageDTO pageDTO = new PageDTO(currentPage, amount, total);
		
		try {
			memberList = dao.getMemberList(pageDTO.getAmount(), pageDTO.getCurrentPage());
			
			request.setAttribute("memberList", memberList);
			request.setAttribute("page", pageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/admin/adminForm.jsp";
	}
	
	public JSONObject updateContent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		JSONObject jsonResult = new JSONObject();
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> memberList = null;
		
		int total = dao.getTotalMember();
		int currentPage = jsonObj.getInt("page");
		int amount = jsonObj.getInt("amount");
		PageDTO pageDTO = new PageDTO(currentPage, amount, total);
		
		ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(pageDTO);
		
		try {
			memberList = dao.getMemberList(pageDTO.getAmount(), pageDTO.getCurrentPage());
			
			jsonResult.put("status", true);
			jsonResult.put("memberList", memberList);
			jsonResult.put("page", new JSONObject(jsonString));
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
	
	public JSONObject updateUseyn(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonResult = new JSONObject();
		
		try {
			jsonResult.put("status", true);
			jsonResult.put("message", "수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "실패");
		}
		
		return jsonResult;
	}
	
	public JSONObject deleteForce(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonResult = new JSONObject();
		
		try {
			jsonResult.put("status", true);
			jsonResult.put("message", "삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "실패");
		}

		return jsonResult;
	}
}
