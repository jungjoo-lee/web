<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>07_Format01.jsp</title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date()%>"/>
<h2>
	<fmt:formatDate value="${now}"/>
</h2>
</body>
</html>