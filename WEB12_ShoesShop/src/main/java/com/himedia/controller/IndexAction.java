package com.himedia.controller;

import com.himedia.dao.ProductDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexAction {
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "/index/index.jsp";
	}
}
