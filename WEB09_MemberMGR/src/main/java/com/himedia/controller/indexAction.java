package com.himedia.controller;

import com.himedia.dao.MemberDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class indexAction {
	public String index(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO memberDAO = new MemberDAO();
		request.setAttribute("memberList", memberDAO.getMemberList());
		
		return "/index/index.jsp";
	}
}