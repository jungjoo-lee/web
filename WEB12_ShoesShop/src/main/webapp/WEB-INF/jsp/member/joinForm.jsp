<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>joinForm.jsp</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<form action="<c:url value='/member/join.do'/>" method="post">
		<label>User ID</label>
		<input type="text" name="userid" id="userid">
		<input type="button" name="idCheckBtn" id="idCheckBtn" value="중복 체크"><br/>
		<label>Password</label>
		<input type="password" name="pwd" id="pwd"><br/>
		<label>Retype</label>
		<input type="password" name="pwdCheck" id="pwdCheck"><br/>
		<label>Name</label>
		<input type="text" name="userName" id="userName"><br/>
		<label>Phone</label>
		<input type="text" name="phone" id="phone"><br/>
		<label>E-Mail</label>
		<input type="text" name="email" id="email">
		<input type="button" name="send_auth" id="send_auth" value="인증번호 받기"/><br/>
		
		<h3>Optional Info</h3>
		<label>Zip Code</label>
		<input type="text" name="zip_code" id="zip_code" readonly="readonly">
		<input type="button" name="zipCodeBtn" id="zipCodeBtn" value="우편번호 찾기"><br/>
		<label>Address</label>
		<input type="text" name="address1" id="address1" readonly><br/>
		<label>detail Address</label>
		<input type="text" name="address2" id="address2"><br/>
		
		<input type="button" name="joinBtn" id="joinBtn" value="회원가입">
		<input type="button" name="mainBtn" id="mainBtn" value="메인으로">
	</form>
	<script type="text/javascript" src="<c:url value='/resources/js/member/joinForm.js'/>"></script>
</body>
</html>