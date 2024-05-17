package com.himedia.controller;

import java.util.ArrayList;
import java.util.List;

import com.himedia.dao.MemberDAO;
import com.himedia.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Action {	
	public String getMemberList(HttpServletRequest request, HttpServletResponse response) {
		List<MemberVO> memberList = new ArrayList<>();
		MemberDAO memberDAO = new MemberDAO();
		memberList = memberDAO.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		return "/CH04/MemberMGR.jsp";
	}
	
	public String insertPage(HttpServletRequest request, HttpServletResponse response) {
		return "/CH04/InsertForm.jsp";
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = MemberVO.builder().id(request.getParameter("userid")).pwd(request.getParameter("pwd")).name(request.getParameter("name")).phone(request.getParameter("phone")).build();
		memberDAO.insert(member);
	}
}
