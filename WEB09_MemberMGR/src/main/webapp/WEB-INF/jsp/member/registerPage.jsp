<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>registerPage.jsp</title>
</head>
<body>
	<h2>회원의 정보 입력 폼</h2>
	<form method="post" action="register.do">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" id="userid" size="20"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" id="pwd" size="20"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name1" id="name1" size="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" id="phone" size="11"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"
					id="registerButton"> <input type="reset" value="취소">
					<input type="button" value="돌아가기""></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
	let registerButton = document.querySelector("#registerButton");
	registerButton.onclick = (e) => {
		e.preventDefault();
		jsInsert();
	}
	
	function jsInsert () {
		if (confirm("가입 하시겠습니까?") == true) {
			let param = {
				"userid" : userid.value,
				"pwd" : pwd.value,
				"name1" : name1.value,
				"phone" : phone.value,
			};
					
			fetch('/WEB09_MemberMGR/register.do', {
				method : 'POST',
				headers: {
					'Content-Type': 'application/json;charset=utf-8'
				},
					body: JSON.stringify(param)
				})
				.then(response => response.json())
				.then(jsonResult => {
					alert(jsonResult.message);
					if (jsonResult.status == true) {
						location.href = jsonResult.url;
					}
			});
		} else return;
	}
	</script>
</body>
</html>