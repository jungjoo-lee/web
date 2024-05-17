<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>07-2_ServerObject.jsp</title>
</head>
<body>
<h1>
second의 pageContext 객체 : " <%= pageContext.getAttribute("name") %><br/>
second의 request 객체 : " <%= request.getAttribute("name") %><br/>
second의 session 객체 : " <%= session.getAttribute("name") %><br/>
second의 application 객체 : " <%= application.getAttribute("name") %><br/>
</h1>
</body>
</html>