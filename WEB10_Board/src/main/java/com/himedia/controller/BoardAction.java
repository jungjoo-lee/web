package com.himedia.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.himedia.dao.BoardDAO;
import com.himedia.dto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardAction {
	public JSONObject getBoardList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject jsonResult = new JSONObject();		
		List<BoardDTO> boardList = new ArrayList<>();
		BoardDAO boardDAO = new BoardDAO();
		
		try {
			boardList = boardDAO.getBoardList();
			jsonResult.put("status", true);
			jsonResult.put("boardList", boardList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
	
	public String registerForm(HttpServletRequest request, HttpServletResponse response) {
		return "/board/registerForm.jsp";
	}
	
	public JSONObject register(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonResult = new JSONObject();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File("c:\\upload"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			Map<String, List<FileItem>> mapItems = upload.parseParameterMap(request);

			System.out.println(mapItems.get("userid"));
			System.out.println(mapItems.get("userid").get(0));
			System.out.println(mapItems.get("userid").get(0).getString());
			System.out.println(mapItems.get("pass").get(0).getString());
			System.out.println(new String(mapItems.get("title").get(0).getString().getBytes("ISO-8859-1"), "UTF-8"));
			System.out.println(new String(mapItems.get("content").get(0).getString().getBytes("ISO-8859-1"), "UTF-8"));			
			
			jsonResult.put("status", true);
			jsonResult.put("message", "성공");
			jsonResult.put("url", "/");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
}
