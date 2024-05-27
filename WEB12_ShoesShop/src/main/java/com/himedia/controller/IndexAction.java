package com.himedia.controller;

import java.util.List;

import com.himedia.dao.ProductDAO;
import com.himedia.dto.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexAction {
	public String index(HttpServletRequest request, HttpServletResponse response) {
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> bestList = null;
		List<ProductDTO> newList = null;
		
		try {
			bestList = dao.bestList();
			newList = dao.newList();
			request.setAttribute("bestList", bestList);
			request.setAttribute("newList", newList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/index/index.jsp";
	}
}
