package com.himedia.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.himedia.dao.ProductDAO;
import com.himedia.dao.ProductImageDAO;
import com.himedia.dto.ProductDTO;
import com.himedia.dto.ProductImageDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductAction {
	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		return "/product/insertForm.jsp";
	}
	
	public JSONObject insertProduct(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonResult = new JSONObject();
		ProductDAO pDAO = new ProductDAO();
		ProductImageDAO piDAO = new ProductImageDAO();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			Map<String, List<FileItem>> mapItems = upload.parseParameterMap(request);
			
			int price1 = Integer.parseInt(mapItems.get("price1").get(0).getString());
			int price2 = Integer.parseInt(mapItems.get("price2").get(0).getString());
			pDAO.insertProduct(
					ProductDTO.builder()
					.name(new String(mapItems.get("productName").get(0).getString().getBytes("ISO-8859-1"), "UTF-8"))
					.kind(new String(mapItems.get("kind").get(0).getString().getBytes("ISO-8859-1"), "UTF-8").charAt(0))
					.price1(price1)
					.price2(price2)
					.price3(price2 - price1)
					.content(new String(mapItems.get("content").get(0).getString().getBytes("ISO-8859-1"), "UTF-8"))
					.build());
			
			try {
				int productNum = pDAO.lastProductID();
				String filePath = "c:\\upload\\" + productNum + new String(mapItems.get("productName").get(0).getString().getBytes("ISO-8859-1"), "UTF-8");
				
				File uploadDir = new File(filePath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                
				factory.setRepository(uploadDir);
				
				for (int i = 0; i < mapItems.get("imageFile").size(); i++) {
					if (mapItems.get("imageFile").get(i).getSize() > 0) {
						String realName = "upload" + System.currentTimeMillis();
						piDAO.insertProductImages(
								ProductImageDTO.builder()
								.pseq(productNum)
								.orgName(mapItems.get("imageFile").get(i).getName().toString())
								.realName(realName)
								.filesize(mapItems.get("imageFile").get(i).getSize())
								.build());
						File saveFile = new File(filePath + "\\" + realName);
						mapItems.get("imageFile").get(i).write(saveFile);
					}
				}
				
				jsonResult.put("status", true);
//				jsonResult.put("url", "/WEB12_ShoesShop/product/productView.do?pseq=" + pseq);
				jsonResult.put("url", "/WEB12_ShoesShop/index.do");
				jsonResult.put("message", "성공");
			} catch (Exception e) {
				e.printStackTrace();
				jsonResult.put("status", false);
				jsonResult.put("message", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
	public String listByCategory(HttpServletRequest request, HttpServletResponse response) {
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> productList = null;
		
		try {
			productList = dao.listByCategory(request.getParameter("kind").charAt(0));
			request.setAttribute("productList", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/product/listByCategory.jsp";
	}
	
	public String productView(HttpServletRequest request, HttpServletResponse response) {
		ProductDTO dto;
		ProductDAO dao = new ProductDAO();
		
		try {
			dto = dao.getProduct(Integer.parseInt(request.getParameter("pseq")));
			request.setAttribute("product", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/product/productView.jsp";
	}
}
