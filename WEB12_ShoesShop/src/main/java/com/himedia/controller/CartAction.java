package com.himedia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.json.JSONObject;

import com.himedia.dao.CartDAO;
import com.himedia.dto.CartDTO;
import com.himedia.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartAction {
	public String cartForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
	    MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
	    
	    if (dto == null) {
	    	return "/member/loginForm.jsp";
	    } else {
	    	CartDAO dao = new CartDAO();
			List<CartDTO> cartList = null;
			int totalPrice = 0;
			
			try {
				cartList = dao.getCartList(dto.getUserid());
				request.setAttribute("cartList", cartList);
				
				for(CartDTO cartDTO : cartList) {
					totalPrice += cartDTO.getPrice() * cartDTO.getQuantity();
				}
				
				request.setAttribute("totalPrice", totalPrice);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	    	return "/cart/cartForm.jsp";
		}
	}
	
	public JSONObject addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		JSONObject jsonResult = new JSONObject();
		CartDAO dao = new CartDAO();
		HttpSession session = request.getSession(false);
	    MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
		
		try {
			dao.addCart(CartDTO.builder()
					.userid(dto.getUserid())
					.pseq(Integer.parseInt(jsonObj.getString("pseq")))
					.quantity(Integer.parseInt(jsonObj.getString("quantity")))
					.build());
			jsonResult.put("status", true);
			jsonResult.put("message", "장바구니에 추가 성공");
			jsonResult.put("url", "/WEB12_ShoesShop/cart/cartList.do");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
}
