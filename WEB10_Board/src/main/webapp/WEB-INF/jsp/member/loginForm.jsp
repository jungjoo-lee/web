<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>loginForm.jsp</title>
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
<script type="text/javascript" src="<c:url value='/resources/js/login.js'/>"></script>
</head>
<body>
	<form class="login-form">
		<h2>Login</h2>
		<div class="field">
			<label>User ID</label> <input type="text" id="userid">
		</div>
		<div class="field">
			<label>Password</label> <input type="password" id="pwd">
		</div>

		<div class="login-button">
			<button class="btn-login" id="loginBtn">log in</button>
			<button type="button" class="btn-login" id="joinBtn">join</button>
		</div>
		<div class="sns-login">
			<button class="btn facebook">Facebook</button>
			<button class="btn twitter">Twitter</button>
			<button class="btn google">Google</button>
			<button class="btn kakao">Kakao</button>
		</div>
	</form>
	<script>
		let joinBtn = document.querySelector("#joinBtn");
		
		joinBtn.onclick = () => {
			location.href = "/WEB10_Board/joinform.do";
		}
		
		let loginBtn = document.querySelector("#loginBtn");
		
		loginBtn.onclick = (e) => {
			e.preventDefault();
			
			login();
		}
		
		function login() {
			let param = {
	    			"userid" : userid.value,
	    			"pwd" : pwd.value,
	       		};
	       		
	       		fetch('/WEB10_Board/login.do', {
	   				method : 'POST',
	   				headers: {
	   					'Content-Type': 'application/json;charset=utf-8'
	   				},
	   					body: JSON.stringify(param)
	   				})
	   				.then(response => response.json())
	   				.then(jsonResult => {
	   					if (jsonResult.status == true) {
	   						alert(jsonResult.message);
	   						location.href = jsonResult.url;
	   					} else {
	   	   					alert(jsonResult.message);
	   					}
	    		});
		}
	</script>
</body>
</html>