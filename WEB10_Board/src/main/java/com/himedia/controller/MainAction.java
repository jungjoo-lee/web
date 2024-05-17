package com.himedia.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainAction {
	public String mainForm(HttpServletRequest request, HttpServletResponse response) {
		return "/main/main.jsp";
	}
}
