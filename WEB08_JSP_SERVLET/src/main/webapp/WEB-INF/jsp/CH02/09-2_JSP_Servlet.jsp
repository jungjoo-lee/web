<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>09-2_JSP_Servlet.jsp</title>
</head>
<body>
<h1>
ID : <%= request.getAttribute("id") %><br/><br/>
PWD : <%= request.getAttribute("pwd") %><br/><br/>
GENDER : <%= request.getAttribute("gender") %><br/><br/>
CONTENT : <%= request.getAttribute("content") %><br/><br/>
ITEM : <%= request.getAttribute("item") %><br/><br/>
JOB : <%= request.getAttribute("job") %><br/><br/>
</h1>
</body>
</html>