<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>	
	<%
		// 각 JSP 파일에는 서버와 데이터를 주고받을수 있는 객체가 있습니다.
		// HttpServletRequest 자료형의 request 객체(요청객체)
		// HttpServletResponse 자료형의 response 객체(응답객체)
		// 입력란에 지정된 name 으로 파라미터의 value 를 요청합니다.
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String pwd_re= request.getParameter("pwd_re");
	%>
	<h3>
		성명 : <%= name %><br/>
		아이디 : <%= uid %><br/>
		비밀번호 : <%= pwd %><br/>
		비밀번호 확인 : <%= pwd_re %><br/>
	</h3>
</body>
</html>