package com.himedia.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.JSONObject;

import com.himedia.dao.MemberDAO;
import com.himedia.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MemberAction {
	public String loginForm(HttpServletRequest request, HttpServletResponse response) {
		return "/member/loginForm.jsp";
	}
	
	public JSONObject login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		JSONObject jsonResult = new JSONObject();
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = null;
		
		try {
			if (!jsonObj.getString("userid").equals("") && jsonObj.getString("userid") != null) {
				if (jsonObj.getString("userid").equals("admin") && jsonObj.getString("pwd").equals("1234")) {
					jsonResult.put("status", true);
					jsonResult.put("message", "안녕하세요. 관리자님.");
					jsonResult.put("url", "/WEB12_ShoesShop/admin/adminForm.do");
					
					return jsonResult;
				}
					
				memberDTO = memberDAO.getMember(jsonObj.getString("userid"));
				
				if (memberDTO.getPwd().equals(jsonObj.getString("pwd"))) {
					HttpSession session = request.getSession(false);
					session.setAttribute("loginUser", memberDTO);
					
					jsonResult.put("status", true);
					jsonResult.put("message", "안녕하세요. " + memberDTO.getName() + "님.");
					jsonResult.put("url", "/WEB12_ShoesShop/index.do");
				} else {
					jsonResult.put("status", false);
					jsonResult.put("message", "오류");
				}
			} else {
				jsonResult.put("status", false);
				jsonResult.put("message", "오류");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
	
	public String joinForm(HttpServletRequest request, HttpServletResponse response) {
		return "/member/joinForm.jsp";
	}
	
	public JSONObject idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonStr = in.readLine();
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		JSONObject jsonResult = new JSONObject();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		
		try {
			dto = dao.getMember(jsonObj.getString("userid"));
			
			if(dto == null) {
				jsonResult.put("status", true);
				jsonResult.put("message", "사용가능한 아이디입니다.");
			} else {
				jsonResult.put("status", false);
				jsonResult.put("message", "빨리 가입하지 그랬노");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
	
	public JSONObject send_auth(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonStr = in.readLine();
        JSONObject jsonObj = new JSONObject(jsonStr);
        
        JSONObject jsonResult = new JSONObject();

        try {
	        Random r = new Random();
	        String authNum = String.valueOf(r.nextInt(888888) + 111111);
	
	        String host = "smtp.gmail.com";
	        String user = "briniclel@gmail.com";
	        String password = "hrry sofk rpqu chmf";
	
	        // 이메일 내용 설정
	        String to = jsonObj.getString("email");
	        String subject = "Subject Here";
	        String body = "Your authentication number is: " + authNum;
	
	        Properties props = new Properties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	
	        javax.mail.Session session = Session.getDefaultInstance(props, new Authenticator() {
	            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                return new javax.mail.PasswordAuthentication(user, password);
	            }
	        });
	
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(user));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        message.setSubject(subject);
	        message.setText(body);
	
	        Transport.send(message);
	        
	        jsonResult.put("status", true);
			jsonResult.put("message", "이메일 확인부탁드립니다.");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
		
		return jsonResult;
	}
	
	public JSONObject join(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonStr = in.readLine();
        JSONObject jsonObj = new JSONObject(jsonStr);
        
        JSONObject jsonResult = new JSONObject();
        MemberDAO dao = new MemberDAO();
        
        try {
        	dao.join(MemberDTO.builder()
        			.userid(jsonObj.getString("userid"))
        			.pwd(jsonObj.getString("pwd"))
        			.name(jsonObj.getString("userName"))
        			.phone(jsonObj.getString("phone"))
        			.email(jsonObj.getString("email"))
        			.zip_num(jsonObj.getString("zip_code"))
        			.address1(jsonObj.getString("address1"))
        			.address2(jsonObj.getString("address2"))
        			.build());
        	jsonResult.put("status", true);
        	jsonResult.put("message", "회원가입 성공");
        	jsonResult.put("url", "/WEB12_ShoesShop/index.do");
        } catch (Exception e) {
			e.printStackTrace();
			jsonResult.put("status", false);
			jsonResult.put("message", "오류");
		}
        
        return jsonResult;
	}
}
