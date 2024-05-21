package com.himedia.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.himedia.dao.ProductDAO;
import com.himedia.dao.ProductImageDAO;
import com.himedia.dto.ProductDTO;
import com.himedia.dto.ProductImageDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductImageAction {
	public void writeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		ProductDAO pDAO = new ProductDAO();
		ProductImageDAO piDAO = new ProductImageDAO();
		
		try {
			ProductDTO pDTO = pDAO.getProductName(pseq);
			ProductImageDTO piDTO = piDAO.getProductImage(pseq);
			
			String imagePath = "c:\\upload\\";
	        File imageFile = new File(imagePath + pseq + pDTO.getName() + "\\" + piDTO.getRealName());
	        
	        if (imageFile.exists()) {
	            response.setContentType("image/jpeg");
	            FileInputStream fis = new FileInputStream(imageFile);
	            OutputStream os = response.getOutputStream();
	            
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) != -1) {
	                os.write(buffer, 0, bytesRead);
	            }
	            os.close();
	            fis.close();
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
