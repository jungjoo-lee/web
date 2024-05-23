<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>loginForm.jsp</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty loginUser}">
			<a href="">LOGIN</a>
			<a href="">JOIN</a>
			<a href="">Find Id/Pw</a>
		</c:when>
		<c:otherwise>
			<a href="">update MEMBER</a>
			<a href="">LOGOUT</a>
		</c:otherwise>
	</c:choose>
	
	<form method="post" action="<c:url value='/member/login.do'/>">
		<h2>LogIn</h2>
		<label>User ID</label>
		<input name="userid" id="userid" type="text" placeholder="userid" value="admin"/><br/>
		<label>Password</label>
		<input name="pwd" id="pwd" type="password" placeholder="password" value="1234"/><br/>
		<input type="submit" name="loginBtn" id="loginBtn" value="LOGIN"/>
		<input type="button" value="JOIN"/>
		<input type="button" value="FIND ID"/>
	</form>
	<script type="text/javascript" src="<c:url value='/resources/js/member/loginForm.js'/>"></script>
</body>
</html>