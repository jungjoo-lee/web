<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>08-2_loginOk.jsp</title>
</head>
<body>
<h1>
<%= request.getAttribute("name") %>님 ㅎㅇ
<%= request.getParameter("id") %>
</h1>
</body>
</html>