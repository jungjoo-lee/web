<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>08-1_Login_forward_servlet.jsp</title>
</head>
<body>
<form method="post" action="../login.do">
	<label for="userid">아이디 : </label><input type="text" name="id" id="userid"><br/> 
	<label for="userpwd">암호 : </label><input type="password" name="pwd" id="userpwd"><br/>
	<input type="submit" value="로그인">
</form>
</body>
</html>