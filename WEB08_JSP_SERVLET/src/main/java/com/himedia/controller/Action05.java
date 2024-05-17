package com.himedia.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Action05 {
	public String a(HttpServletRequest request, HttpServletResponse response) {
		return "/CH05/02_ParameterNull.jsp";
	}
	
	public String jstl(HttpServletRequest request, HttpServletResponse response) {
		return "/CH05/03_JSTL.jsp";
	}
	
	public String foreach(HttpServletRequest request, HttpServletResponse response) {
		return "/CH05/06_FOREACH.jsp";
	}
	
	public String format01(HttpServletRequest request, HttpServletResponse response) {
		return "/CH05/07_Format01.jsp";
	}
}