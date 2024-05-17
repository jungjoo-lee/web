<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MemberMGR</title>
</head>
<body>
	<table width="800" bgcolor="black" cellspacing="1">
		<tr bgcolor="white">
			<th>아이디</th>
			<th>암호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="vo" items="${memberList}">
			<tr bgcolor="white">
				<td>${ vo.id }</td>
				<td>${ vo.pwd }</td>
				<td>${ vo.name }</td>
				<td>${ vo.phone }</td>
				<td align = 'center'><input type='button' value='수정' onClick='location.href=\updateForm.jsp?'></td>
            	<td align = 'center'><input type='button' value='삭제' onClick='location.href='></td>				
			</tr>
		</c:forEach>
	</table>
	<a href="InsertForm.jsp">멤버 추가</a>
</body>
</html>