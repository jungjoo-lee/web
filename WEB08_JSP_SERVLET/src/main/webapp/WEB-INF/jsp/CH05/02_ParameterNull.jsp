<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>02_ParameterNull.jsp</title>
</head>
<body>
<h3>JSP 코드 : <%= request.getParameter("id") %></h3>
<h3>EL 코드 : ${param.id}</h3>
</body>
</html>