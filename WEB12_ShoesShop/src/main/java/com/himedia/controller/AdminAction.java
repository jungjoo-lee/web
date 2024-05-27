package com.himedia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himedia.dao.AdminDAO;
import com.himedia.dto.MemberDTO;
import com.himedia.dto.PageDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminAction {
	public String adminForm(HttpServletRequest request, HttpServletResponse response) {		
		AdminDAO dao = AdminDAO.getInstance();
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
		AdminDAO dao = AdminDAO.getInstance();
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
	
	public JSONObject updateUseyn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		JSONObject jsonResult = new JSONObject();
		AdminDAO dao = AdminDAO.getInstance();
		List<String> useridList = parseList(jsonObj);
		
		try {
			dao.useynMemberToggle(useridList);
			jsonResult.put("status", true);
			jsonResult.put("message", "수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "실패");
		}
		
		return jsonResult;
	}
	
	public JSONObject deleteForce(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		JSONObject jsonResult = new JSONObject();
		AdminDAO dao = AdminDAO.getInstance();
		List<String> useridList = parseList(jsonObj);
		
		try {
			dao.deleteForce(useridList);
			jsonResult.put("status", true);
			jsonResult.put("message", "삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "실패");
		}

		return jsonResult;
	}
	
	public List<String> parseList(JSONObject jsonObj) {
		JSONArray checkList = jsonObj.getJSONArray("checkList");
		List<String> resultList = new ArrayList<>();
		
		for (int i = 0; i < checkList.length(); i++) {
			resultList.add(checkList.getString(i));
		}
		
		return resultList;
	}
	
	public JSONObject keyword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		List<String> resultList = null;
		AdminDAO dao = AdminDAO.getInstance();
		
		JSONObject jsonResult = new JSONObject();
		
		try {
			resultList = dao.keyword(jsonObj.getString("kind"), jsonObj.getString("keyword"));
			jsonResult.put("status", true);
			jsonResult.put("resultList", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
		}
		
		return jsonResult;
	}
	
	public static String decompose(String input) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch >= 0xAC00 && ch <= 0xD7A3) {
                int unicode = ch - 0xAC00;
                int cho = unicode / (21 * 28);
                int jung = (unicode % (21 * 28)) / 28;
                int jong = unicode % 28;

                result.append((char) (cho + 0x1100));
                result.append((char) (jung + 0x1161));
                if (jong != 0) {
                    result.append((char) (jong + 0x11A7));
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
