<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>06-3_ForwardResult.jsp</title>
</head>
<body>
<%
String name = (String)request.getAttribute("name");
String age = request.getParameter("age");
%>

<h2>forword 방식으로 이동된 페이지</h2>
<h2>나이 : <%= age %></h2>
<h2>이름 : <%= name %></h2>
</body>
</html>